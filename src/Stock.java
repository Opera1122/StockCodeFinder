import org.jsoup.helper.HttpConnection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Stock {
    /**
     * <h3>국내 주식 종목코드 검색 API</h3>
     */

    public String stockName;

    private static final String URL = "https://kr.investing.com/search/?q=";
    private static final String TAG = "js-inner-all-results-quotes-wrapper newResultsContainer quatesTable";

    private Document document;
    private Element outer;
    private Elements inner;
    private String code;

    private Stock() {
    }

    public Stock(String stockName) {
        this.stockName = stockName;
    }

    public String getCode() {
        try {
            document = HttpConnection.connect(URL + this.stockName).get();
            outer = document.body().getElementsByClass(TAG).get(0);
            inner = outer.getElementsByClass("second");
            code = inner.get(0).text();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (char c : code.toCharArray())
            if (!Character.isDigit(c)) return "000000";

        return code;
    }
}

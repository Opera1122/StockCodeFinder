```java
public class Main {
    public static void main(String[] args) {
        Stock 삼성 = new Stock("삼성전자");
        Stock 기아 = new Stock("기아");
        Stock 카카오 = new Stock("카카오");

        System.out.println(삼성.getCode());     //  005930
        System.out.println(기아.getCode());     // 000270
        System.out.println(카카오.getCode());  // 035720
    }
}
```

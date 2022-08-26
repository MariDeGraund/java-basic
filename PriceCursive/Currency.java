package PriceCursive;

public interface Currency {
    String[] currency = new String[3];

    default String getCurrency(int i) {
        return currency[i];
    }
}

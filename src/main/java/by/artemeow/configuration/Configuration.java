package by.artemeow.configuration;

public class Configuration {
    private static Configuration instance;
    private String productFileName;
    private String discountCardFileName;
    private final Double DISCOUNT = 10.0;
    private final Integer QUANTITY_FOR_PROMOTION = 5;
    private Configuration(String productFileName, String discountCardFileName) {
        this.productFileName = productFileName;
        this.discountCardFileName = discountCardFileName;
    }

    public static void initialize(String productFileName, String discountCardFileName) {
        if (instance == null) {
            instance = new Configuration(productFileName, discountCardFileName);
        }
    }

    public static Configuration getInstance() {
        return instance;
    }

    public String getProductFileName() {
        return productFileName;
    }

    public String getDiscountCardFileName() {
        return discountCardFileName;
    }

    public Double getDISCOUNT() {
        return DISCOUNT;
    }

    public Integer getQUANTITY_FOR_PROMOTION() {
        return QUANTITY_FOR_PROMOTION;
    }
}

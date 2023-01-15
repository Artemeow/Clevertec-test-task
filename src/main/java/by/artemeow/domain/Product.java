package by.artemeow.domain;

public class Product {

    private Long id;
    private Double price;
    private String name;
    private Boolean isPromotional;

    public Product() {
    }

    public Product(Long id, Double price, String name, Boolean isPromotional) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.isPromotional = isPromotional;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getPromotional() {
        return isPromotional;
    }

    public void setPromotional(Boolean promotional) {
        isPromotional = promotional;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", isPromotional=" + isPromotional +
                '}';
    }
}

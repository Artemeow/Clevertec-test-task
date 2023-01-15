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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != null ? !id.equals(product.id) : product.id != null) return false;
        if (price != null ? !price.equals(product.price) : product.price != null) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        return isPromotional != null ? isPromotional.equals(product.isPromotional) : product.isPromotional == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (isPromotional != null ? isPromotional.hashCode() : 0);
        return result;
    }
}

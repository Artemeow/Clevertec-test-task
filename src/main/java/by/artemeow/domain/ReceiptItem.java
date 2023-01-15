package by.artemeow.domain;

public class ReceiptItem {

    private String name;
    private Integer quantity;
    private Double price;
    private Double total;
    private Boolean isPromotional;

    public ReceiptItem(String name, Integer quantity, Double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.total = 0.0;
        this.isPromotional = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getPromotional() {
        return isPromotional;
    }

    public void setPromotional(Boolean promotional) {
        isPromotional = promotional;
    }

    @Override
    public String toString() {
        return "ReceiptItem{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", total=" + total +
                ", isPromotional=" + isPromotional +
                '}';
    }
}

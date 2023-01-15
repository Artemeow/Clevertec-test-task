package by.artemeow.domain;

public class DiscountCard {

    private Long id;
    private Integer discount;

    public DiscountCard() {
    }

    public DiscountCard(Long id, Integer discount) {
        this.id = id;
        this.discount = discount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "DiscountCard{" +
                "id=" + id +
                ", discount=" + discount +
                '}';
    }
}

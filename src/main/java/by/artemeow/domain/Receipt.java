package by.artemeow.domain;

import java.time.Instant;
import java.util.List;

public class Receipt {

    private final Long id;
    private final Instant createdDate;
    private final List<ReceiptItem> items;
    private final Double total;
    private final Double discountAmount;
    private final Double totalWithDiscount;

    private Receipt(Builder builder) {
        this.id = builder.id;
        this.createdDate = builder.createdDate;
        this.items = builder.items;
        this.total = builder.total;
        this.discountAmount = builder.discountAmount;
        this.totalWithDiscount = builder.totalWithDiscount;
    }

    public Long getId() {
        return id;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public List<ReceiptItem> getItems() {
        return items;
    }

    public Double getTotal() {
        return total;
    }

    public Double getDiscountAmount() {
        return discountAmount;
    }

    public Double getTotalWithDiscount() {
        return totalWithDiscount;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "id=" + id +
                ", createdDate=" + createdDate +
                ", items=" + items +
                ", total=" + total +
                ", discountAmount=" + discountAmount +
                ", totalWithDiscount=" + totalWithDiscount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Receipt receipt = (Receipt) o;

        if (items != null ? !items.equals(receipt.items) : receipt.items != null) return false;
        if (total != null ? !total.equals(receipt.total) : receipt.total != null) return false;
        if (discountAmount != null ? !discountAmount.equals(receipt.discountAmount) : receipt.discountAmount != null)
            return false;
        if (totalWithDiscount != null ? !totalWithDiscount.equals(receipt.totalWithDiscount) : receipt.totalWithDiscount != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = items != null ? items.hashCode() : 0;
        result = 31 * result + (total != null ? total.hashCode() : 0);
        result = 31 * result + (discountAmount != null ? discountAmount.hashCode() : 0);
        result = 31 * result + (totalWithDiscount != null ? totalWithDiscount.hashCode() : 0);
        return result;
    }

    public static class Builder {

        private static Long idCounter = 1l;
        private Long id;
        private Instant createdDate;
        private List<ReceiptItem> items;
        private Double total;
        private Double discountAmount;
        private Double totalWithDiscount;

        public Builder() {
            this.id = idCounter++;
            this.createdDate = Instant.now();
        }

        public Builder items(List<ReceiptItem> items) {
            this.items = items;
            return this;
        }

        public Builder total(Double total) {
            this.total = total;
            return this;
        }

        public Builder discountAmount(Double discountAmount) {
            this.discountAmount = discountAmount;
            return this;
        }

        public Builder totalWithDiscount(Double totalWithDiscount) {
            this.totalWithDiscount = totalWithDiscount;
            return this;
        }

        public Receipt build() {
            return new Receipt(this);
        }
    }
}

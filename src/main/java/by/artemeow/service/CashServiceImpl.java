package by.artemeow.service;

import by.artemeow.configuration.Configuration;
import by.artemeow.domain.DiscountCard;
import by.artemeow.domain.Receipt;
import by.artemeow.domain.ReceiptItem;

import java.util.List;

public class CashServiceImpl implements CashService {

    @Override
    public Receipt calculate(List<ReceiptItem> items, DiscountCard card) {

        items.forEach(this::calculateTotal);

        double total = items.stream()
                .mapToDouble(ReceiptItem::getTotal)
                .sum();

        double discountAmount = 0L;

        if (card != null) {
            discountAmount = total * (card.getDiscount() / 100.0);
        }

        return new Receipt.Builder()
                .items(items)
                .total(total)
                .discountAmount(discountAmount)
                .totalWithDiscount(total - discountAmount)
                .build();
    }

    public void calculateTotal(ReceiptItem item) {
        var configInstance = Configuration.getInstance();
        double total = item.getQuantity() * item.getPrice();
        boolean isPromotional = item.getQuantity() > configInstance.getQUANTITY_FOR_PROMOTION();
        double totalWithDiscount = isPromotional ? total * ((100 - configInstance.getDISCOUNT()) / 100) : total;
        item.setTotal(totalWithDiscount);
        item.setPromotional(isPromotional);
    }
}

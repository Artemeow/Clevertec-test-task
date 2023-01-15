package by.artemeow.service;

import by.artemeow.domain.DiscountCard;
import by.artemeow.domain.Receipt;
import by.artemeow.domain.ReceiptItem;

import java.util.List;

public interface CashService {

    Receipt calculate(List<ReceiptItem> items, DiscountCard card);

}

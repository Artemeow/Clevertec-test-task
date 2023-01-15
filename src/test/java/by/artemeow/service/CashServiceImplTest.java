package by.artemeow.service;

import by.artemeow.configuration.Configuration;
import by.artemeow.domain.DiscountCard;
import by.artemeow.domain.Receipt;
import by.artemeow.domain.ReceiptItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CashServiceImplTest {

    private List<ReceiptItem> receiptItemList;
    CashServiceImpl cashService = new CashServiceImpl();

    @BeforeAll
    private void setUp() {
        Configuration.initialize("","");
        receiptItemList = List.of(
                new ReceiptItem("Tea", 5, 13.50),
                new ReceiptItem("Meat", 6, 87.00),
                new ReceiptItem("Milk", 1, 7.99));
    }

    @Test
    public void calculateReceiptWithoutDiscountCard() {

        List<ReceiptItem> receiptItemList = List.of(
                new ReceiptItem("Tea", 5, 13.50),
                new ReceiptItem("Meat", 6, 87.00),
                new ReceiptItem("Milk", 1, 7.99));

        Receipt actual = new Receipt.Builder()
                .items(receiptItemList)
                .total(545.29)
                .discountAmount(0.0)
                .totalWithDiscount(545.29)
                .build();

        Receipt expected = cashService.calculate(receiptItemList, null);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void calculateReceiptWithDiscountCard() {

        DiscountCard discountCard = new DiscountCard(1L, 10);

        Receipt actual = new Receipt.Builder()
                .items(receiptItemList)
                .total(545.29)
                .discountAmount(54.528999999999996)
                .totalWithDiscount(490.76099999999997)
                .build();

        Receipt expected = cashService.calculate(receiptItemList, discountCard);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void calculateTotal() {
        ReceiptItem expected = new ReceiptItem("Tea", 5, 13.50);
        cashService.calculateTotal(expected);

        ReceiptItem actual = new ReceiptItem("Tea", 5, 13.50);

        actual.setTotal(67.5);
        actual.setPromotional(false);

        Assertions.assertEquals(expected, actual);
    }
}
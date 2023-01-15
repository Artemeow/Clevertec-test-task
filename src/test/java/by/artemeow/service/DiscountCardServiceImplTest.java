package by.artemeow.service;

import by.artemeow.configuration.Configuration;
import by.artemeow.domain.DiscountCard;
import by.artemeow.domain.ReceiptItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DiscountCardServiceImplTest {

    DiscountCardService discountCardService = new DiscountCardServiceImpl();

    @BeforeAll
    private void setUp() {
        Configuration.initialize("","cards.csv");
    }

    @Test
    void findById() {
        DiscountCard actual = new DiscountCard(2L, 22);

        List<DiscountCard> discountCardList = List.of(
                new DiscountCard(1L, 10),
                actual,
                new DiscountCard(3L, 12));

        DiscountCard expected = discountCardService.findById(2L);

        Assertions.assertEquals(expected, actual);
    }
}
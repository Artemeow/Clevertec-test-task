package by.artemeow.repository;

import by.artemeow.configuration.Configuration;
import by.artemeow.domain.DiscountCard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DiscountCardRepoImplTest {

    DiscountCardRepo repo = new DiscountCardRepoImpl();

    @BeforeAll
    private void setUp() {
        Configuration.initialize("","cards.csv");
    }

    @Test
    void findAll() {

        List<DiscountCard> actual = List.of(
                new DiscountCard(1L, 15),
                new DiscountCard(2L, 22),
                new DiscountCard(3L, 8));

        List<DiscountCard> expected = repo.findAll();

        Assertions.assertEquals(expected, actual);
    }
}
package by.artemeow.repository;

import by.artemeow.configuration.Configuration;
import by.artemeow.domain.DiscountCard;
import by.artemeow.domain.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ProductRepoImplTest {

    ProductRepo repo = new ProductRepoImpl();

    @BeforeAll
    private void setUp() {
        Configuration.initialize("products.csv","");
    }

    @Test
    void findAll() {

        List<Product> actual = List.of(
                new Product(1L, 16.0, "Green Tea", true),
                new Product(2L, 900.0, "Meat", false),
                new Product(3L, 6.0, "Ice Cream", true));

        List<Product> expected = repo.findAll();

        Assertions.assertEquals(expected, actual);
    }
}
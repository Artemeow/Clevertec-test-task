package by.artemeow.service;

import by.artemeow.domain.Product;
import by.artemeow.domain.ReceiptItem;
import by.artemeow.repository.ProductRepo;
import by.artemeow.repository.ProductRepoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {

    private ProductRepo repo = new ProductRepoImpl();

    @Override
    public List<ReceiptItem> createReceiptItems(List<String> productsFromCommandLine) {

        List<Product> products = repo.findAll();

        List<ReceiptItem> receiptItems = new ArrayList<>();

        productsFromCommandLine.forEach(line -> {
            var value = line.split("-");//value[0] - id, value[1] - quantity

            Optional<Product> foundProduct = products.stream()
                    .filter(product -> product.getId().equals(Long.valueOf(value[0])))
                    .findFirst();

            if (foundProduct.isPresent()) {
                Product product = foundProduct.get();
                receiptItems.add(new ReceiptItem(product.getName(), Integer.valueOf(value[1]), product.getPrice()));
            } else {
                throw new RuntimeException("Не найден продукт с id=" + value[0]);
            }
        });

        return receiptItems;
    }
}

package by.artemeow.utils;

import by.artemeow.domain.Product;

public class CsvProductReader extends BaseCsvReader<Product> implements BaseReader<Product> {

    @Override
    public Product parseToEntity(String line, String[] header) {
        String[] values = line.split(";");
        Product product = new Product();
        for (int i = 0; i < header.length; i++) {
            if (values[i].isEmpty()) continue;
            switch (header[i]) {
                case "id" -> product.setId(Long.valueOf(values[i]));
                case "name" -> product.setName(values[i]);
                case "price" -> product.setPrice(Double.valueOf(values[i]));
                case "isPromotional" -> product.setPromotional(Boolean.valueOf(values[i]));
            }
        }

        return product;
    }
}

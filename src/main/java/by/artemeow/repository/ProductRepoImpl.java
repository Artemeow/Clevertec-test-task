package by.artemeow.repository;

import by.artemeow.configuration.Configuration;
import by.artemeow.domain.Product;
import by.artemeow.utils.BaseReader;
import by.artemeow.utils.CsvProductReader;

import java.util.List;

public class ProductRepoImpl implements ProductRepo {

    @Override
    public List<Product> findAll() {
        BaseReader<Product> reader = new CsvProductReader();
        return reader.readFile(Configuration.getInstance().getProductFileName());
    }
}

package by.artemeow.repository;

import by.artemeow.domain.Product;
import java.util.List;

public interface ProductRepo {

    List<Product> findAll();
}

package by.artemeow.service;

import by.artemeow.domain.ReceiptItem;

import java.util.List;

public interface ProductService {

    List<ReceiptItem> createReceiptItems(List<String> productsFromCommandLine);

}

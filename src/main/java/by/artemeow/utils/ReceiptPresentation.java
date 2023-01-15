package by.artemeow.utils;

import by.artemeow.domain.Receipt;

public interface ReceiptPresentation {

    String toWritableString(Receipt receipt);
}

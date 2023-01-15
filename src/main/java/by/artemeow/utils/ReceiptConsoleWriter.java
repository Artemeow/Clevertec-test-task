package by.artemeow.utils;

import by.artemeow.domain.Receipt;

public class ReceiptConsoleWriter implements ReceiptWriter {

    ReceiptPresentation receiptPresentation = new SimpleReceiptPresentation();
    @Override
    public void write(Receipt receipt) {
        var result = receiptPresentation.toWritableString(receipt);

        System.out.println(result);

    }
}

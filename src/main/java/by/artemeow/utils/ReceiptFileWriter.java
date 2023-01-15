package by.artemeow.utils;

import by.artemeow.domain.Receipt;

import java.io.FileWriter;
import java.io.IOException;

public class ReceiptFileWriter implements ReceiptWriter {
    ReceiptPresentation receiptPresentation = new SimpleReceiptPresentation();
    @Override
    public void write(Receipt receipt) {
        var result = receiptPresentation.toWritableString(receipt);

        try {
            FileWriter fw = new FileWriter("receipt.txt");
            fw.write(result);
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при записи чека в файл");
        }
    }
}

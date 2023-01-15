package by.artemeow.utils;

import by.artemeow.configuration.Configuration;
import by.artemeow.domain.Receipt;
import by.artemeow.domain.ReceiptItem;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class SimpleReceiptPresentation implements ReceiptPresentation {
    @Override
    public String toWritableString(Receipt receipt) {

        StringBuilder sb = new StringBuilder();
        sb.append("----------------------------------------------\n");
        sb.append("|                CASH RECEIPT                |\n");
        sb.append("|              Supermarket 123               |\n");
        sb.append("|               Tel: 55-77-11                |\n");
        sb.append("|CASHIER: №27                DATE: " + getStringDateInFormat(receipt.getCreatedDate(),  "dd/MM/yyyy") + "|\n");
        sb.append("|                            TIME: " + getStringDateInFormat(receipt.getCreatedDate(),  "HH:mm:ss") + "  |\n");
        sb.append("|--------------------------------------------|\n");
        sb.append("|QTY  DESCRIPTION           PRICE    TOTAL   |\n");
        for (ReceiptItem item: receipt.getItems()) {
            sb.append(getStringRepresentation(item));
        }
        sb.append("|============================================|\n");
        sb.append(String.format("|TOTAL                           $%-10.2f |\n", receipt.getTotal()));
        if(receipt.getDiscountAmount() != 0L) {
            sb.append(String.format("|DISCOUNT BY CARD                $%-10.2f |\n", receipt.getDiscountAmount()));
        }sb.append(String.format("|AMOUNT PAYABLE                  $%-10.2f |\n", receipt.getTotalWithDiscount()));
        sb.append("----------------------------------------------\n");

        return sb.toString();
    }

    private String getStringRepresentation(ReceiptItem item) {

        var result = String.format("|%-3s  %-20s  %-7.2f  %-8.2f|\n", item.getQuantity(), item.getName(), item.getPrice(), item.getTotal());

        if(item.getPromotional()) {
            result += String.format("|       promotional discount   %-4.2f %s       |\n", Configuration.getInstance().getDISCOUNT(), "%");
        }
        return result;
    }

    private String getStringDateInFormat(Instant instant, String pattern) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat(pattern);
        Date date = new Date(instant.toEpochMilli());

        return dateFormatter.format(date);
    }
}

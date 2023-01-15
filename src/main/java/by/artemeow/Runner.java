package by.artemeow;

import by.artemeow.configuration.Configuration;
import by.artemeow.domain.DiscountCard;
import by.artemeow.domain.Receipt;
import by.artemeow.domain.ReceiptItem;
import by.artemeow.exception.InvalidCommandLineParameterException;
import by.artemeow.service.*;
import by.artemeow.utils.ReceiptFileWriter;
import by.artemeow.utils.ReceiptWriter;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    static ProductService productService = new ProductServiceImpl();
    static DiscountCardService cardService = new DiscountCardServiceImpl();
    static CashService cashService = new CashServiceImpl();
    static ReceiptWriter receiptWriter = new ReceiptFileWriter();

    public static void main(String[] args) {

        try {
            List<ReceiptItem> receiptItems;
            DiscountCard card = null;

            List<String> productKeys = new ArrayList<>();
            long cardId = 0L;
            String productFilename = "", cardFilename = "";

            try {
                for (String arg : args) {
                    var param = arg.split("-");
                    if (param.length == 2) {
                        switch (param[0].toLowerCase()) {
                            case "card" -> cardId = Long.parseLong(param[1]);
                            case "cardfilename" -> cardFilename = param[1];
                            case "productfilename" -> productFilename = param[1];
                            default -> {
                                if (arg.matches("\\d+-\\d+")) {
                                    productKeys.add(arg);
                                } else {
                                    throw new InvalidCommandLineParameterException(arg);
                                }
                            }
                        }
                    } else {
                        throw new InvalidCommandLineParameterException(arg);
                    }
                }
            } catch (InvalidCommandLineParameterException e) {
                System.out.println(e.getMessage() + e.getArg());
            }

            Configuration.initialize(productFilename, cardFilename);

            if(Configuration.getInstance().getProductFileName().equals("")) {
                throw new RuntimeException("Путь к файлу с продуктами должен быть среди аргументов командой строки");
            } else {
                receiptItems = productService.createReceiptItems(productKeys);
            }

            if(Configuration.getInstance().getDiscountCardFileName().equals("")) {
                throw new RuntimeException("Путь к файлу с картами должен быть среди аргументов командой строки");
            } else {
                if(cardId != 0L) {
                    card = cardService.findById(cardId);
                }
            }

            Receipt receipt = cashService.calculate(receiptItems, card);

            receiptWriter.write(receipt);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

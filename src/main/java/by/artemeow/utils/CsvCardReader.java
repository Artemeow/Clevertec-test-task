
package by.artemeow.utils;

import by.artemeow.domain.DiscountCard;

public class CsvCardReader extends BaseCsvReader<DiscountCard> implements BaseReader<DiscountCard> {

    @Override
    public DiscountCard parseToEntity(String line, String[] header) {
        String[] values = line.split(";");
        DiscountCard card = new DiscountCard();
        for (int i = 0; i < header.length; i++) {
            if (values[i].isEmpty()) continue;
            switch (header[i]) {
                case "id" -> card.setId(Long.valueOf(values[i]));
                case "discount" -> card.setDiscount(Integer.valueOf(values[i]));
            }
        }

        return card;
    }

}


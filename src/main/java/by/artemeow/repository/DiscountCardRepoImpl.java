package by.artemeow.repository;

import by.artemeow.configuration.Configuration;
import by.artemeow.domain.DiscountCard;
import by.artemeow.utils.BaseReader;
import by.artemeow.utils.CsvCardReader;

import java.util.List;

public class DiscountCardRepoImpl implements DiscountCardRepo {
    @Override
    public List<DiscountCard> findAll() {
        BaseReader<DiscountCard> reader = new CsvCardReader();
        return reader.readFile(Configuration.getInstance().getDiscountCardFileName());
    }
}

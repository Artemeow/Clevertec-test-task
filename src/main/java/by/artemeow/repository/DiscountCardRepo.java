package by.artemeow.repository;

import by.artemeow.domain.DiscountCard;

import java.util.List;

public interface DiscountCardRepo {

    List<DiscountCard> findAll();

}

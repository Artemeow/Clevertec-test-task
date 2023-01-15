package by.artemeow.service;

import by.artemeow.domain.DiscountCard;
import by.artemeow.repository.DiscountCardRepo;
import by.artemeow.repository.DiscountCardRepoImpl;

import java.util.List;
import java.util.Optional;

public class DiscountCardServiceImpl implements DiscountCardService {

    private DiscountCardRepo repo = new DiscountCardRepoImpl();

    @Override
    public DiscountCard findById(Long id) {

        List<DiscountCard> cards = repo.findAll();

        Optional<DiscountCard> foundCard = cards.stream()
                .filter(card -> card.getId().equals(id))
                .findFirst();

        if (foundCard.isPresent()) {
            return foundCard.get();
        } else {
            throw new RuntimeException("Не найдена карта с id=" + id);
        }
    }
}

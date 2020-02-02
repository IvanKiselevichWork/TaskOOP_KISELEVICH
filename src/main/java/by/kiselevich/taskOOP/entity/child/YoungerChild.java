package by.kiselevich.taskOOP.entity.child;

import by.kiselevich.taskOOP.entity.toy.ToySize;
import by.kiselevich.taskOOP.repository.ToyRepository;

import java.math.BigDecimal;

public class YoungerChild extends Child {

    @Override
    public boolean receiveToys(ToyRepository toyRepository) {
        BigDecimal budgetPerHour = budget.divide(BigDecimal.valueOf(hours), BigDecimal.ROUND_DOWN);
        toys = toyRepository.getToysForSummaryCostWithSizesAndReturnTrifle(budgetPerHour, ToySize.BIG);
        if (toys.isEmpty()) {
            return false;
        } else {
            removeMoneyForToys();
            return true;
        }
    }
}

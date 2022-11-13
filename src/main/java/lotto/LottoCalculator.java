package lotto;

import java.util.List;
import java.util.Optional;

public class LottoCalculator {

    public static Optional<Rank> calculateRank(Lotto winningNumbers, Bonus bonus, Lotto ticket) {
        long matchCount = match(winningNumbers, ticket);
        return Rank.getRank((int) matchCount, containsBonus(ticket, bonus));
    }

    private static long match(Lotto winningNumbers, Lotto ticket) {
        List<Integer> numbers = winningNumbers.getNumbers();
        return ticket.getNumbers().stream().filter(numbers::contains).count();
    }

    private static boolean containsBonus(Lotto ticket, Bonus bonus) {
        return ticket.getNumbers().contains(bonus.getNumber());
    }
}

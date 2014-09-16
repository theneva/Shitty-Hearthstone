package fu.bar.card;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hand extends CardContainer
{
    public Hand()
    {
//        super(Configurator.getInstance().getIntProperty("handLimit"));
        super(7); // FIXME
    }

    public List<Card> discardAll()
    {
        final List<Card> discardedCards = new ArrayList<>();

        while (!cards.isEmpty())
        {
            discardedCards.add(cards.pop());
        }

        return discardedCards;
    }

    public Card discardRandom()
    {
        final Random random = new Random();
        return cards.remove(random.nextInt(cards.size()));
    }
}

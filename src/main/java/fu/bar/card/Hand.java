package fu.bar.card;

import fu.bar.Configurator;

import java.util.Random;
import java.util.Stack;

public class Hand extends CardContainer
{
    public Hand()
    {
        super(Configurator.getInstance().getIntProperty("handLimit"));
    }

    public Stack<Card> discardAll() {

        final Stack<Card> discardedCards = new Stack<>();

        while (!cards.isEmpty()) {
            discardedCards.add(cards.pop());
        }

        return discardedCards;
    }

    public Card discardRandomCard() {

        Random random = new Random();
        return cards.remove(random.nextInt(cards.size()));
    }
}

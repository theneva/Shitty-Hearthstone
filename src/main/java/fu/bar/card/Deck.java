package fu.bar.card;

import fu.bar.Configurator;

public class Deck extends CardContainer
{
    public Deck()
    {
        super(Configurator.getInstance().getIntProperty("deckLimit"));
    }

    public Card drawCard() throws EmptyDeckException
    {
        if (cards.isEmpty()) {
            throw new EmptyDeckException();
        }

        return cards.pop();
    }
}

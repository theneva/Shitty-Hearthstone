package fu.bar.card;

import fu.bar.Configurator;

import java.util.Random;

public class Hand extends CardContainer
{
    public Hand()
    {
        super(Configurator.getInstance().getIntProperty("handLimit"));
    }

    public void discardAll() {
        cards.clear();
    }

    public Card discardRandomCard() {

        Random random = new Random();
        return cards.remove(random.nextInt(cards.size()));
    }
}

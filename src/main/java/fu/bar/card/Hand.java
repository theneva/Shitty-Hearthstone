package fu.bar.card;

import fu.bar.Configurator;

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

        return null;
    }
}

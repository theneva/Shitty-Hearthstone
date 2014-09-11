package fu.bar.card;

import java.util.Stack;

public abstract class CardContainer
{
    protected final Stack<Card> cards = new Stack<>();

    protected final int cardLimit;

    public CardContainer(final int cardLimit)
    {
        this.cardLimit = cardLimit;
    }

    public Stack<Minion> getMinions()
    {
        final Stack<Minion> minions = new Stack<>();

        for (final Card card : cards)
        {
            if (card instanceof Minion)
            {
                minions.add((Minion) card);
            }
        }

        return minions;
    }

    public Stack<Spell> getSpells()
    {
        final Stack<Spell> spells = new Stack<>();

        for (final Card card : cards)
        {
            if (card instanceof Spell)
            {
                spells.add((Spell) card);
            }
        }

        return spells;
    }

    public int size() {
        return cards.size();
    }

    public boolean addCard(final Card card)
    {
        if (isFull())
        {
            return false;
        }

        cards.push(card);
        return true;
    }

    public Card removeCard()
    {
        return cards.pop();
    }

    private boolean isFull()
    {
        return cards.size() == cardLimit;
    }
}

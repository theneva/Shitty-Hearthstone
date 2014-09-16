package fu.bar.card;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public abstract class CardContainer
{
    protected final Stack<Card> cards = new Stack<>();

    protected final int cardLimit;

    public CardContainer(final int cardLimit)
    {
        this.cardLimit = cardLimit;
    }

    public List<Card> getCards() {
        final List<Card> cards = new ArrayList<>();

        for (final Card card : this.cards)
        {
            cards.add(card);
        }

        return cards;
    }

    public List<Minion> getMinions()
    {
        final List<Minion> minions = new ArrayList<>();

        for (final Card card : cards)
        {
            if (card instanceof Minion)
            {
                minions.add((Minion) card);
            }
        }

        return minions;
    }

    public List<Spell> getSpells()
    {
        final List<Spell> spells = new ArrayList<>();

        for (final Card card : cards)
        {
            if (card instanceof Spell)
            {
                spells.add((Spell) card);
            }
        }

        return spells;
    }

    public List<Weapon> getWeapons() {
        final List<Weapon> weapons = new ArrayList<>();

        for (final Card card : cards)
        {
            if (card instanceof Weapon)
            {
                weapons.add((Weapon) card);
            }
        }

        return weapons;
    }

    public int size()
    {
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

    public boolean isFull()
    {
        return cards.size() == cardLimit;
    }

    public boolean contains(final Card card)
    {
        return cards.contains(card);
    }

    public boolean isEmpty()
    {
        return size() == 0;
    }
}

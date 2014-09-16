package fu.bar.game;

import fu.bar.Configurator;
import fu.bar.card.Card;
import fu.bar.card.Deck;
import fu.bar.card.Hand;
import fu.bar.card.Minion;

import java.util.ArrayList;
import java.util.List;

public class Player
{
    private final List<Minion> activeMinions = new ArrayList<>();

    private String name;
    private Deck deck;
    private Hand hand;

    private final int activeMinionLimit = Configurator.getInstance().getIntProperty("playerBoardLimit");
    private int health;

    public Card drawCard()
    {
        final Card card = deck.drawCard();
        hand.addCard(card);
        return card;
    }

    public boolean addMinionToBoard(final Minion minion, final int position)
    {
        // Enough space?
        if (activeMinions.size() == activeMinionLimit)
        {
            return false;
        }

        // Valid index?
        if (position < 0 || position > activeMinions.size())
        {
            return false;
        }

        activeMinions.add(position, minion);
        return true;
    }

    public String getName()
    {
        return name;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public List<Minion> getActiveMinions()
    {
        return activeMinions;
    }

    public Deck getDeck()
    {
        return deck;
    }

    public void setDeck(final Deck deck)
    {
        this.deck = deck;
    }

    public Hand getHand()
    {
        return hand;
    }

    public void setHand(final Hand hand)
    {
        this.hand = hand;
    }

    public int getHealth()
    {
        return health;
    }

    public void setHealth(final int health)
    {
        this.health = health;
    }
}

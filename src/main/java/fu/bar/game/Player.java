package fu.bar.game;

import fu.bar.card.Card;
import fu.bar.card.Deck;
import fu.bar.card.Hand;
import fu.bar.card.Minion;

import java.util.Stack;

public class Player {

    private Deck deck;
    private Hand hand;
    private Stack<Minion> minionsInPlay = new Stack<>();

    public Card drawCard() {
        Card card = deck.drawCard();
        hand.addCard(card);
        return card;
    }

    public void setDeck(final Deck deck) {
        this.deck = deck;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setHand(final Hand hand) {
        this.hand = hand;
    }

    public Hand getHand() {
        return hand;
    }

    public Stack<Minion> getMinionsInPlay()
    {
        return minionsInPlay;
    }

    public void setMinionsInPlay(final Stack<Minion> minionsInPlay)
    {
        this.minionsInPlay = minionsInPlay;
    }
}

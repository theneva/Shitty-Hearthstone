package fu.bar.game;

import fu.bar.card.Card;
import fu.bar.card.Deck;
import fu.bar.card.Hand;

public class Player {

    private Deck deck;
    private Hand hand;

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

    public Card drawCard() {
        Card card = deck.drawCard();
        hand.addCard(card);
        return card;
    }
}

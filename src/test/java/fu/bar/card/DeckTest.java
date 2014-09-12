package fu.bar.card;

import org.junit.Test;

import static fu.bar.util.CardProvider.*;
import static org.junit.Assert.assertEquals;

public class DeckTest
{
    public void testDrawCard() {
        final Deck deck = new Deck();
        deck.addCard(getRagnaros());
        deck.addCard(getArcaneMissiles());
        deck.addCard(getAuctioneer());

        final Card card1 = deck.drawCard();
        assertEquals("The deck should contain 2 cards after drawing 1 from a deck of 3.", 2, deck.size());
        assertEquals("The first card drawn should be the last card added to the deck.", getAuctioneer(), card1);

        final Card card2 = deck.drawCard();
        final Card card3 = deck.drawCard();
        assertEquals("The deck should be empty after drawing all cards from a deck.", 0, deck.size());
    }

    @Test(expected = NoCardsLeftException.class)
    public void testDrawingCardFromEmptyDeckThrowsException() {
        final Deck deck = new Deck();
        deck.drawCard();
    }
}

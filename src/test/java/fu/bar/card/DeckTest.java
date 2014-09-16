package fu.bar.card;

import org.junit.Test;

import static fu.bar.util.CardHelper.*;
import static org.junit.Assert.assertEquals;

public class DeckTest
{
    @Test
    public void testDrawCard() {
        final Deck deck = new Deck();
        deck.addCard(getRagnaros());
        deck.addCard(getArcaneMissiles());
        deck.addCard(getAuctioneer());

        final Card card1 = deck.drawCard();
        assertEquals("The deck should contain 2 cards after drawing 1 from a deck of 3.", 2, deck.size());
        assertEquals("The first card drawn should be the last card added to the deck.", getAuctioneer(), card1);

        deck.drawCard();
        deck.drawCard();
        assertEquals("The deck should be empty after drawing all cards from a deck.", 0, deck.size());
    }

    @Test(expected = EmptyDeckException.class)
    public void testDrawingCardFromEmptyDeckThrowsException() {
        final Deck deck = new Deck();
        deck.drawCard();
    }
}

package fu.bar.card;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class HandTest
{
    @Test
    public void testDiscardRandomCard() throws Exception
    {
        final Hand hand = initializeHand();

        final Card discardedCard = hand.discardRandomCard();
        assertFalse("The hand should not contain the discarded card.", hand.contains(discardedCard));

        assertEquals("Discarding a random card should decrease hand size by 1.", 3, hand.size());
    }

    private Hand initializeHand() {
        final Hand hand = new Hand();

        hand.addCard(new Card("whatever", "whatever", 1));
        hand.addCard(new Card("whatever1", "whatever1", 1));
        hand.addCard(new Card("whatever2", "whatever2", 1));
        hand.addCard(new Card("whatever3", "whatever3", 1));
        return hand;
    }

    @Test
    public void testDiscardAll() {
        final Hand hand = initializeHand();

        Stack<Card> discardedCards = hand.discardAll();
        assertEquals("The hand size should be zero.", hand.size(), 0);
        assertEquals("The discard hand stack size should be equal to the initalizer's default size.", discardedCards.size(), initializeHand().size());
    }
}
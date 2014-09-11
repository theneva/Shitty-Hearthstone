package fu.bar.card;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HandTest
{
    @Test
    public void testDiscardRandomCard() throws Exception
    {
        final Hand hand = new Hand();

        hand.addCard(new Card("whatever", "whatever", 1));
        hand.addCard(new Card("whatever1", "whatever1", 1));
        hand.addCard(new Card("whatever2", "whatever2", 1));
        hand.addCard(new Card("whatever3", "whatever3", 1));

        final Card discardedCard = hand.discardRandomCard();

        assertEquals("Discarding a random card should decrease hand size by 1.", 3, hand.size());
    }
}

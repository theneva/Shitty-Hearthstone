package fu.bar.card;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static fu.bar.util.CardHelper.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class HandTest
{
    private Hand hand;

    @Before
    public void setUp() {
        hand = new Hand();

        hand.addCard(getRagnaros());
        hand.addCard(getArcaneMissiles());
        hand.addCard(getAuctioneer());
        hand.addCard(getArcaniteReaper());
    }

    @Test
    public void testDiscardRandomCard() throws Exception
    {
        final Card discardedCard = hand.discardRandom();
        assertFalse("The hand should not contain the discarded card.", hand.contains(discardedCard));
        assertEquals("Discarding a random card should decrease hand size by 1.", 3, hand.size());
    }

    @Test
    public void testDiscardAll() {
        final List<Card> actualCards = new ArrayList<>();

        for (final Card card : hand.getCards())
        {
            actualCards.add(card);
        }

        final List<Card> discardedCards = hand.discardAll();
        assertEquals("The hand size should be zero.", hand.size(), 0);
        assertEquals("The discard hand stack size should be equal to the hand's default size.", discardedCards.size(), actualCards.size());
    }
}

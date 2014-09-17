package fu.bar.game;

import fu.bar.card.Card;
import fu.bar.card.Deck;
import fu.bar.card.Hand;
import org.junit.Before;
import org.junit.Test;

import static fu.bar.util.CardHelper.*;
import static org.junit.Assert.*;

public class PlayerTest
{
    private Player player;

    @Before
    public void setUp()
    {
        player = new Player();
    }

    @Test
    public void testDrawCard()
    {
        final Deck deck = new Deck();
        deck.addCard(getRagnaros());
        deck.addCard(getArcaneMissiles());

        final Hand hand = new Hand();

        player.setDeck(deck);
        player.setHand(hand);

        final Card drawnCard = player.drawCard();

        assertEquals("The deck should contains 1 card after 1 draw.", 1, player.getDeck().size());
        assertEquals("The hand should contain 1 card after 1 draw.", 1, player.getHand().size());
        assertEquals("The hand should contain the card that was on top of the deck.", getArcaneMissiles(), drawnCard);
    }

    @Test
    public void testAddMinionToBoard()
    {
        assertTrue("It should be possible to add a Ragnaros to index 0.", player.addMinionToBoard(new ActiveMinion(getRagnaros()), 0));
        assertTrue("It should be possible to add an auctioneer to the right of Ragnaros.", player.addMinionToBoard(new ActiveMinion(getAuctioneer()), 1));
    }

    @Test
    public void testAddMinionToInvalidIndexReturnsFalse()
    {
        // Only 0 is a valid index on an empty board.
        assertFalse("Adding a minion to an invalid index (1 on a board with 0 minions) should return false.", player.addMinionToBoard(new ActiveMinion(getRagnaros()), 1));
    }
}

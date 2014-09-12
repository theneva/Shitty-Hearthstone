package fu.bar.game;

import fu.bar.card.Card;
import fu.bar.card.Deck;
import fu.bar.card.Hand;
import org.junit.Test;

import static fu.bar.util.CardProvider.getArcaneMissiles;
import static fu.bar.util.CardProvider.getRagnaros;
import static org.junit.Assert.assertEquals;

public class PlayerTest {
    @Test
    public void testDrawCard() {
        final Deck deck = new Deck();
        deck.addCard(getRagnaros());
        deck.addCard(getArcaneMissiles());

        final Hand hand = new Hand();

        final Player player = new Player();
        player.setDeck(deck);
        player.setHand(hand);

        final Card drawnCard = player.drawCard();

        assertEquals("The deck should contains 1 card after 1 draw.", 1, player.getDeck().size());
        assertEquals("The hand should contain 1 card after 1 draw.", 1, player.getHand().size());
        assertEquals("The hand should contain the card that was on top of the deck.", getArcaneMissiles(), drawnCard);
    }
}

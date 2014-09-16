package fu.bar.game;

import fu.bar.card.Deck;
import org.junit.Test;

import static fu.bar.util.CardHelper.*;
import static org.junit.Assert.assertEquals;

public class BoardTest
{
    @Test
    public void testAddPlayerToBoard()
    {
        final Deck deck = new Deck();
        deck.addCard(getRagnaros());
        deck.addCard(getArcaneMissiles());
        deck.addCard(getAuctioneer());

        final Player player = new Player();
        player.setDeck(deck);

        final Player player2 = new Player();
        player.setDeck(deck);

        final Board board = new Board();

        assertEquals("The first player should have index 0.", 0, board.addPlayer(player));
        assertEquals("The second player should have index 1.", 1, board.addPlayer(player));

        final Match match = new Match();
        match.setBoard(board);
    }
}

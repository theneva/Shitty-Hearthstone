package fu.bar;

import fu.bar.card.Deck;
import fu.bar.card.Hand;
import fu.bar.game.Player;

import javax.swing.*;
import java.awt.*;

import static fu.bar.util.CardHelper.getAuctioneer;
import static fu.bar.util.CardHelper.getRagnaros;

public class SwingFrontEnd extends JFrame
{
    private final JPanel opponentInfo = new JPanel(new BorderLayout());
    private final JPanel opponentFace = new JPanel(new GridLayout(2, 1));
    private final JLabel opponentName = new JLabel();
    private final JLabel opponentHealth = new JLabel();
    private final JPanel opponentCardInfo = new JPanel(new GridLayout(1, 2));
    private final JLabel opponentHandSize = new JLabel();
    private final JLabel opponentDeckSize = new JLabel();

    private final JPanel board = new JPanel(new GridLayout(2, 1));
    private final JPanel opponentBoard = new JPanel(new GridLayout(1, 7));
    private final JPanel playerBoard = new JPanel(new GridLayout(1, 7));

    private final JPanel playerInfo = new JPanel(new BorderLayout());
    private final JPanel playerFace = new JPanel(new GridLayout(2, 1));
    private final JLabel playerName = new JLabel();
    private final JLabel playerHealth = new JLabel();
    private final JPanel playerHand = new JPanel(new GridLayout(2, 5));
    private final JLabel playerDeckSize = new JLabel();

    public SwingFrontEnd(final String title)
    {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final Player player = new Player();
        player.setName("Martin");
        player.setHealth(30);
        player.setHand(new Hand());
        final Deck playerDeck = new Deck();
        playerDeck.addCard(getRagnaros());
        playerDeck.addCard(getAuctioneer());
        playerDeck.addCard(getRagnaros());
        playerDeck.addCard(getAuctioneer());
        playerDeck.addCard(getRagnaros());
        playerDeck.addCard(getAuctioneer());
        playerDeck.addCard(getRagnaros());
        playerDeck.addCard(getAuctioneer());
        player.setDeck(playerDeck);

        final Player opponent = new Player();
        opponent.setName("Jonas");
        opponent.setHealth(50);
        opponent.setHand(new Hand());
        final Deck opponentDeck = new Deck();
        opponentDeck.addCard(getAuctioneer());
        opponentDeck.addCard(getRagnaros());
        opponentDeck.addCard(getAuctioneer());
        opponentDeck.addCard(getRagnaros());
        opponentDeck.addCard(getAuctioneer());
        opponentDeck.addCard(getRagnaros());
        opponentDeck.addCard(getAuctioneer());
        opponentDeck.addCard(getRagnaros());
        opponentDeck.addCard(getAuctioneer());
        opponentDeck.addCard(getRagnaros());
        opponentDeck.addCard(getAuctioneer());
        opponentDeck.addCard(getRagnaros());
        opponentDeck.addCard(getAuctioneer());
        opponentDeck.addCard(getRagnaros());
        opponentDeck.addCard(getAuctioneer());
        opponentDeck.addCard(getRagnaros());
        opponent.setDeck(opponentDeck);

        opponentFace.add(opponentName);
        opponentName.setText(opponent.getName());
        opponentFace.add(opponentHealth);
        opponentHealth.setText(String.valueOf(opponent.getHealth()));

        opponentCardInfo.add(opponentHandSize);
        opponentHandSize.setText(String.valueOf(opponent.getHand().size()));
        opponentCardInfo.add(opponentDeckSize);
        opponentDeckSize.setText(String.valueOf(opponent.getDeck().size()));

        opponentInfo.add(opponentFace, BorderLayout.WEST);
        opponentInfo.add(opponentCardInfo);

        board.add(opponentBoard);
        board.add(playerBoard);

        playerFace.add(playerName);
        playerName.setText(player.getName());
        playerFace.add(playerHealth);
        playerHealth.setText(String.valueOf(player.getHealth()));

        playerInfo.add(playerFace, BorderLayout.WEST);
        playerInfo.add(playerHand);
        playerInfo.add(playerDeckSize, BorderLayout.EAST);

        playerDeckSize.setText(String.valueOf(player.getDeck().size()));

        add(opponentInfo, BorderLayout.NORTH);
        add(board);
        add(playerInfo, BorderLayout.SOUTH);

        setSize(640, 480);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new SwingFrontEnd("Shitty Hearthstone");
    }
}

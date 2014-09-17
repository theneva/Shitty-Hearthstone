package fu.bar;

import fu.bar.card.Card;
import fu.bar.card.Deck;
import fu.bar.card.Hand;
import fu.bar.card.Minion;
import fu.bar.game.ActiveMinion;
import fu.bar.game.Match;
import fu.bar.game.MatchResource;
import fu.bar.game.Player;

import java.util.List;
import java.util.Scanner;

import static fu.bar.util.CardHelper.getAuctioneer;
import static fu.bar.util.CardHelper.getRagnaros;

public class ConsoleFrontEnd
{
    public static void main(String[] args)
    {
        final Deck deck1 = new Deck();
        deck1.addCard(getRagnaros());
        deck1.addCard(getAuctioneer());

        final Player player1 = new Player();
        player1.setName("Martin");
        player1.setDeck(deck1);
        player1.setHand(new Hand());

        final Deck deck2 = new Deck();
        deck2.addCard(getAuctioneer());
        deck2.addCard(getRagnaros());

        final Player player2 = new Player();
        player2.setName("Jonas");
        player2.setDeck(deck2);
        player2.setHand(new Hand());

        final MatchResource matchResource = new MatchResource();

        Match match = matchResource.start(player1, player2);

        final Scanner in = new Scanner(System.in);
        while (true)
        {
            printPrompt(match);
            final String input = in.nextLine();

            switch (input.toLowerCase()) {
                case "end turn" :
                    matchResource.endTurn();
                    break;
            }
        }
    }

    private static void printPrompt(final Match match)
    {
        final Player activePlayer = match.getActivePlayer();
        System.out.println("Your turn, " + activePlayer.getName() + ".");
        System.out.print("Your hand: ");

        final List<Card> cards = activePlayer.getHand().getCards();

        for (int i = 0; i < cards.size(); i++)
        {
            final Card card = cards.get(i);
            System.out.print(card + "[" + i + "], ");
        }

        System.out.println();
        System.out.print("Your board: ");

        final List<ActiveMinion> activeMinions = activePlayer.getActiveMinions();
        for (int i = 0; i < activeMinions.size(); i++)
        {
            final Minion minion = activeMinions.get(i);
            System.out.printf("%s (%d, %d)[%d] -- ", minion.getName(), minion.getAttack(), minion.getDefaultHealth(), i);
        }

        System.out.println();
        System.out.println("What do you want to do?");
        System.out.println("\tattack <minionIndex> <defendingMinionIndex>");
        System.out.println("\tcast <minionIndexInHand>");
        System.out.println("\tend turn");
    }
}

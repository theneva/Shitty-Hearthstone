package fu.bar.game;

import fu.bar.card.Minion;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/match")
public class MatchResource
{
    final Match match = new Match();

    @POST
    @Path("start")
    @Consumes("application/json")
    public Match start(final Player... players)
    {
        match.setUp(players);
        return match;
    }

    public Match attack(final int attackingMinionIndex, final int defendingPlayerIndex, final int defendingMinionIndex)
    {
        final Minion attackingMinion = match.getActivePlayer().getActiveMinions().get(attackingMinionIndex);
        final Player defendingPlayer = match.getBoard().getPlayer(defendingPlayerIndex);
        final Minion defendingMinion = defendingPlayer.getActiveMinions().get(defendingMinionIndex);

        attackingMinion.attackOtherMinion(defendingMinion);

        return match;
    }

//    public Match castMinion(final int cardsIndexInHand, final int boardPosition) {
//
//    }
//
//    public Match castSpell(final int cardIndexInHand) {
//
//    }
//
//    public Match useWeapon(final int cardIndexInHand) {
//
//    }

    public Match endTurn() {
        match.setActivePlayerIndex((match.getActivePlayerIndex() + 1) % match.getBoard().getPlayerCount());
        match.getActivePlayer().drawCard();
        return match;
    }
}

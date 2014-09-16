package fu.bar.game;

import org.junit.Test;

import static fu.bar.util.CardProvider.getAuctioneer;
import static fu.bar.util.CardProvider.getRagnaros;
import static org.junit.Assert.assertEquals;

public class ActiveMinionTest
{
    @Test
    public void testAttackOtherMinion()
    {
        final ActiveMinion attacker = new ActiveMinion(getRagnaros());
        final ActiveMinion defender = new ActiveMinion(getAuctioneer());

        attacker.attackOtherMinion(defender);

        assertEquals("Ragnaros should have 4 health left.", attacker.getDefaultHealth() - defender.getAttack(), attacker.getHealth());
        assertEquals("Gadgetzan Auctioneer should have -4 health left.", defender.getDefaultHealth() - attacker.getAttack(), defender.getHealth());
    }
}

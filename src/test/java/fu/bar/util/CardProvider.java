package fu.bar.util;

import fu.bar.card.Minion;
import fu.bar.card.MinionType;
import fu.bar.card.Spell;

public class CardProvider
{
    public static Spell getArcaneMissiles() {
        return new Spell("Arcane Missiles", "Deal 3 damage randomly split among enemy characters.", 1);
    }

    public static Minion getAuctioneer()
    {
        return new Minion("Gadgetzan Auctioneer", "Whenever you cast a spell, draw a card.", 5, 4, 4, MinionType.NONE);
    }

    public static Minion getRagnaros()
    {
        return new Minion("Ragnaros the Firelord", "Can't Attack. At the end of your turn, deal 8 damage to a random enemy.", 8, 8, 8, MinionType.NONE);
    }
}

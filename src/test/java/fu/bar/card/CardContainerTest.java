package fu.bar.card;

import org.junit.Test;

import java.util.List;
import java.util.Stack;

import static fu.bar.util.CardHelper.*;
import static org.junit.Assert.*;

public class CardContainerTest
{
    @Test
    public void testNewCardContainerIsEmpty()
    {
        final CardContainer container = new Deck();
        assertEquals("The container should be empty on creation.", 0, container.size());
    }

    @Test
    public void testAddingCardToCardContainerAddsCard()
    {
        final CardContainer container = new Deck();
        assertEquals(0, container.size());

        final Card ragnaros = getRagnaros();
        container.addCard(ragnaros);
        assertEquals("After adding 1 card, the container should hold 1 card.", 1, container.size());

        container.addCard(getAuctioneer());
        assertEquals("After adding 2 cards, the container should hold 2 cards.", 2, container.size());
    }

    @Test
    public void testRemovingCardFromCardContainerRemovesCard()
    {
        final CardContainer container = getCardContainerWithTwoMinions();

        final Card removedCard = container.removeCard();
        assertEquals("After adding 2 and removing 1, the container should hold 1 card.", 1, container.size());
        assertEquals("The removed card should be the auctioneer.", getAuctioneer(), removedCard);
    }

    private CardContainer getCardContainerWithTwoMinions()
    {
        final CardContainer container = new Deck();

        container.addCard(getRagnaros());
        container.addCard(getAuctioneer());

        return container;
    }


    @Test
    public void testGetMinionsReturnsOnlyMinions()
    {
        final CardContainer container = getCardContainerWithTwoMinions();
        container.addCard(getArcaneMissiles());

        final Stack<Minion> expectedMinions = new Stack<>();
        expectedMinions.push(getRagnaros());
        expectedMinions.push(getAuctioneer());

        final List<Minion> actualMinions = container.getMinions();

        assertEquals("getMinions on a deck with 2 minions and 1 spell should return a stack of 2 minions.", 2, actualMinions.size());
        assertEquals("The minions should be the auctioneer and Ragnaros, in that order.", expectedMinions, actualMinions);
    }

    @Test
    public void testGetSpellsReturnsOnlySpells()
    {
        final CardContainer container = getCardContainerWithTwoMinions();
        container.addCard(getArcaneMissiles());

        final Stack<Spell> expectedSpells = new Stack<>();
        expectedSpells.push(getArcaneMissiles());

        final List<Spell> actualSpells = container.getSpells();

        assertEquals("getSpells on a deck with two minions and 1 spell should return a stack of 1 spell.", 1, actualSpells.size());
        assertEquals("The spells should be the arcane missiles.", expectedSpells, actualSpells);
    }

    @Test
    public void testGetWeaponsReturnsOnlyWeapons()
    {
        final CardContainer container = getCardContainerWithTwoMinions();
        container.addCard(getArcaneMissiles());
        container.addCard(getArcaniteReaper());

        final Stack<Weapon> expectedWeapons = new Stack<>();
        expectedWeapons.push(getArcaniteReaper());

        final List<Weapon> actualWeapons = container.getWeapons();

        assertEquals("getSpells on a deck with two minions, 1 spell, and 1 weapon should return a stack of 1 weapon.", 1, actualWeapons.size());
        assertEquals("The spells should be the Arcanite Reaper.", expectedWeapons, actualWeapons);
    }

    @Test
    public void testContains()
    {
        final CardContainer cardContainer = new Hand();
        final Card card = getArcaneMissiles();
        cardContainer.addCard(card);

        assertTrue("The card container should contain the added card.", cardContainer.contains(card));
        assertFalse("The card container should not contain a non-added card.", cardContainer.contains(getRagnaros()));
    }
}

package fu.bar.card;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CardContainerTest
{
    @Test
    public void testNewCardContainerIsEmpty() {
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

    private Minion getAuctioneer()
    {
        return new Minion("Gadgetzan Auctioneer", "Whenever you cast a spell, draw a card.", 5, 4, 4, MinionType.NONE);
    }

    private Minion getRagnaros()
    {
        return new Minion("Ragnaros the Firelord", "Can't Attack. At the end of your turn, deal 8 damage to a random enemy.", 8, 8, 8, MinionType.NONE);
    }

    @Test
    public void testGetMinionsReturnsOnlyMinions() {
        final CardContainer container = getCardContainerWithTwoMinions();
        container.addCard(getArcaneMissiles());

        final Stack<Minion> expectedMinions = new Stack<>();
        expectedMinions.push(getRagnaros());
        expectedMinions.push(getAuctioneer());

        final Stack<Minion> actualMinions = container.getMinions();

        assertEquals("getMinions on a deck with 2 minions and 1 spell should return a stack of 2 minions.", 2, actualMinions.size());
        assertEquals("The minions should be the auctioneer and Ragnaros, in that order.", expectedMinions, actualMinions);
    }

    private Spell getArcaneMissiles() {
        return new Spell("Arcane Missiles", "Deal 3 damage randomly split among enemy characters.", 1);
    }

    @Test
    public void testGetSpellsReturnsOnlySpells() {
        final CardContainer container = getCardContainerWithTwoMinions();
        container.addCard(getArcaneMissiles());

        final Stack<Spell> expectedSpells = new Stack<>();
        expectedSpells.push(getArcaneMissiles());

        final Stack<Spell> actualSpells = container.getSpells();

        assertEquals("getSpells on a deck with two minions and 1 spell should return a stack of 1 spell.", 1, actualSpells.size());
        assertEquals("The spells should be the arcane missiles.", expectedSpells, actualSpells);
    }

    @Test
    public void testContains() {
        final CardContainer cardContainer = new Hand();
        final Card card = getArcaneMissiles();
        cardContainer.addCard(card);

        assertTrue("The card container should contain the added card.", cardContainer.contains(card));
        assertFalse("The card container should not contain a non-added card.", cardContainer.contains(getRagnaros()));
    }
}

package fu.bar.card;

public class Weapon extends Card
{
    private int attack;
    private int durability;

    public Weapon(final String name, final String text, final int cost, final int attack, final int durability)
    {
        super(name, text, cost);
        this.attack = attack;
        this.durability = durability;
    }

    public int getAttack()
    {
        return attack;
    }

    public void setAttack(final int attack)
    {
        this.attack = attack;
    }

    public int getDurability()
    {
        return durability;
    }

    public void setDurability(final int durability)
    {
        this.durability = durability;
    }
}

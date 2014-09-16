package fu.bar.card;

public class Minion extends Card
{
    private int attack;
    private int health;
    private MinionType type;

    public Minion(final String name, final String text, final int cost, final int attack, final int health, final MinionType type)
    {
        super(name, text, cost);

        this.attack = attack;
        this.health = health;
        this.type = type;
    }

    public int getAttack()
    {
        return attack;
    }

    public void setAttack(final int attack)
    {
        this.attack = attack;
    }

    public int getHealth()
    {
        return health;
    }

    public void setHealth(final int health)
    {
        this.health = health;
    }

    public MinionType getType()
    {
        return type;
    }

    public void setType(final MinionType type)
    {
        this.type = type;
    }

    @Override
    public boolean equals(final Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof Minion))
        {
            return false;
        }

        final Minion minion = (Minion) o;

        if (attack != minion.attack)
        {
            return false;
        }
        if (health != minion.health)
        {
            return false;
        }
        if (type != minion.type)
        {
            return false;
        }

        return super.equals(o);
    }

    @Override
    public int hashCode()
    {
        int result = attack;
        result = 31 * result + health;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    public void attackOtherMinion(final Minion defendingMinion)
    {
        defendingMinion.reduceHealth(attack);
        reduceHealth(attack);
    }

    private int reduceHealth(final int attackValue)
    {
        health -= attackValue;
        return health;
    }
}

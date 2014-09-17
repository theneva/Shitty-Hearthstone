package fu.bar.card;

public class Minion extends Card
{
    private int attack;
    private int defaultHealth;
    private MinionType type;

    public Minion(final String name, final String text, final int cost, final int attack, final int defaultHealth, final MinionType type)
    {
        super(name, text, cost);

        this.attack = attack;
        this.defaultHealth = defaultHealth;
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

    public int getDefaultHealth()
    {
        return defaultHealth;
    }

    public void setDefaultHealth(final int defaultHealth)
    {
        this.defaultHealth = defaultHealth;
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
        if (defaultHealth != minion.defaultHealth)
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
        result = 31 * result + defaultHealth;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}

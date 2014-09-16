package fu.bar.card;

public abstract class Card
{
    protected String name;
    protected String text;
    protected int cost;

    public Card(final String name, final String text, final int cost)
    {
        this.name = name;
        this.text = text;
        this.cost = cost;
    }

    public String getName()
    {
        return name;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public String getText()
    {
        return text == null ? "" : text;
    }

    public void setText(final String text)
    {
        this.text = text;
    }

    public int getCost()
    {
        return cost;
    }

    public void setCost(final int cost)
    {
        this.cost = cost;
    }

    @Override
    public boolean equals(final Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof Card))
        {
            return false;
        }

        final Card card = (Card) o;

        if (cost != card.cost)
        {
            return false;
        }
        if (name != null ? !name.equals(card.name) : card.name != null)
        {
            return false;
        }
        if (text != null ? !text.equals(card.text) : card.text != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + cost;
        return result;
    }

    @Override
    public String toString()
    {
        return "Card{" +
                "name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", cost=" + cost +
                '}';
    }
}

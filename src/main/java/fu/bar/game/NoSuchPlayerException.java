package fu.bar.game;

public class NoSuchPlayerException extends RuntimeException
{
    public NoSuchPlayerException(final int playerIndex)
    {
        super("No such player with index: " + playerIndex);
    }
}

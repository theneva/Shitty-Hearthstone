package fu.bar.game;

import java.util.ArrayList;
import java.util.List;

public class Board
{
    private final List<Player> players = new ArrayList<>();

    public int addPlayer(final Player player)
    {
        players.add(player);
        return players.size() - 1;
    }

    public Player getPlayer(final int playerIndex)
    {
        if (playerIndex >= players.size())
        {
            throw new NoSuchPlayerException(playerIndex);
        }

        return players.get(playerIndex);
    }

    public int getPlayerCount()
    {
        return players.size();
    }
}

package fu.bar.game;

public class Match
{
    private Board board;
    private int currentTurn;
    private int activePlayerIndex;

    public void setBoard(final Board board)
    {
        this.board = board;
    }

    public Board getBoard()
    {
        return board;
    }

    public int getCurrentTurn()
    {
        return currentTurn;
    }

    public void setCurrentTurn(final int currentTurn)
    {
        this.currentTurn = currentTurn;
    }

    public int getActivePlayerIndex()
    {
        return activePlayerIndex;
    }

    public void setActivePlayerIndex(final int activePlayerIndex)
    {
        this.activePlayerIndex = activePlayerIndex;
    }

    public void setUp(final Player... players)
    {
        final Board board = new Board();

        for (final Player player : players)
        {
            player.getDeck().shuffle();
            board.addPlayer(player);
        }

        setBoard(board);

        setCurrentTurn(1);
        setActivePlayerIndex(0);

        board.getPlayer(activePlayerIndex).drawCard();
    }

    public Player getActivePlayer()
    {
        return board.getPlayer(getActivePlayerIndex());
    }
}

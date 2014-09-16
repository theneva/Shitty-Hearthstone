package fu.bar.game;

public class BoardState
{
    private final int currentTurn;
    private final Player activePlayer;
    private Board board;

    public BoardState(final int currentTurn, final Player activePlayer, final Board board)
    {
        this.currentTurn = currentTurn;
        this.activePlayer = activePlayer;
        this.board = board;
    }

    public int getCurrentTurn()
    {
        return currentTurn;
    }

    public Player getActivePlayer()
    {
        return activePlayer;
    }

    public Board getBoard()
    {
        return board;
    }

    public void setBoard(final Board board)
    {
        this.board = board;
    }
}

package tricktactoe.tricktactoe;

public class Move {

    public int row, col;
    public Player player;
    private boolean winningMove;

    public Move(int row, int col, Player p) {
        this.row = row;
        this.col = col;
        this.player = p;
        this.winningMove = false;
    }

    public boolean isWinningMove() {
        return this.winningMove;
    }

    public void setWinningMove() {
        this.winningMove = true;
    }
}

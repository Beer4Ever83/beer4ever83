package tricktactoe;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Vector;

import tricktactoe.exceptions.InvalidMoveException;

public class Board {

    private Element[][] board;
    private int rows;
    private int cols;
    private int winLength;
    private Deque<Move> moves;
    private Player winner;

    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.board = new Element[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                this.board[r][c] = new Element();
            }
        }
        this.winLength = Math.min(rows, cols);
        this.moves = new ArrayDeque<Move>(rows * cols);
        this.winner = null;
    }

    private Element elementAt(int row, int col) {
        return this.board[row][col];
    }

    public int getWinLength() {
        return this.winLength;
    }

    public Move playerMoves(int row, int col, Player player) {
        Move move = new Move(row, col, player);
        return playerMoves(move);
    }

    public Move playerMoves(Move move) throws InvalidMoveException {
        if (!isFree(move)) {
            throw new InvalidMoveException("the position is already taken");
        }
        elementAt(move.row, move.col).setPlayer(move.player);
        setWin(move);
        if (move.isWinningMove()) {
            this.winner = move.player;
        }
        moves.push(move);
        return move;
    }

    public boolean hasWinner() {
        return this.winner != null;
    }

    public Player getWinner() {
        return this.winner;
    }

    public boolean isFree(Move move) {
        return elementAt(move.row, move.col).getPlayer() == null;
    }

    public boolean isFree(int row, int col) {
        return isFree(new Move(row, col, null));
    }

    private void setWin(Move move) {
        Vector<Element> h = getHAdjacent(move.row, move.col, move.player);
        // getVAdjacent(row, col, p);
        // getDAdjacent(row, col, p);
        if (h.size() >= this.winLength) {
            move.setWinningMove();
        }
    }

    public Deque<Move> getMovesHistory() {
        return this.moves;
    }

    private Vector<Element> getHAdjacent(int row, int col, Player player) {
        Vector<Element> v = new Vector<Element>();
        for (int c = col; c < this.cols; c++) {
            Element e = elementAt(row, c);
            if (e.getPlayer() == null || !e.getPlayer().equals(player)) {
                break;
            }
            v.add(e);
        }
        for (int c = col - 1; c >= 0; c--) {
            Element e = elementAt(row, c);
            if (null != e && null != e.getPlayer() && !e.getPlayer().equals(player)) {
                break;
            }
            v.add(e);
        }
        return v;
    }

    public String toString() {
        String out = "";
        int maxlen = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                Player player = elementAt(r, c).getPlayer();
                if (null != player && null != player.getPlaceholder()) {
                    int newlen = player.getPlaceholder().toString().length();
                    if (newlen > maxlen)
                        maxlen = newlen;
                }
            }
        }
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                Player player = elementAt(r, c).getPlayer();
                String placeholder = " ";
                if (player != null) {
                    if (player.getPlaceholder() != null) {
                        placeholder = player.getPlaceholder().toString();
                    } else {
                        placeholder = player.getName().toString();
                    }
                }
                String paddedPlaceholder = String.format("%-" + maxlen + "s", placeholder);
                out += paddedPlaceholder;
                if (c + 1 < cols)
                    out += "|";
            }
            out += "\n";
            if (r + 1 < rows)
                out += "--------\n";
        }
        return out;
    }
}

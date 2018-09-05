package tricktactoe.tricktactoe.ui.text.test;

import java.util.Vector;

import tricktactoe.tricktactoe.Board;
import tricktactoe.tricktactoe.Player;
import tricktactoe.tricktactoe.ui.text.TextSymbol;

public class TextBoardTest {

    public static void main(String[] args) {
        Vector<Board> boards = new Vector<Board>();
        boards.add(buildAlternateBoard(3, 3, 2));
        boards.add(buildAlternateBoard(3, 3, 1));
        boards.add(buildAlternateBoard(2, 2, 3));
        boards.add(buildHWinningBoard(3, 3, 2));
        boards.add(buildHWinningBoard(4, 10, 4));
        for (Board b : boards) {
            System.out.println("Board: \n" + b.toString());
            if (b.hasWinner()) {
                System.out.println("winner: " + b.getWinner());
            }

        }
    }

    private static Board buildAlternateBoard(int rows, int cols, int numOfPlayers) {
        Player[] players = new Player[numOfPlayers];
        for (int p = 0; p < numOfPlayers; p++) {
            players[p] = new Player("P" + p, new TextSymbol(String.valueOf(p)));
        }
        Board board = new Board(rows, cols);
        int playerTurn = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                board.playerMoves(r, c, players[playerTurn++ % numOfPlayers]);
            }
        }
        return board;
    }

    private static Board buildHWinningBoard(int rows, int cols, int numOfPlayers) {
        Player[] players = new Player[numOfPlayers];
        for (int p = 0; p < numOfPlayers; p++) {
            players[p] = new Player("P" + p, new TextSymbol(String.valueOf(p)));
        }
        Board board = new Board(rows, cols);

        Player winPlayer = players[(int) (Math.random() * numOfPlayers)];
        int winLength = board.getWinLength();
        int winRow = (int) (Math.random() * rows);
        int winCol = (int) (Math.random() * (cols - winLength));
        for (int c = winCol; c < winLength; c++) {
            board.playerMoves(winRow, c, winPlayer);
        }
        return board;
    }

}

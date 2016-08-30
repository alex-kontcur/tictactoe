package com.rubicon;

import com.rubicon.wincondition.legacy.LegacyWinCondition;

import java.util.List;
import java.util.stream.Stream;

/**
 * TicTacToe
 *
 * @author Alexander Kontsur (bona)
 * @since 30.08.2016
 */
public class TicTacToeLegacy {

    public static void main(String[] args) {
        int size = 3;
        Board board = new Board(size);

        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");

        while (!board.getAvailableMoves().isEmpty()) {
            boolean win = resolveWin(player1, board);
            if (win) {
                break;
            }

            win = resolveWin(player2, board);
            if (win) {
                break;
            }
        }

        System.out.println("player1.getMoves() -> " + player1.getMoves());
        System.out.println("player2.getMoves() -> " + player2.getMoves());
    }

    private static boolean resolveWin(Player player, Board board) {
        player.makeMove(board);
        List<Integer> xMoves = player.getXMoves();
        List<Integer> yMoves = player.getYMoves();
        LegacyWinCondition condition = Stream.of(LegacyWinCondition.values())
                .filter(winCondition -> winCondition.win(xMoves, yMoves, board.getSize())).findAny().orElse(null);

        if (condition != null) {
            System.out.println(player + " win, conditon -> " + condition.name());
            player.setWinner(true);
            return true;
        }
        return false;
    }


}

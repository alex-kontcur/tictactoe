package com.rubicon;

import com.rubicon.wincondition.DiagonalCondition;
import com.rubicon.wincondition.HoriziontalCondition;
import com.rubicon.wincondition.VerticalCondition;
import com.rubicon.wincondition.WinCondition;

import java.util.Arrays;
import java.util.List;

/**
 * TicTacToe
 *
 * @author Alexander Kontsur (bona)
 * @since 31.08.2016
 */
public class TicTacToe {

    public static void main(String[] args) {
        int size = 3;

        List<WinCondition> conditions = Arrays.asList(
          new HoriziontalCondition(size),
          new VerticalCondition(size),
          new DiagonalCondition(size)
        );

        Board board = new Board(size);

        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");

        while (!board.getAvailableMoves().isEmpty()) {
            boolean win = resolveWin(player1, board, conditions);
            if (win) {
                break;
            }

            win = resolveWin(player2, board, conditions);
            if (win) {
                break;
            }
        }

        System.out.println("player1.getMoves() -> " + player1.getMoves());
        System.out.println("player2.getMoves() -> " + player2.getMoves());
    }

    private static boolean resolveWin(Player player, Board board, List<WinCondition> conditions) {
        player.makeMove(board);
        List<Integer> xMoves = player.getXMoves();
        List<Integer> yMoves = player.getYMoves();
        WinCondition condition = conditions.stream().filter(winCondition -> winCondition.win(xMoves, yMoves)).findAny().orElse(null);
        if (condition != null) {
            System.out.println(player + " win, conditon -> " + condition.getName());
            player.setWinner(true);
            return true;
        }
        return false;
    }

}

package com.rubicon;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Player
 *
 * @author Alexander Kontsur (bona)
 * @since 30.08.2016
 */
public class Player {

    private Set<Move> moves;
    private boolean winner;
    private String name;

    public Player(String name) {
        this.name = name;
        moves = new HashSet<>();
    }

    @Override
    public String toString() {
        return name;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public void makeMove(Board board) {
        Set<Move> availableMoves = board.getAvailableMoves();
        System.out.println("availableMoves are :" + availableMoves);

        Scanner scanner = new Scanner(System.in);

        boolean inputCorrect = false;
        while (!inputCorrect) {
            try {
                int x = Integer.parseInt(scanner.next());
                int y = Integer.parseInt(scanner.next());

                Move move = new Move(x, y);
                moves.add(board.acquireMove(move));

                inputCorrect = true;
            } catch (Exception e) {
                System.out.println("Wrong input, please try again...");
            }
        }
    }

    public List<Integer> getXMoves() {
        return moves.stream().map(Move::getX).collect(Collectors.toList());
    }

    public List<Integer> getYMoves() {
        return moves.stream().map(Move::getY).collect(Collectors.toList());
    }

    public Set<Move> getMoves() {
        return moves;
    }
}

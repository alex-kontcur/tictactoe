package com.rubicon;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Board
 *
 * @author Alexander Kontsur (bona)
 * @since 30.08.2016
 */
public class Board {

    private int size;
    private Set<Move> moves;

    public Board(int size) {
        this.size = size;

        moves = new HashSet<>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                moves.add(new Move(i, j));
            }
        }
    }

    public Set<Move> getAvailableMoves() {
        return moves.stream().filter(move -> !move.isBusy()).collect(Collectors.toSet());
    }

    public Move acquireMove(Move move) {
        Move acquiredMove = moves.stream().filter(m -> m.getX() == move.getX() && m.getY() == move.getY()).findFirst().orElseThrow(IllegalStateException::new);
        acquiredMove.setBusy(true);
        return acquiredMove;
    }

    public int getSize() {
        return size;
    }
}

package com.rubicon.wincondition;

import java.util.List;

/**
 * WinCondition
 *
 * @author Alexander Kontsur (bona)
 * @since 30.08.2016
 */
public interface WinCondition {

    String getName();

    boolean win(List<Integer> xMoves, List<Integer> yMoves);

}

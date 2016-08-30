package com.rubicon.wincondition.legacy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * WinCondition
 *
 * @author Alexander Kontsur (bona)
 * @since 30.08.2016
 */
public enum LegacyWinCondition {

    VERTICAL(0, -1),
    HORIZONTAL(-1, 0),
    DIAGONAL(-1, -1);

    LegacyWinCondition(int xdiff, int ydiff) {
        this.xdiff = xdiff;
        this.ydiff = ydiff;
    }

    private int xdiff;
    private int ydiff;


    public boolean win(List<Integer> xMoves, List<Integer> yMoves, int size) {
        List<Integer> xlist = new ArrayList<>(xMoves);
        List<Integer> ylist = new ArrayList<>(yMoves);

        Collections.sort(xlist, (o1, o2) -> -o1.compareTo(o2));
        Collections.sort(ylist, (o1, o2) -> -o1.compareTo(o2));

        if (xMoves.size() == size && yMoves.size() == size) {

            boolean xmatches = match(xlist, xdiff, size);
            boolean ymatches = match(ylist, ydiff, size);

            return xmatches && ymatches;
        } else {
            return false;
        }
    }

    private static boolean match(List<Integer> list, int diff, int size) {
        boolean matches = true;
        for (int i = 0; i < size; i++) {
            if (i + 1 >= size) {
                break;
            }
            Integer v = list.get(i);
            Integer v2 = list.get(i + 1);

            if (v + diff != v2) {
                matches = false;
                break;
            }
        }
        return matches;
    }

}

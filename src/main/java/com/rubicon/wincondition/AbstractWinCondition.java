package com.rubicon.wincondition;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * AbstractWinCondition
 *
 * @author Alexander Kontsur (bona)
 * @since 30.08.2016
 */
public abstract class AbstractWinCondition implements WinCondition {

    private int[] baseArray;

    protected AbstractWinCondition(int size) {
        baseArray = new int[size];
        for (int i = 0; i < size; i++) {
            baseArray[i] = i;
        }
    }

    protected List<Integer> getBaseCollection() {
        return IntStream.of(baseArray).boxed().collect(Collectors.toList());
    }
}

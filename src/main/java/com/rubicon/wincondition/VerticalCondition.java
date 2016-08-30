package com.rubicon.wincondition;

import org.apache.commons.collections.CollectionUtils;

import java.util.HashSet;
import java.util.List;

/**
 * VerticalCondition
 *
 * @author Alexander Kontsur (bona)
 * @since 31.08.2016
 */
public class VerticalCondition extends AbstractWinCondition {

    public VerticalCondition(int size) {
        super(size);
    }

    @Override
    public String getName() {
        return "Vertical";
    }

    @Override
    public boolean win(List<Integer> xMoves, List<Integer> yMoves) {
        return new HashSet(xMoves).size() == 1 && CollectionUtils.isEqualCollection(getBaseCollection(), yMoves);
    }

}

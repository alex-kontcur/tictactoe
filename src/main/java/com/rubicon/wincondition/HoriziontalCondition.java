package com.rubicon.wincondition;

import org.apache.commons.collections.CollectionUtils;

import java.util.HashSet;
import java.util.List;

/**
 * HoriziontalCondition
 *
 * @author Alexander Kontsur (bona)
 * @since 30.08.2016
 */
public class HoriziontalCondition extends AbstractWinCondition {

    public HoriziontalCondition(int size) {
        super(size);
    }

    @Override
    public String getName() {
        return "Horiziontal";
    }

    @Override
    public boolean win(List<Integer> xMoves, List<Integer> yMoves) {
        return CollectionUtils.isEqualCollection(getBaseCollection(), xMoves) && new HashSet(yMoves).size() == 1;
    }

}

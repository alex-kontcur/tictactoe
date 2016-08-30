package com.rubicon.wincondition;

import org.apache.commons.collections.CollectionUtils;

import java.util.List;

/**
 * DiagonalCondition
 *
 * @author Alexander Kontsur (bona)
 * @since 31.08.2016
 */
public class DiagonalCondition extends AbstractWinCondition {

    public DiagonalCondition(int size) {
        super(size);
    }

    @Override
    public String getName() {
        return "Diagonal";
    }

    @Override
    public boolean win(List<Integer> xMoves, List<Integer> yMoves) {
        List<Integer> baseCollection = getBaseCollection();
        return CollectionUtils.isEqualCollection(baseCollection, xMoves) && CollectionUtils.isEqualCollection(baseCollection, yMoves);
    }

}

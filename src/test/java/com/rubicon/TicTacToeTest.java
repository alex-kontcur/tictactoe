package com.rubicon;

import com.rubicon.wincondition.DiagonalCondition;
import com.rubicon.wincondition.HoriziontalCondition;
import com.rubicon.wincondition.VerticalCondition;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * TicTacToeTest
 *
 * @author Alexander Kontsur (bona)
 * @since 31.08.2016
 */
public class TicTacToeTest {

    private static final int SIZE = 3;

    @Test
    public void diagonalCondition1Matches() {
        Player player = new Player("player") {
            @Override
            public List<Integer> getXMoves() {
                return Arrays.asList(0, 1, 2);
            }
            @Override
            public List<Integer> getYMoves() {
                return Arrays.asList(0, 1, 2);
            }
        };
        Assert.assertTrue(new DiagonalCondition(SIZE).win(player.getXMoves(), player.getYMoves()));
    }

    @Test
    public void diagonalCondition2Matches() {
        Player player = new Player("player") {
            @Override
            public List<Integer> getXMoves() {
                return Arrays.asList(2, 1, 0);
            }
            @Override
            public List<Integer> getYMoves() {
                return Arrays.asList(0, 1, 2);
            }
        };
        Assert.assertTrue(new DiagonalCondition(SIZE).win(player.getXMoves(), player.getYMoves()));
    }

    @Test
    public void horizontalConditionMatches() {
        Player player = new Player("player") {
            @Override
            public List<Integer> getXMoves() {
                return Arrays.asList(0, 1, 2);
            }
            @Override
            public List<Integer> getYMoves() {
                return Arrays.asList(1, 1, 1);
            }
        };
        Assert.assertTrue(new HoriziontalCondition(SIZE).win(player.getXMoves(), player.getYMoves()));
    }

    @Test
    public void verticalConditionMatches() {
        Player player = new Player("player") {
            @Override
            public List<Integer> getXMoves() {
                return Arrays.asList(2, 2, 2);
            }
            @Override
            public List<Integer> getYMoves() {
                return Arrays.asList(0, 1, 2);
            }
        };
        Assert.assertTrue(new VerticalCondition(SIZE).win(player.getXMoves(), player.getYMoves()));
    }

    @Test
    public void anyConditionDoesNotMatch1() {
        Player player = new Player("player") {
            @Override
            public List<Integer> getXMoves() {
                return Arrays.asList(0, 0, 1);
            }
            @Override
            public List<Integer> getYMoves() {
                return Arrays.asList(0, 1, 2);
            }
        };
        Assert.assertFalse(new DiagonalCondition(SIZE).win(player.getXMoves(), player.getYMoves()));
        Assert.assertFalse(new HoriziontalCondition(SIZE).win(player.getXMoves(), player.getYMoves()));
        Assert.assertFalse(new VerticalCondition(SIZE).win(player.getXMoves(), player.getYMoves()));
    }

    @Test
    public void anyConditionDoesNotMatch2() {
        Player player = new Player("player") {
            @Override
            public List<Integer> getXMoves() {
                return Arrays.asList(1, 0, 1);
            }
            @Override
            public List<Integer> getYMoves() {
                return Arrays.asList(2, 1, 2);
            }
        };
        Assert.assertFalse(new DiagonalCondition(SIZE).win(player.getXMoves(), player.getYMoves()));
        Assert.assertFalse(new HoriziontalCondition(SIZE).win(player.getXMoves(), player.getYMoves()));
        Assert.assertFalse(new VerticalCondition(SIZE).win(player.getXMoves(), player.getYMoves()));
    }
}

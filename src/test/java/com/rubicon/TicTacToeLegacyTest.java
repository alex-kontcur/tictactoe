package com.rubicon;

import com.rubicon.wincondition.legacy.LegacyWinCondition;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * TicTacToeTest
 *
 * @author Alexander Kontsur (bona)
 * @since 30.08.2016
 */
public class TicTacToeLegacyTest {

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
        Assert.assertTrue(LegacyWinCondition.DIAGONAL.win(player.getXMoves(), player.getYMoves(), 3));
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
        Assert.assertTrue(LegacyWinCondition.DIAGONAL.win(player.getXMoves(), player.getYMoves(), 3));
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
        Assert.assertTrue(LegacyWinCondition.HORIZONTAL.win(player.getXMoves(), player.getYMoves(), 3));
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
        Assert.assertTrue(LegacyWinCondition.VERTICAL.win(player.getXMoves(), player.getYMoves(), 3));
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
        Assert.assertFalse(LegacyWinCondition.DIAGONAL.win(player.getXMoves(), player.getYMoves(), 3));
        Assert.assertFalse(LegacyWinCondition.HORIZONTAL.win(player.getXMoves(), player.getYMoves(), 3));
        Assert.assertFalse(LegacyWinCondition.VERTICAL.win(player.getXMoves(), player.getYMoves(), 3));
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
        Assert.assertFalse(LegacyWinCondition.DIAGONAL.win(player.getXMoves(), player.getYMoves(), 3));
        Assert.assertFalse(LegacyWinCondition.HORIZONTAL.win(player.getXMoves(), player.getYMoves(), 3));
        Assert.assertFalse(LegacyWinCondition.VERTICAL.win(player.getXMoves(), player.getYMoves(), 3));
    }

}

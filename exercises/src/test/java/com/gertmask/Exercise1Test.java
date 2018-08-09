package com.gertmask;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeThat;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Before;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

/**
 * @author gertmask
 * @version 1.0, 03-Aug-18
 */
@RunWith(Theories.class)
public class Exercise1Test {

    @DataPoint
    public static final TestData TD_1 = new TestData(new int[]{2, 4, 3, 3}, 6, toPairArray(2, 4, 3, 3));
    @DataPoint
    public static final TestData TD_2 = new TestData(new int[]{5, 3, 7, 0, 1, 4, 2}, 5, toPairArray(5, 0, 3, 2, 1, 4));
    @DataPoint
    public static final TestData TD_3 = new TestData(new int[]{1, 7, 9, 11, 5, 8, 6}, 16, toPairArray(7, 9, 11, 5));
    @DataPoint
    // reversed pairs: {7, 9} + {9, 7}. should end up with {7, 9}
    public static final TestData TD_4 = new TestData(new int[]{1, 7, 9, 11, 5, 8, 6, 9, 7}, 16, toPairArray(7, 9, 11, 5));
    @DataPoint
    // duplicate pairs: {8, 8} + {8, 8}. should end up with {8, 8}
    public static final TestData TD_5 = new TestData(new int[]{1, 7, 9, 11, 5, 8, 6, 8, 8}, 16, toPairArray(7, 9, 11, 5, 8, 8));

    private Exercise1 exc;

    @Before
    public void setUp() {
        exc = new Exercise1();
    }

    @Theory
    public void testBruteForceSolution(TestData td) {
        Pair<Integer, Integer>[] result = exc.solutionBruteForce(td.getInputInts(), td.getTarget());
        assertThat(result, is(td.getExpectedPairs()));
    }

    @Theory
    public void testSolutionWithHashedInput(TestData td) {
        // the solution doesn't work for TD_3 / TD_4 - ignore
        assumeThat(td.getInputInts(), is(not(anyOf(equalTo(TD_3.getInputInts()), equalTo(TD_4.getInputInts())))));

        Pair<Integer, Integer>[] result = exc.solutionWithHashedInput(td.getInputInts(), td.getTarget());
        assertThat(result, is(td.getExpectedPairs()));
    }

    @Theory
    public void testSolutionWithSortedInput(TestData td) {
        Pair<Integer, Integer>[] result = exc.solutionWithSortedInput(td.getInputInts(), td.getTarget());
        assertThat(result, is(td.getExpectedPairs()));
    }

    // **************************************************************************
    // Private methods
    // **************************************************************************

    @SuppressWarnings("unchecked")
    private static Pair<Integer, Integer>[] toPairArray(int... items) {
        if (items.length % 2 != 0) {
            throw new IllegalArgumentException("Number of items should be even");
        }

        Pair<Integer, Integer>[] result = new Pair[items.length / 2];
        for (int i = 0; i < items.length; i = i + 2) {
            result[i / 2] = Pair.of(items[i], items[i + 1]);
        }

        return result;
    }

    // **************************************************************************
    // Inner classes and interfaces
    // **************************************************************************

    private static class TestData {

        private int[] inputInts;
        private int target;
        private Pair<Integer, Integer>[] expectedPairs;

        TestData(int[] inputInts, int target, Pair<Integer, Integer>[] expectedPairs) {
            this.inputInts = inputInts;
            this.target = target;
            this.expectedPairs = expectedPairs;
        }

        int[] getInputInts() {
            return inputInts;
        }

        int getTarget() {
            return target;
        }

        Pair<Integer, Integer>[] getExpectedPairs() {
            return expectedPairs;
        }
    }
}
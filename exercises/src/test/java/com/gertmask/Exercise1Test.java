package com.gertmask;

import static org.junit.Assert.assertArrayEquals;

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

    private Exercise1 exc;

    @Before
    public void setUp() {
        exc = new Exercise1();
    }

    @Theory
    public void testBruteForceSolution(TestData td) {
        Pair<Integer, Integer>[] result = exc.solutionBruteForce(td.getInputInts(), td.getTarget());
        assertArrayEquals(td.getExpectedPais(), result);
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
        private Pair<Integer, Integer>[] expectedPais;

        TestData(int[] inputInts, int target, Pair<Integer, Integer>[] expectedPais) {
            this.inputInts = inputInts;
            this.target = target;
            this.expectedPais = expectedPais;
        }

        int[] getInputInts() {
            return inputInts;
        }

        int getTarget() {
            return target;
        }

        Pair<Integer, Integer>[] getExpectedPais() {
            return expectedPais;
        }
    }
}
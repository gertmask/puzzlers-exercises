package com.gertmask;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.tuple.Pair;

/**
 * Two-Sum Problem:
 * Given an integer array and a number T, find all unique pairs of (a, b) whose sum is equal to T
 * <p>
 * Example:
 * int[] input = { 2, 4, 3, 3 }
 * target = 6
 * <p>
 * result: {2,4}, {3,3}
 * <p><p>
 * Links:
 * <ul>
 *      <li><a href="http://www.baeldung.com/java-algorithm-number-pairs-sum">
 *          Find All Pairs of Numbers in an Array That Add Up to a Given Sum</a>
 *      <li><a href="https://stackoverflow.com/questions/4720271/find-a-pair-of-elements-from-an-array-whose-sum-equals-a-given-number">
 *          Discussion on stack overflow</a>
 *      <li><a href="http://techieme.in/find-pair-of-numbers-in-array-with-a-given-sum/">
 *          Find Pair of Numbers in Array with a Given Sum</a>
 *      <li><a href="http://k2code.blogspot.com/2012/01/given-integer-array-and-number-x-find.html">
 *          2 Sum Problem</a>
 *      <li><a href="https://github.com/raywenderlich/swift-algorithm-club/tree/master/Two-Sum%20Problem">
 *          Swift algorithm club: 2 Sum Problem</a>
 * </ul>
 *
 * @author gertmask
 * @version 1.0, 03-Aug-18
 */
public class Exercise1 {

    @SuppressWarnings("unchecked")
    private static final Pair<Integer, Integer>[] EMPTY_PAIR_ARRAY = new Pair[0];


    public Pair<Integer, Integer>[] solutionBruteForce(int[] input, int target) {
        Set<Pair<Integer, Integer>> result = new LinkedHashSet<>();

        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                int left = input[i];
                int right = input[j];

                if (left + right == target) {
                    result.add(Pair.of(left, right));
                }
            }
        }

        return result.toArray(EMPTY_PAIR_ARRAY);
    }

    public Pair<Integer, Integer>[] solutionWithHashes(int[] input, int target) {
        List<Pair<Integer, Integer>> result = new ArrayList<>();

        

        return result.toArray(EMPTY_PAIR_ARRAY);
    }
}
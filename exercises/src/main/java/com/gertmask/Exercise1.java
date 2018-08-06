package com.gertmask;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.tuple.Pair;

/**
 * Two-Sum Problem:
 *  Given an array of integers and an integer target, return the indices of two numbers that add up to the target.
 *
 *  Example:
 *      int[] input = { 2, 4, 3, 3 }
 *      target = 6
 *
 *      result: {2,4}, {3,3}
 *
 * @author gertmask
 * @version 1.0, 03-Aug-18
 */
public class Exercise1 {

    @SuppressWarnings("unchecked")
    private static final Pair<Integer, Integer>[] EMPTY_PAIR_ARRAY = new Pair[0];


    public Pair<Integer, Integer>[] solutionBruteForce(int[] input, int target) {
        List<Pair<Integer, Integer>> result = new ArrayList<>();

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
}
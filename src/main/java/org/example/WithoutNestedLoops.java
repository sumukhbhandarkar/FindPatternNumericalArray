package org.example;

import java.util.*;

public class WithoutNestedLoops {

    public static void main(String[] args) {
        Integer[] inputArray = {1, 2, 3, 5, 6, 0, 1, 2, 3, 5, 2, 5};
        Map<List<Integer>, Integer> subArrays = countPatternFreq(inputArray);
        for (Map.Entry<List<Integer>, Integer> entry : subArrays.entrySet()) {
            if (entry.getValue() >= 2) {
                System.out.println(entry);
            }
        }
    }

    /**
     * The logic in this code is same as that of finding substring from a string (refer `StringConversion.class`
     * Further adding to map logic is common to all programs!
     * @param input list of integers
     * @return map
     */
    public static Map<List<Integer>, Integer> countPatternFreq(Integer[] input) {
        Map<List<Integer>, Integer> map = new HashMap<>();

        for (int i = 2; i <= input.length; i++) {
            for (int j = 0; j <= input.length - i; j++) {
                List<Integer> subarray = new ArrayList<>(List.of(input).subList(j, j + i));
                map.put(subarray, map.getOrDefault(subarray, 0) + 1);
            }
        }
        return map;
    }
}

/**
 * Output:
 * [2, 3]=2
 * [3, 5]=2
 * [2, 3, 5]=2
 * [1, 2, 3, 5]=2
 * [1, 2, 3]=2
 * [1, 2]=2
 *
 * The time complexity for this code is O(N^2), where N is the size of input array
 * This is most optimal code for the problem.
 */
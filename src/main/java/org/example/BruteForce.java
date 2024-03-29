package org.example;

// 1,2,3,5,6,0,1,2,3,5,2,5

import java.util.*;

/**
 * This is the bruteforce approach, will take into account each pattern in a pair, triplet and so on
 * It will match the pattern within the array and return the count
 */
public class BruteForce {
    public static void main(String[] args) {
        Integer[] input = new Integer[]{1,2,3,5,6,0,1,2,3,5,2,5};
        List<Integer> inputArray = Arrays.asList(input);
        List<List<Integer>> subArrays = findAllSubArrays(input);
        HashMap<List<Integer>, Integer> output = new HashMap<>();
        for (List<Integer> each : subArrays) {
            if (countSubListFreq(inputArray, each) >= 2)
                output.put(each, countSubListFreq(inputArray, each));
        }
        System.out.println(output);
    }

    public static int countSubListFreq(List<Integer> outer, List<Integer> inner) {
        int count = 0;
        for (int i=0; i<=outer.size() - inner.size(); i++) {
            if (outer.subList(i, i+inner.size()).equals(inner))
                count++;
        }
        return count;
    }

    /**
     * Will return all the subArrays for the input array
     * output: [[1, 2], [1, 2, 3], [1, 2, 3, 5], [1, 2, 3, 5, 6], [2, 3], [2, 3, 5], [2, 3, 5, 6], [2, 3, 5, 6, 0], [3, 5], [3, 5, 6], [3, 5, 6, 0], [3, 5, 6, 0, 1], [5, 6], [5, 6, 0], [5, 6, 0, 1], [5, 6, 0, 1, 2], [6, 0], [6, 0, 1], [6, 0, 1, 2], [6, 0, 1, 2, 3], [0, 1], [0, 1, 2], [0, 1, 2, 3], [0, 1, 2, 3, 5], [1, 2], [1, 2, 3], [1, 2, 3, 5], [1, 2, 3, 5, 2], [2, 3], [2, 3, 5], [2, 3, 5, 2], [2, 3, 5, 2, 5], [3, 5], [3, 5, 2], [3, 5, 2, 5], [5, 2], [5, 2, 5], [2, 5]]
     * @param input List of integers
     * @return void
     */
    public static List<List<Integer>> findAllSubArrays(Integer[] input) {
        List<List<Integer>> allSubArrays = new ArrayList<>();
        for (int i = 0; i < input.length; i++)
            for (int j = i; j < input.length; j++) {
                List<Integer> subArray = new ArrayList<>();
                subArray.addAll(Arrays.asList(input).subList(i, j + 1));
                if (subArray.size() >= 2 && subArray.size() <= input.length/2-1)
                    allSubArrays.add(subArray);
            }
        return allSubArrays;
    }
}


/**
 * The output of the code: {[1, 2, 3]=2, [1, 2]=2, [2, 3]=2, [2, 3, 5]=2, [3, 5]=2, [1, 2, 3, 5]=2}
 * Where each key of the HashMap shows the pattern and the value shows the count
 */

/**
 * Time complexity of `finaAllSubArrays` is O(N^3)
 * Time complexity of `countSubListFreq` is O(N * M) , where N = length of outer list, M = length of inner list
 * Overall time complexity remains O(N^3)
 */
package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This approch is a simpler and more optimized solution
 * It is a combination of the previous two solutions.
 * We are getting the subArray patterns and updating a HashMap to find it's frequencies
 *
 * In the main method, we only print those entries of the map, where value(freq), is >= 2
 */
public class FindPatternFrequency {
    public static void main(String[] args) {
        Integer[] input = new Integer[]{1,2,3,5,6,0,1,2,3,5,2,5};
        Map<List<Integer>, Integer> map = countFrequencies(input);
        for(Map.Entry<List<Integer>, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 2) {
                System.out.println(entry);
            }
        }
    }

    public static Map<List<Integer>, Integer> countFrequencies(Integer[] input) {
        Map<List<Integer>, Integer> map = new HashMap<>();
        for(int i=0; i<input.length; i++) {
            for(int j=i+2; j<=input.length; j++) {
                List<Integer> pattern = new ArrayList<>();
                for (int k=i; k<j; k++) {
                    pattern.add(input[k]);
                }
                map.put(pattern, map.getOrDefault(pattern, 0) + 1);
            }
        }
        return map;
    }
}

/**
 * output:
 * [2, 3]=2
 * [3, 5]=2
 * [2, 3, 5]=2
 * [1, 2, 3, 5]=2
 * [1, 2, 3]=2
 * [1, 2]=2
 *
 * here, the output is more easily readable!
 *
 * Time Complexity: O(N^3), where N is the size of the input array
 */

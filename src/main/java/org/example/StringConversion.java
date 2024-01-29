package org.example;

import java.util.*;

/**
 * This approach converts the list into a string and finds all repeating substrings
 */
public class StringConversion {
    public static void main(String []args) {
        Integer input[] = new Integer[]{1,2,3,5,6,0,1,2,3,5,2,5};
        Map<String, Integer> map = new LinkedHashMap<>();
        String inputString = Arrays.toString(input)
                .replace(",", "")
                .replace("[", "")
                .replace("]", "")
                .replaceAll("\\s+", "")
                .trim();
        List<String> subStrings = findAllSubstrings(inputString);
        for (String s : subStrings) {
            int count = inputString.split(s, -1).length-1;
            if (count >= 2) {
                map.put(s, count);
            }
        }
        System.out.println(map);
    }

    static List<String> findAllSubstrings(String input) {
        List<String> subStringList = new ArrayList<>();
        for (int i=0; i<input.length(); i++) {
            String substring = "";
            for(int j=i; j<input.length(); j++) {
                substring += input.charAt(j);
                if (substring.length() >= 2)
                    subStringList.add(substring);
            }
        }
        return subStringList;
    }
}

/**
 * Output: {12=2, 123=2, 1235=2, 23=2, 235=2, 35=2}
 * Since it is converted to string, and output stored in LinkedHashMap
 * The first element is the pattern (number sequence) and the value is the count
 */

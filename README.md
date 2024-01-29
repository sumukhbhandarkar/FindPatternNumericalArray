## Problem Statement
<hr>
Find all patterns in an array of intgers

* The length of pattern is >= 2 integers.
* Patterns must occur in sequential integers within the array.
* Output will contain the pattern and the number of times it occurs in the list.
* The pattern will have to occur at least twice to be considered.

### Test Cases
_input_ - [1,2,3,5,6,0,1,2,3,5,2,5]
<br>
_output_ - <br>
[2, 3]=2 <br>
[3, 5]=2 <br>
[2, 3, 5]=2 <br>
[1, 2, 3, 5]=2 <br>
[1, 2, 3]=2 <br>
[1, 2]=2 <br>

#### Explanation
* Each of the pattern mentioned above is occurring multiple times in the array


<hr>

## Solutions

* ### BruteForce.class

This is the bruteforce approach, will take into account each pattern in a pair, triplet and so on
It will match the pattern within the array and return the count

Time Complexity: O(N^3), where N is the size of input array

* ### FindPatternFrequency.class

This approch is a simpler and more optimized solution
It is a combination of the previous two solutions.
We are getting the subArray patterns and updating a HashMap to find it's frequencies

In the main method, we only print those entries of the map, where value(freq), is >= 2

Time Complxity: O(N^3), where N is the size of input array

* ### StringConversion.class

This approach converts the list into a string and finds all repeating substrings

Time Complexity: O(N^3)

* ### WithoutNestedLoops.class

This is the most efficient code for this problem



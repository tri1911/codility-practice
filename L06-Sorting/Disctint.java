// Date: Nov 27, 2021
// Distinct

import java.util.*;

class Solution {
	// time complexity: O(n)
	// space complexity: O(n)
    public int solution(int[] A) {
    	HashSet<Integer> set = new HashSet<>();
        for (int num: A) {
        	set.add(num);
        }
        return set.size();
    }
}

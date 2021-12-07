// Date: Dec 7, 2021
// AbsDisctinct

// Example: 
// Input: A = [-5,-3,-1,0,3,6]
// absolute distinct count = 5 (namely 0, 1, 3, 5, 6)
// Output: 5

// A is sorted in non-decreasing order with N elements
// N = [1..100,000]
// A[i] = [−2,147,483,648..2,147,483,647]

// time complexity: O(N)
// space complexity: O(N)
// result: https://app.codility.com/demo/results/trainingEW24HY-RBC/

import java.util.*;

class Solution {
	public int solution(int[] A) {
		int N = A.length;
		Set<Integer> hash = new HashSet<Integer>();
		int ans = 0;
		for (int value: A) {
			value = Math.abs(value);
			if (!hash.contains(value)) {
				hash.add(value);
				ans++;
			}
		}
		return ans;
	}
}

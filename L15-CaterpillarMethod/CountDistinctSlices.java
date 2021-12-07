// Date: Dec 7, 2021
// CountDistinctSlices

// non-negative integers A with A[i] <= M (size N)
// Input: A = [3,4,5,5,2]
// -> 9 disctint slices: (0, 0), (0, 1), (0, 2), (1, 1), (1, 2), (2, 2), (3, 3), (3, 4) and (4, 4)
// Ouput: 9

// N = [1..100,000]
// M = [0..100,000]
// A[i] = [0..M]

// time complexity: O(N)
// space complexity: O(M)
// result: https://app.codility.com/demo/results/trainingD6J8SU-PCF/

import java.util.*;

class Solution {
	public int solution(int M, int[] A) {
		int N = A.length;
		if (N == 1) {
			return 1;
		}
		int ans = 0, value;
		Map<Integer, Integer> currentSlice = new HashMap<>();
		for (int start = 0, end = 0; end < N; end++) {
			value = A[end];
			if (currentSlice.containsKey(value) && currentSlice.get(value) >= start) {
				start = currentSlice.get(value) + 1;
				currentSlice.replace(value, end);
			} else {
				currentSlice.put(value, end);
			}
			ans += end - start + 1;
			if (ans > 1000000000) {
				return 1000000000;
			}
		}
		return ans;
	}
}
// Date: Dec 7, 2021
// MinAbsSumOfTwo

// given non-empty array A (length of N)
// abs sum for a pair of indices (P, Q) = |A[P] + A[Q]|, for 0 <= P <= Q < N

// input: A = [1, 4, -3]
// pairs of indices: (0, 0), (0, 1), (0, 2), (1, 1), (1, 2), (2, 2)
// (0, 0): A[0] + A[0] = |1 + 1| = 2
// (0, 1): A[0] + A[1] = |1 + 4| = 5
// (0, 2): A[0] + A[2] = |1 + (−3)| = 2
// (1, 1): A[1] + A[1] = |4 + 4| = 8
// (1, 2): A[1] + A[2] = |4 + (−3)| = 1
// (2, 2): A[2] + A[2] = |(−3) + (−3)| = 6
// output: 1 (the minimal abs sum)

// input: A = [-8, 4, 5, -10, 3]
// output: 3 (= |-8 + 5|)

// N = [1..100,000]
// A[i] = [−1,000,000,000..1,000,000,000]

// time complexity: 
// space complexity: 
// result: 

import java.util.*;

class Solution { 
	public int solution(int[] A) {
		int N = A.length;
		Arrays.sort(A);
		int left = 0, right = N - 1;

		if (A[left] >= 0) {
			return 2 * A[left];
		}

		if (A[right] <= 0) {
			return -(2 * A[right]);
		}

		int ans = Integer.MAX_VALUE;

		while (left < right) {
			int smallest = Math.min(Math.abs(2 * A[left]), Math.abs(2 * A[right]));
			smallest = Math.min(smallest, Math.abs(A[left] + A[right]));
			ans = Math.min(ans, smallest);
			if (Math.abs(A[left + 1] + A[right]) <= Math.abs(A[left] + A[right - 1])) {
				left++;
			} else {
				right--;
			}
		}

		return ans;
	}
}

// reference
// https://github.com/Behrouz-m/Codility/blob/master/15-CaterpillarMethod/MinAbsSumOfTwo.cpp

// Date: Dec 7, 2021
// CountTriangles

// Array A with N integers contains sides of lengths
// triplet (P, Q, R) is triangular if 0 <= P < Q < R < N and:
// 1. A[P] + A[Q] > A[R]
// 2. A[Q] + A[R] > A[P]
// 3. A[R] + A[P] > A[Q]

// Input: A = [10, 2, 5, 1, 8, 12]
// Output: 4 triangular triplets: (0, 2, 4), (0, 2, 5), (0, 4, 5), (2, 4, 5) -> return 4

// N = [0..1,000]
// A[i] = [1..1,000,000,000]

// time complexity: O(n^2)
// space complexity: O(1)
// result: https://app.codility.com/demo/results/trainingJ729W2-2QU/

import java.util.*;

class Solution { 
	public int solution(int[] A) {
		int N = A.length;
		if (N < 3) { return 0; }
		Arrays.sort(A);
		int ans = 0;
		for (int i = 0; i < N - 2; i++) {
			int k = i + 2;
			for (int j = i + 1; j < N - 1; j++) {
				while (k < N && A[i] + A[j] > A[k]) {
					k++;
				}
				ans += k - j - 1;
			}
		}
		return ans;
	} 
}
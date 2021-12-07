// Date: Nov 26, 2021 (Not Done) -> Redo at Dec 6, 2021
// Check whether array A is a permutation.
// https://app.codility.com/programmers/lessons/4-counting_elements/perm_check/

// A permutation is a sequence containing each element from 1 to N once, and only once.

// Examples:
// A = [4, 1, 3, 2] is a permutation => returns 1
// A = [4, 1, 3] is not (value 2 is missing) => returns 0

// N = [1..100,000]
// A[i] = [1..1,000,000,000]

// time complexity: O(n)
// space complexity: O(n)
// result: https://app.codility.com/demo/results/trainingWJKV3G-RYY/
public int solution(int[] A) {
	int n = A.length;
	boolean[] exists = new boolean[n + 1];
	for (int num : A) {
		if (num > n) {
			return 0;
		}
		exists[num] = true;
	}
	for (int i = 1; i <= n; i++) {
		if (!exists[i]) {
			return 0;
		}
	}
	return 1;
}
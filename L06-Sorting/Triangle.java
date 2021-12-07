// Date: Nov 27, 2021
// similar https://leetcode.com/problems/valid-triangle-number/

// after sorting, we have at ith index:
// Consider A[i], A[i+1], A[i+2]:
// Always A[i+2] + A[i] > A[i+1] AND A[i+2] + A[i+1] > A[i]
// So, we only need to checkl A[i] + A[i+1] > A[i+2]
// Because elements from i+3... even > A[i+2], so if the above inequation does not satisfy then return 0
// time complexity: O(nlogn) for sorting
// space complexity: O(logn)
public int solution(int[] A) {
	int n = A.length;
	if (n < 3) {
		return 0;
	}
	// take O(nlogn)
	Arrays.sort(A);
	// take O(n)
	for (int i = 0; i < n - 2; i++) {
		if (A[i] > A[i+2] - A[i+1]) {
			return 1;
		}
	}
	return 0;
}

// Reference: https://stackoverflow.com/questions/5391207/how-to-know-that-a-triangle-triple-exists-in-our-array
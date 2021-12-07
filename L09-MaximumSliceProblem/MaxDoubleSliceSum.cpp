// Date: Nov 28, 2021
// MaxDoubleSliceSum

// For example, array A such that:
// A = [3,2,6,-1,4,5,-1,2]
// contains the following example double slices:
// double slice (0, 3, 6), sum is 2 + 6 + 4 + 5 = 17,
// double slice (0, 3, 7), sum is 2 + 6 + 4 + 5 − 1 = 16,
// double slice (3, 4, 5), sum is 0

// dynamic programming approach (Kanade algorithm)
// time complexity O(n)
// space complexity O(n)
int solution(vector<int> &A) {
	int n = A.size();
	// compute the max sum for subarray ending at ith index, from 1...n-2
	vector<int> left(n);
	// compute the max sum for subarray ending at ith index, from n-2...1
	vector<int> right(n);
	for (int i = 1; i < n - 1; i++) {
		// left[i] = max(left[i-1] + A[i], A[i]);
		left[i] = max(0, max(left[i-1] + A[i], A[i]));
		// right[n-1-i] = max(right[n-1-i+1] + A[n-1-i], A[n-1-i]);
		right[n-1-i] = max(0, max(right[n-1-i+1] + A[n-1-i], A[n-1-i]));
	}
	int ans = 0;
	for (int i = 1; i < n - 1; i++) {
		ans = max(ans, left[i-1] + right[i+1]);
	}
	return ans;
}

// failed test case:
// For example, for the input [0, 10, -5, -2, 0] 
// the solution returned a wrong answer (got 8 expected 10).

// left:   0 10  5  3 3
// right: 10 10 -5 -2 0
// ====>     -5  8  5 

// reference: https://stackoverflow.com/questions/20660989/max-double-slice-sum/32042916
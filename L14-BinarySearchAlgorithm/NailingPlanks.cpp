// Date: Dec 3, 2021
// NailingPlanks

// Given: 
// A = [1,4,5,8]
// B = [4,5,9,10]
// => 4 planks: [1, 4], [4, 5], [5, 9], [8, 10]
// C = [4,6,7,10,2]

// if we use the following nails:
// 0, then planks [1, 4] and [4, 5] will both be nailed.
// 0, 1, then planks [1, 4], [4, 5] and [5, 9] will be nailed.
// 0, 1, 2, then planks [1, 4], [4, 5] and [5, 9] will be nailed.
// 0, 1, 2, 3, then all the planks will be nailed.
// Thus, four is the minimum number of nails that, used sequentially, allow all the planks to be nailed
// => the function should return 4

// If it is not possible to nail all the planks, the function should return −1.

// N and M are integers within the range [1..30,000];
// each element of arrays A, B and C is an integer within the range [1..2*M];
// A[K] ≤ B[K].

// suggested time complexity is O((N+M)*logM)
// logM is achieved by using binary search for M (the number of nails)

#include <vector>

// time complexity: O((N+M)*log(M))
// space complexity: O(M)
// result: https://app.codility.com/demo/results/trainingHTDV66-SNQ/
int solution(vector<int> &A, vector<int> &B, vector<int> &C) {
	int N = A.size();
	int M = C.size();
	// find the solution using binary search
	int ans = -1;
	int low = 0, high = M - 1;
	while (low <= high) {
		int mid = (low + high) / 2;
		// uses prefix sum to track whether there exists a nail in a certain range in O(1) time
		// each element in C has the value within [1, 2*M]
		vector<int> ps(2 * M + 1);
		for (int i = 0; i <= mid; i++)
			ps[C[i]] = 1;
		for (int i = 1; i <= 2 * M; i++)
			ps[i] += ps[i-1];
		for(int n: ps)
			cout << n << " ";
		cout << endl;
		// check how many nailed planks if using til C[mid]
		int nailedPlanks = 0;
		for (int i = 0; i < N; i++) {
			if (ps[B[i]] - ps[A[i] - 1] > 0)
				nailedPlanks++;
		}
		cout << "nailedPlanks = " << nailedPlanks << endl;
		if (nailedPlanks == N) {
			high = mid - 1;
			ans = mid + 1;
		} else {
			low = mid + 1;
		}
	}
	return ans;
}

// failed
// For example, for the input ([2], [2], [1]) the solution returned a wrong answer (got 0 expected -1).

// reference
// http://codility-lessons.blogspot.com/2015/03/lesson-11-nailingplanks-nailing-planks.html
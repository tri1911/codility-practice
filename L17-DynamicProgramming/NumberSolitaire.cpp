// Date: Nov 3, 2021
// NumberSolitaire

// For example, given:
// A[0] = 1
// A[1] = -2
// A[2] = 0
// A[3] = 9
// A[4] = -1
// A[5] = -2
// one possible game could be as follows:
// the pebble is on square number 0, which is marked;
// we throw 3; the pebble moves from square number 0 to square number 3; we mark square number 3;
// we throw 5; the pebble does not move, since there is no square number 8 on the board;
// we throw 2; the pebble moves to square number 5; we mark this square and the game ends.

// The marked squares are 0, 3 and 5, so the result of the game is 1 + 9 + (−2) = 8. 
// This is the maximal possible result that can be achieved on this board.
// => the function should return 8

// N is an integer within the range [2..100,000];
// each element of array A is an integer within the range [−10,000..10,000].

// time complexity: O(n)
// space complexity: O(n)

void printArray(vector<int>& arr) {
	for (int n: arr)
		cout << n << " ";
	cout << endl;
}

int solution(vector<int> &A) {
	int n = A.size();
	vector<int> dp(n);
	dp[0] = A[0];
	for (int i = 1; i < n; i++) {
		int best = dp[i - 1];
		// takes O(1) time (at most 6 times)
		for (int j = 2; i - j >= 0 && j <= 6; j++) {
			best = max(best, dp[i-j]);
		}
		cout << "i = " << i << endl;
		cout << "best = " << best << endl;
		dp[i] = A[i] + best;
		printArray(dp);
	}
	return dp[n-1];
}

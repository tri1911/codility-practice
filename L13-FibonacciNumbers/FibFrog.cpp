// Date: Dec 1, 2021
// FibFrog
// Similar to https://leetcode.com/problems/combination-sum-iv/

// The frog can jump over any distance F(K), where F(K) 
// is the K-th Fibonacci number
// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...

// 0 represents a position without a leaf;
// 1 represents a position containing a leaf.

// The goal is to count the minimum number of jumps in which the 
// frog can get to the other side of the river (from position −1 to position N)

// A = [0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0]
// The frog can make three jumps of length F(5) = 5, F(3) = 2 and F(5) = 5

#include <vector>
#include <iostream>
#include <climits>

using namespace std;

// dynamic programming approach
// finding a combination of fib numbers that sum ups to (n + 1)
// time complexity: O(N * log(N))
// space complexity: O(N)
int solution(vector<int> &A) {
	A.push_back(1);
	int n = A.size();
	cout << "n=" << n << endl;
	vector<int> fib;
	fib.push_back(1);
	fib.push_back(1);
	for (int i = 2; fib[i-1] < n; i++) {
		fib.push_back(fib[i-1] + fib[i-2]);
		cout << "fib[i]=" << fib[i] << endl;
	}

	// DEBUG
	for(int n: fib)
		cout << n << " ";
	cout << endl;

	vector<int> dp(n, INT_MAX);
	for (int i = 0; i < n; i++) {
		cout << "checking i=" << i << endl;
		if (A[i] == 1) {
			cout << "A[" << i << "] = " << A[i] << endl;
			for (int j = 0; i - fib[j] >= -1; j++) {
				cout << "i=" << i << ", fib[" << j << "]=" << fib[j] << endl;
				if (i - fib[j] == -1) {
					dp[i] = min(dp[i], 1);
					cout << "dp[" << i << "]=" << dp[i] << endl;
				} else if (dp[i - fib[j]] != INT_MAX) {
					dp[i] = min(dp[i], 1 + dp[i - fib[j]]);
					cout << "dp[" << i << "]=" << dp[i] << endl;
				}
			}
		}
	}
	return (dp[n-1] == INT_MAX) ? -1 : dp[n-1];
}

// reference
// https://www.martinkysel.com/codility-fibfrog-solution/
// https://medium.com/@thinh.onblurvn/fibfrog-from-codility-196037ed3e1a
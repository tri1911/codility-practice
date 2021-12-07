// Date: Dec 1, 2021
// Ladder

// The ladder has exactly N rungs, numbered from 1 to N
// first step you can stand on rung 1 or 2,
// if you are on rung K, you can move to rungs K + 1 or K + 2,
// finally you have to stand on rung N.

// Task: count the number of different ways of climbing to the top of the ladder

// Given N = 4, you have five different ways of climbing, ascending by:
// 1, 1, 1 and 1 rung,
// 1, 1 and 2 rungs,
// 1, 2 and 1 rung,
// 2, 1 and 1 rungs, and
// 2 and 2 rungs

// Given N = 5, you have eight different ways of climbing, ascending by:

// 1, 1, 1, 1 and 1 rung,
// 1, 1, 1 and 2 rungs,
// 1, 1, 2 and 1 rung,
// 1, 2, 1 and 1 rung,
// 1, 2 and 2 rungs,
// 2, 1, 1 and 1 rungs,
// 2, 1 and 2 rungs, and
// 2, 2 and 1 rung.

// given two non-empty arrays A and B of L integers,
// returns an array consisting of L integers specifying 
// the consecutive answers; position I should contain the number 
// of different ways of climbing the ladder with A[I] rungs modulo 2^B[I].

// given L = 5 and:
// 	A[0] = 4   B[0] = 3
//  A[1] = 4   B[1] = 2
//  A[2] = 5   B[2] = 4
//  A[3] = 5   B[3] = 3
//  A[4] = 1   B[4] = 1
// the function should return the sequence [5, 1, 8, 0, 1]

// L is an integer within the range [1..50,000];
// each element of array A is an integer within the range [1..L];
// each element of array B is an integer within the range [1..30].

#include <math.h>

// dynamic programming approach
// time complexity: O(L)
// space complexity: O(L)
vector<int> solution(vector<int> &A, vector<int> &B) {
	int L = A.size();
	vector<int> dp(L+1);
	dp[1] = 1;
	dp[2] = 2;
	for (int i = 3; i <= L; i++) {
		dp[i] = (dp[i-1] + dp[i-2]) % (int) pow(2, 30);
	}
	for (int n: dp)
        cout << n << " ";
    cout << endl;

	vector<int> ans(L);
	for(int i = 0; i < L; i++) {
		ans[i] = dp[A[i]] % (int) pow(2, B[i]);
	}
	return ans;
}

// reference:
// https://www.youtube.com/watch?v=raAloFqpXfU
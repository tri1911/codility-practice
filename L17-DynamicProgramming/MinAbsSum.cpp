// Date: Dec 3, 2021
// MinAbsSum

// For a given array A of N integers and a sequence S of N integers from the set {−1, 1}, we define val(A, S) as follows:
// val(A, S) = |sum{ A[i]*S[i] for i = 0..N−1 }|

// given an array A of N integers, 
// computes the minimum value of val(A,S) from all possible values of val(A,S) 
// for all possible sequences S of N integers from the set {−1, 1}.

// For example, given array:
// A[0] =  1
// A[1] =  5
// A[2] =  2
// A[3] = -2
// should return 0, since for S = [−1, 1, −1, 1], val(A, S) = 0, which is the minimum possible value.
// -1 + 5 - 2 - 2 = 4 - 4 = 0

// N is an integer within the range [0..20,000];
// each element of array A is an integer within the range [−100..100].

#include <unordered_map>

// Detected time complexity: O(N * max(abs(A))^2)
// find the max sum of elements that <= Sum of all elements / 2
// which yields the minimum difference between two parts (what we desire to find)
// result: https://app.codility.com/demo/results/trainingKNHT3H-ZZB/
int solution(vector<int> &A) {
    int n = A.size();
    if (n == 0)
    	return 0;
	unordered_map<int, int> counter;
	int sum = 0;
    for (int value: A) {
    	value = abs(value);
    	counter[value]++;
    	sum += value;
    }
    vector<int> dp(sum + 1, -1);
    dp[0] = 0;
    // takes O(M) time
    for (auto& it: counter) {
    	int value = it.first;
    	int jumps = it.second; 
    	// takes O(N*M) time
    	for (int i = 0; i <= sum; i++) {
			if (dp[i] >= 0) {
    			dp[i] = jumps;
			} else if (i >= value && dp[i - value] > 0) {
    			dp[i] = dp[i - value] - 1;
    		}
    	}
    }
    int s = sum / 2;
    while (dp[s] < 0)
    	s--;
    return (sum - 2 * s);
}

// reference
// https://stackoverflow.com/questions/50870951/iterating-over-unordered-map-c
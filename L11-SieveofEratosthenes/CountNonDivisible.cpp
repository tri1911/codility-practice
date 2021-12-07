// Date: Nov 30, 2021
// CountNonDivisible

// Input: A = [3,1,2,3,6] 
// A[0] = 3, the non-divisors are: 2, 6,
// A[1] = 1, the non-divisors are: 3, 2, 3, 6,
// A[2] = 2, the non-divisors are: 3, 3, 6,
// A[3] = 3, the non-divisors are: 2, 6,
// A[4] = 6, there aren't any non-divisors
// Output: [2, 4, 3, 2, 0]

// n = [1..50,000]
// A[i] = [1..2 * n]

#include <map>

vector<int> solution(vector<int> &A) {
	int n = A.size();
    map<int, int> counter;

    for (int num: A) {
    	counter[num]++;
    }

    vector<int> ans(n);
    for (int i = 0; i < n; i++) {
    	int value = A[i];
    	int divisorCount = 0;
    	for (int divisor = 1; divisor * divisor <= value; divisor++) {
    		if (value % divisor == 0) {
    			divisorCount += counter[divisor];
    			if (divisor * divisor != value)
    				divisorCount += counter[value/divisor];
    		}
    	}
		ans[i] = n - divisorCount;
    }
    return ans;
}

// reference:
// https://stackoverflow.com/questions/21243729/countnondivisible-codility-training-task
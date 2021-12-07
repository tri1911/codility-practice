// Date: Nov 29, 2021 -> Redo: Dec 7, 2021
// CountFactors

// Given N = 24, the function should return 8, 
// because 24 has 8 factors, namely 1, 2, 3, 4, 6, 8, 12, 24. 

// N = [1..2,147,483,647]

// time complexity: O(sqrt(n))
// space complexity: O(1)
// result: https://app.codility.com/demo/results/training5PTD6J-8VZ/
int solution(int N) {
	int ans = 0;
    for (long i = 1; i * i <= N; i++) {
        if (i * i == N)
            ans += 1;
        else if (N % i == 0)
            ans += 2;
    }
    return ans;
}

// last result: 92%
// failed test case:
// For example, for the input 2147483647 the solution exceeded the time limit.

// reference
// https://github.com/Behrouz-m/Codility/blob/master/10-PrimeAndCompositeNumbers/CountFactors.cpp
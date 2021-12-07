// Date: Dec 1, 2021
// ChocolatesByNumbers

// Given integers N = 10 and M = 4. 
// You will eat the following chocolates: 0, 4, 8, 2, 6.
// The goal is to count the number of chocolates that you will eat, which is 5

#include <vector>

// time complexity: O(log(a + b))
int gcd(int a, int b) {
	if (a % b == 0)
		return b;
	return gcd(b, a % b);
}

// general: i * M + k * N = j * M => k * N = (j-i) * M
// the first met means i = 0 => k * N = j * M
// time complexity: O(log(N + M))
int solution(int N, int M) {
    return N / gcd(N, M);
}

// reference: 
// https://codesays.com/2014/solution-to-chocolates-by-numbers-by-codility/
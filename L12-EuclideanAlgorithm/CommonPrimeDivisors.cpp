// Date: Dec 1, 2021
// CommonPrimeDivisors

// Given:
// N = 15 and M = 75, the prime divisors are the same: {3, 5};
// N = 10 and M = 30, the prime divisors aren't the same: {2, 5} is not equal to {2, 3, 5};
// N = 9 and M = 5, the prime divisors aren't the same: {3} is not equal to {5}.

// Given two non-empty arrays A and B of Z integers, 
// returns the number of positions K for which the 
// prime divisors of A[K] and B[K] are exactly the same

// For example, given:
// A = [15, 10, 3]
// B = [75, 30, 5]
// the function should return 1, because only one pair (15, 75) has the same set of prime divisors.

int gcd(int a, int b) {
	if (a % b == 0)
		return b;
	return gcd(b, a % b);
}

bool isValid(int a, int b) {
	while (a != 1) {
		int n = gcd(a, b);
		if (n == 1)
			return false;
		a /= n;
	}
	return true;
}

// time complexity: O(Z * log(max(A) + max(B))**2)
int solution(vector<int> &A, vector<int> &B) {
	int ans = 0;
	for (int i = 0; i < (int) A.size(); i++) {
		if (A[i] == B[i]) {
			ans++;
		} else if (A[i] == 1 || B[i] == 1) {
			continue;
		} else {
			int n = gcd(A[i], B[i]);
			if (n != 1 && isValid(A[i], n) && isValid(B[i], n)) {
				ans++;
			}
		}
	}
	return ans;
}

// reference: 
// https://codesays.com/2014/solution-to-common-prime-divisors-by-codility/
// https://stackoverflow.com/questions/34251682/finding-common-prime-divisors-in-two-sets-of-numbers-quickly
// Date: Nov 30, 2021
// CountSemiprimes

// A semiprime is a natural number that is the product of two 
// (not necessarily distinct) prime numbers.
// The first few semiprimes are 4, 6, 9, 10, 14, 15, 21, 22, 25, 26.

// You are given two non-empty arrays P and Q, each consisting of M integers.
// These arrays represent queries about the number of semiprimes within specified ranges.
// Query K requires you to find the number of semiprimes within the range (P[K], Q[K]),
 // where 1 ≤ P[K] ≤ Q[K] ≤ N.

// Input:
// P = [1, 4, 16]
// Q = [26, 10, 20]

// Output: [10, 4, 0]
// Explained: 
// (1, 26) is 10,
// (4, 10) is 4,
// (16, 20) is 0.

vector<int> solution(int N, vector<int> &P, vector<int> &Q) {	
	// find all prime numbers in the range (2...N/2)
	// using Sieve of Eratosthenes algorithm
	vector<bool> isPrime(N/2 + 1, true);
	isPrime[0] = isPrime[1] = false;
	for (int i = 2; i * i <= N + 2; i++) {
		if (isPrime[i]) {
			for (int j = i; i * j <= N/2; j++) {
				isPrime[i*j] = false;
			}
		}
	}

	for (int i = 0; i < (int) isPrime.size(); i++) {
		if (isPrime[i]) {
			cout << i << ", ";
		}
	}
	cout << endl;

	// find presum array of semiprime numbers
	vector<int> ps(N + 1);
	for (int i = 4; i <= N; i++) {
		ps[i] = ps[i-1];
		for (int j = 2; j * j <= i; j++) {
			cout << j << (isPrime[j] ? " is prime" : " is not prime") << endl;
			cout << "i/j: " << i/j << endl;
			cout << i/j << (isPrime[i/j] ? " is prime" : " is not prime") << endl;
			if (i % j == 0 && isPrime[j] && isPrime[i/j]) {
				cout << i << " is semi prime" << endl;
				ps[i]++;
				continue;
			}
		}
	}

	for (int i: ps) {
		cout << i << ", ";
	}
	cout << endl;

	// find the solution from the presum array
	vector<int> ans(P.size());
	for (int i = 0; i < (int) P.size(); i++) {
		ans[i] = ps[Q[i]] - ps[P[i]-1];
	}
	return ans;
}

// reference:
// https://stackoverflow.com/questions/53902549/count-the-semiprime-numbers-in-the-given-range-a-b
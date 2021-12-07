// Date: Dec 1, 2021 => Redo: Dec 6, 2021
// MinMaxDivision

// Given K, M & a non-empty array A consisting of N integers (A[i] <= M)
// Divide into K blocks with block size = [0, N]
// block sum [X, Y] = A[X] + A[X + 1] + ... + A[Y]; empty block sum = 0
// large sum = maximal sum

// Example:
// K = 3, M = 5 and A = [2, 1, 5, 1, 2, 2, 2] can be divided:
// [2, 1, 5, 1, 2, 2, 2], [], [] => large sum of 15
// [2], [1, 5, 1, 2], [2, 2] => large sum of 9
// [2, 1, 5], [], [1, 2, 2, 2] => large sum of 8
// [2, 1], [5, 1], [2, 2, 2] => large sum of 6

// The goal is to minimize the large sum
// => return 6

// N and K = [1..100,000]
// M = [0..10,000]
// A[i] = [0..M]

#include <climits>
#include <algorithm>
#include <numeric>

// time complexity: detected as O(N*log(N+M)), but I think it is O(N*log(N*M))
// space complexity: O(1)
// result: https://app.codility.com/demo/results/training236TBU-9XN/
int solution(int K, int M, vector<int> &A) {
	int N = A.size();

	int low = *max_element(A.begin(), A.end());
	int high = accumulate(A.begin(), A.end(), 0);

	if (K == 1) return high;
	if (N <= K) return low;

	cout << "inital low: " << low << endl;
	cout << "inital high: " << high << endl;

	int ans = high;

	// takes O(log(N*M))
	while (low <= high) {
		cout << "--------------" << endl;
		cout << "current low = " << low << ", high = " << high << endl;
		
		int mid = (low + high) / 2;
        cout << "current mid = " << mid << endl;

		int blocks = 1;
		int sum = 0;

		// takes O(N) times
		for (int num: A) {
			cout << "-------" << endl;
			cout << "num: " << num << endl;
			cout << "sum: " << sum << endl;
			if (sum + num > mid) {
				sum = num;
				cout << "exceeding the sum limit -> reset sum to " << sum << endl;
				cout << "complete divide the block, increase the number of blocks from " << blocks;
				blocks++;
				cout <<  " to " << blocks << endl;
			} else {
				sum += num;
				cout << "-> new sum: " << sum << endl;
			}
		}
		// update low OR high (and save mid value to ans variable)
		if (blocks <= K) {
			high = mid - 1;
			ans = mid;
		} else {
			low = mid + 1;
		}
	}
	return ans;
}

// reference
// https://stackoverflow.com/questions/42629583/need-explanation-for-algorithm-searching-minimal-large-sum
// https://codesays.com/2014/solution-to-min-max-division-by-codility/
// https://github.com/Behrouz-m/Codility/blob/master/14-BinarySearchAlgorithm/MinMaxDivision.cpp
// https://titanwolf.org/Network/Articles/Article?AID=78775a10-2f71-4374-8b53-b917c17cec67
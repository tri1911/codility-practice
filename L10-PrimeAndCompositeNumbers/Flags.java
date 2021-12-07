// Date: Dec 6, 2021
// Flags

// Peak: 0 < P < N − 1 and A[P − 1] < A[P] > A[P + 1]
// Flags can only be set on peaks. 
// if take K flags, flags' distance >= K
// The distance between indices P and Q is the absolute value |P − Q|

// Input: A = [1,5,3,4,3,4,1,2,3,4,6,2] (N = 12)
// 4 peaks: elements 1, 3, 5 and 10
// two flags, on peaks 1 and 5
// three flags, on peaks 1, 5 and 10
// four flags, impossible
// => return 3

// N = [1..400,000]
// A[i] = [0..1,000,000,000]

import java.util.*;

// time complexity: O(N * sqrt(N))
// space complexity: O(N)
// result (80% in Java but 100% in C++): https://app.codility.com/demo/results/trainingNZDQ6V-CBW/ 
public int solution(int[] A) {
	int N = A.length;
	ArrayList<Integer> peaks = new ArrayList<>();
	for (int i = 1; i < N - 1; i++) {
		if (A[i] > Math.max(A[i-1], A[i+1])) {
			peaks.add(i);
		}
	}

	if (peaks.size() == 0) {
		return 0;
	}
	int ans = 1;
	for (int flags = 2; flags * (flags - 1) <= N; flags++) {
		int setFlags = 1;
		int current = peaks.get(0);
		int minNext = current + flags;
		for (int i = 1; minNext < N && i < peaks.size(); i++) {
			if (peaks.get(i) >= minNext) {
				if (++setFlags == flags) {
					ans = flags;
					break;
				}
				current = peaks.get(i);
				minNext = current + flags;
			}
		}
	}
	return ans;
}

// reference
// https://github.com/Behrouz-m/Codility/blob/master/10-PrimeAndCompositeNumbers/Flags.cpp
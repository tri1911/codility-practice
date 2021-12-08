// Date: Nov 26, 2021 -> Redo: Dec 7, 2021
// https://app.codility.com/programmers/lessons/4-counting_elements/max_counters/

import java.util.Arrays;

// improved solution
// time complexity: O(N + M)
// space complexity: O(1)
// result: https://app.codility.com/demo/results/trainingGK5FBF-XAP/
public int[] solution(int N, int[] A) {
	int[] counters = new int[N];
        // variable that records the current global max value
	int currentMax = 0;
        // variable that records the most recent updated max value
	int recentUpdate = 0;
	for (int value: A) {
            // update max value operation
		if (value == N + 1) {
			recentUpdate = currentMax;
		} else {
			counters[value - 1] = Math.max(recentUpdate, counters[value - 1]) + 1;
                // update the global max value whenever increasing any counters
			currentMax = Math.max(currentMax, counters[value - 1]);
		}
	}
	for (int i = 0; i < N; i++) {
		counters[i] = Math.max(counters[i], recentUpdate);
	}
	return counters;
}

// first attempt
// time complexity: O(m * n) -> only 77%
// space complexity: O(1)
public int[] solution(int N, int[] A) {
	int[] ans = new int[N];
	int currentMax = 0;
	for (int num: A) { // take O(m) time
		if (num != N + 1) { // or num <= N
			currentMax = Math.max(currentMax, ++ans[num - 1]); // take O(1) time
		} else {
			Arrays.fill(ans, currentMax); // take O(n) time
		}
	}
	return ans;
}

// Reference: https://www.geeksforgeeks.org/arrays-fill-java-examples/
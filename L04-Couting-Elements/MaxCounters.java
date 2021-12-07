// Date: Nov 26, 2021
// https://app.codility.com/programmers/lessons/4-counting_elements/max_counters/

import java.util.Arrays;

// time complexity: O(m * n)?
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
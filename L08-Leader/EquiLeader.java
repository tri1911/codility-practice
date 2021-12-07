// Date: Nov 28, 2021
// EquiLeader
// An equi leader is an index S such that 0 ≤ S < N − 1 
// and two sequences A[0], A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N − 1] have leaders of the same value.
// For example, given array A such that:
//     A[0] = 4
//     A[1] = 3
//     A[2] = 4
//     A[3] = 4
//     A[4] = 4
//     A[5] = 2
// the function should return 2
// We can find two equi leaders:
// 0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.
// 2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.
// The goal is to count the number of equi leaders.

// time complexity: O(n)
// space complexity: O(n)
public int solution(int[] A) {
	// count numbers in subarray on the right
	// initially, left part is empty and right part is the entire array
	Map<Integer, Integer> rightCounters = new HashMap<>();
	Map<Integer, Integer> leftCounters = new HashMap<>();
	// takes O(n) time complexity
	for (int num: A) {
		rightCounters.put(num, rightCounters.containsKey(num) ? rightCounters.get(num) + 1 : 1);
	}

	int ans = 0;
	// the leader candidate in both subarrays
	int leader = A[0];
	// takes O(n) time complexity
	for (int i = 0; i < A.length; i++) {
		// update counters on both subarrays when shifting the A[i] to the left subarray
		leftCounters.put(A[i], leftCounters.containsKey(A[i]) ? leftCounters.get(A[i]) + 1 : 1);
		rightCounters.put(A[i], rightCounters.get(A[i]) - 1);
		// update the leader based on the shifting number
		if (i == 0 || leftCounters.get(A[i]) > leftCounters.get(leader)) {
			leader = A[i];
		}
		// verify whether the candidate is valid leader
		if (leftCounters.get(leader) > (i + 1) / 2 && rightCounters.get(leader) > (A.length - i - 1) / 2) {
			ans++;
		}
	}
	return ans;
}

// Another solution

// public int solution(int[] A) {
// 	Map<Integer, Integer> counters = new HashMap<>();
// 	for (int i = 0; i < A.length; i++) {
// 		counters.put(A[i], counters.containsKey(A[i]) ? counters.get(A[i]) + 1 : 1);
// 		if (counters.get(A[i]) > A.length / 2) {
// 			return i;
// 		}
// 	}
// 	return -1;
// }

// reference: 
// https://curt-park.github.io/2018-09-06/algorithm-equileader/
// Date: Nov 28, 2021
// Dominator
// For example, given array A such that
//  A[0] = 3    A[1] = 4    A[2] =  3
//  A[3] = 2    A[4] = 3    A[5] = -1
//  A[6] = 3    A[7] = 3
// the function may return 0, 2, 4, 6 or 7

// time complexity: O(n)
// space complexity: O(1)
public int solution(int[] A) {
	int ans = -1, size = 0;
	for (int i = 0; i < A.length; i++) {
		if (size == 0) {
			ans = i;
			size = 1;
		} else {
			if (A[i] != A[ans]) {
				size--;
			} else {
				size++;
			}
		}
	}
	if (size > 0) {
		int count = 0;
		for (int n: A) {
			if (n == A[ans]) {
				count++;
			}
		}
		return count > A.length / 2 ? ans : -1;
	}
	return -1;
}

// another linear solution
// time complexity O(n)
// space complexity O(n)
public int solution(int[] A) {
	Map<Integer, Integer> counters = new HashMap<>();
	for (int i = 0; i < A.length; i++) {
		if (!counters.containsKey(A[i])) {
			counters.put(A[i], 1);
		} else {
			counters.put(A[i], counters.get(A[i]) + 1);
		}
		if (counters.get(A[i]) > A.length / 2) {
			return i;
		}
	}
	return -1;
}

// Failed Test case:
// For example, for the input [2, 1, 1, 3, 4] 
// the solution returned a wrong answer (got 4, but element is not a dominator,
// value 4 has only 1 occurences (n = 5)).

// reference: 
// https://www.youtube.com/watch?v=OOqiQP9lQXA
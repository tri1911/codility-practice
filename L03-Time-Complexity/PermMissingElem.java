// Date: Nov 26, 2021
// https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/

// using hash table
// time complexity: O(n)
// space complexity: O(n)
public int solution(int[] A) {
	int n = A.length;
	boolean []exists = new boolean[n + 2];
	for (int i: A) {
		exists[i] = true;
	}

	for (int i = 1; i <= n + 1; i++) {
		if(!exists[i]) {
			return i;
		}
	}
	return -1;
}
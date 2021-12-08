// Date: Nov 26, 2021
// https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/

// using hash table
// time complexity: O(n)
// space complexity: O(n)
// result: https://app.codility.com/demo/results/trainingVEEH9T-58E/
public int solution(int[] A) {
	int N = A.length;
	if (N == 0) return 1;
	boolean[] exists = new boolean[N + 2];
	for (int value : A) {
		exists[value] = true;
	}
	int ans = 1;
	while (exists[ans]) {
		ans++;
	}
	return ans;
}
// Date: Nov 26, 2021
// https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/

// use Sliding Window Technique
// time complexity: O(n)
// space complexity: O(1)
public int solution(int[] A) {
	int n = A.length;
	int ans = 0;
	// calculate the sum of elements in array
	for (int num: A) {
		ans += num;
	}

	int first = 0, second = ans;
	for (int i = 1; i < n; i++) {
		first += A[i - 1];
		second -= A[i - 1];
		ans = Math.min(ans, Math.abs(first - second));
	}
	return ans;
}
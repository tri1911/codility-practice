// Date: Nov 26, 2021
// https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/

// use Sliding Window Technique
// time complexity: O(n)
// space complexity: O(1)
// result: https://app.codility.com/demo/results/trainingEXK2ZS-7XY/
public int solution(int[] A) {
	int N = A.length;
	int leftSum = A[0], rightSum = 0;
	for (int i = 1; i < N; i++) {
		rightSum += A[i];
	}
	int ans = Math.abs(leftSum - rightSum);
	for (int i = 1; i < N - 1; i++) {
		leftSum += A[i];
		rightSum -= A[i];
		ans = Math.min(ans, Math.abs(leftSum - rightSum));
	}
	return ans;
}
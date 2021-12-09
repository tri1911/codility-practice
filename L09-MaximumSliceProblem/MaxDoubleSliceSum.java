// Date: Dec 8, 2021
// MaxDoubleSliceSum

// find max sum of double slice
// N = [3, 100000]
// A[i] = [-10000, 10000]

public class MaxDoubleSliceSum {
    // time complexity: O(n)
    // space complexity: O(1)
    // result: https://app.codility.com/demo/results/trainingPS22SH-9FH/
	public static int solution(int[] A) {
		int N = A.length;
        // find the max sum of the slice ending at ith
        // 1. left: from 1 to n - 2
        // 2. right: from n - 2 to 1
		int[][] dp = new int[2][N];
		for (int left = 2, right = N - 1 - left; left <= N - 2 && right >= 1; right = N - 1 - ++left) {
			dp[0][left] = Math.max(dp[0][left - 1] + A[left - 1], 0);
			dp[1][right] = Math.max(dp[1][right + 1] + A[right + 1], 0);
		}
        int ans = dp[0][1] + dp[1][1]; // mid at 1st index
        for (int mid = 2; mid < N - 1; mid++) {
        	ans = Math.max(dp[0][mid] + dp[1][mid], ans);
        }
        return ans;
    }

    public static void main(String[] args) {
    	System.out.println("Expected: 17. Received: " + solution(new int[]{3, 2, 6, -1, 4, 5, -1, 2}));
    	System.out.println("Expected: 0. Received: " + solution(new int[]{-33, 2332, -323231}));
    	System.out.println("Expected: 17. Received: " + solution(new int[]{5, 17, 0, 3}));
    	System.out.println("Expected: 10. Received: " + solution(new int[]{0, 10, -5, -2, 0}));
    }
}
// Date: Nov 28, 2021
// MaxProfit (similar to https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)

// time complexity: O(n)
// space complexity: O(1)
int solution(vector<int> &A) {
	if (A.size() < 2)
		return 0;
    int ans = 0;
    int min_buy = A[0];
    for (int i = 0; i < (int) A.size(); i++) {
    	ans = max(ans, A[i] - min_buy);
    	min_buy = min(min_buy, A[i]);
    }
    return ans;
}

// failed test case
// [5, 4, 3, 2, 1] the solution returned a wrong answer (got 2 expected 0).
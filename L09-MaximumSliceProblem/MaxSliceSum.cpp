// Date: Nov 28, 2021
// MaxSliceSum (similar to https://leetcode.com/problems/maximum-subarray/)

// time complexity: O(n)
// space complexity: O(1)
int solution(vector<int> &A) {
    int current = A[0];
    int ans = current;
    for (int i = 1; i < (int) A.size(); i++) {
    	current = max(current + A[i], A[i]);
    	ans = max(ans, current);
    }
    return ans;
}

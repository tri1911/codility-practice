// Date: Nov 26, 2021

// time complexity: O(n)
// space complexity: O(1)
public int solution(int[] A) {
	int ans = A[0];
	for (int i = 1; i < A.length; i++) {
		ans ^= A[i]; // uses XOR bitwise operation
	}
	return ans;
}
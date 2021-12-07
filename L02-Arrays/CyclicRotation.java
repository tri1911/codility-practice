// Date: Nov 26, 2021

// helper function
private void reverse(int [] A, int begin, int end) {
	while (begin < end) {
		int tmp = A[begin];
		A[begin++] = A[end];
		A[end--] = tmp;
	}
}

// time complexity: O(n)
// space complexity: O(1)
public int[] solution(int[] A, int K) {
	int n = A.length;
	K = K % n;
	reverse(A, 0, n - 1);
	reverse(A, 0, K - 1);
	reverse(A, K, n - 1);
}
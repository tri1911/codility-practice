// Date: Nov 26, 2021

// helper function with time complexity O(n)
public static void reverse(int[] A, int first, int last) {
	while (first < last) {
		int tmp = A[first];
		A[first++] = A[last];
		A[last--] = tmp;
	}
}

// time complexity: O(N)
// space complexity: O(1)
public static int[] solution(int[] A, int K) {
	int N = A.length;
	if (N == 0) return A;
	K %= N;
	if (K > 0) {
		reverse(A, 0, N - 1);
		reverse(A, 0, K - 1);
		reverse(A, K, N - 1);
	}
	return A;
}
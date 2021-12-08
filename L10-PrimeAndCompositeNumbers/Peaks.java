// Date: Dec 8, 2021
// Peaks

// time complexity: O(N * log(log(N)))
// space complexity: O(N)
// result: https://app.codility.com/demo/results/trainingQTP2Y8-F5Y/
public static int solution(int[] A) {
	int N = A.length;
	if (N < 3) {
		return 0;
	}
	int[] peaksPreSum = new int[N];
	for (int i = 1; i < N - 1; i++) {
		peaksPreSum[i] = peaksPreSum[i - 1];
		if (A[i] > Math.max(A[i - 1], A[i + 1])) {
			peaksPreSum[i]++;
		}
	}
	peaksPreSum[N-1] = peaksPreSum[N-2];
	if (peaksPreSum[N-1] == 0) {
		return 0;
	}
	for (int k = peaksPreSum[N-1]; k >= 2; k--) {
		if (N % k == 0) {
			int blockLen = N / k;
			int validBlocks = 0;
			for (int blockIndex = 0; blockIndex < k; blockIndex++) {
				int start = blockIndex * blockLen;
				int end = start + blockLen - 1;
				if ((blockIndex == 0 && peaksPreSum[end] == 0) || (blockIndex > 0 && peaksPreSum[end] == peaksPreSum[start - 1])) {
					break;
				}
				validBlocks++;
			}
			if (validBlocks == k) {
				return k;
			}
		}
	}
	return 1;
}
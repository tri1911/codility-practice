// Date: Nov 27, 2021 (Not Done) => Redo: Dec 6, 2021
// https://app.codility.com/programmers/lessons/5-prefix_sums/min_avg_two_slice/

// 0 ≤ P < Q < N (the slice contains at least two elements)
// average = (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1)

// Example: A = [4, 2, 2, 5, 1, 5, 8]
// slice (1, 2), whose average is (2 + 2) / 2 = 2
// slice (3, 4), whose average is (5 + 1) / 2 = 3
// slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5

// => the function should return 1 
// (the starting position of a slice whose average is minimal)

// N is an integer within the range [2..100,000]
// each element of array A is an integer within the range [−10,000..10,000].

// Proof: with m, n >= 2 (we only care about slice with size of at least 2)
// slice A with m elements: a = A / m
// slice B with n elements: b = B / n
// question is does it necessarily to check for slice that combines of A and B?
// combined slice has average c = (m*a + n*b) / (m+n)
// => sum of elements = c*(m+n) = m*a + n*b
// there are 3 possibilities
// 1. a = b => c*(m+n) = a*(m+n) => a = c => the average of combined slice is equivalent to the original average of A or B
// 2. a > b => c*(m+n) > b*(m+n) => c > b => the average of combined slice is not our solution
// 3. a < b => c*(m+n) < a*(m+n) => c > a => the average of combined slice is not our solution
// => the average of combined slices (size >= 4) of A and B is always not our solution
// => Only need to check for slices (ending at ith index) with the size of 2 and 3

// dynamic programming, sliding window approach (or presum if need but it required extra space complexity)
// time complexity: O(n)
// space complexity: O(1)
// result: https://app.codility.com/demo/results/trainingXEFDET-RFZ/
public int solution(int[] A) {
	int n = A.length;
	if (n < 3) {
		return 0;
	}
	int minSumOf2, index2;
	int minSumOf3, index3;
	if (A[0] < A[2]) {
		minSumOf2 = A[0] + A[1];
		index2 = 0;
	} else {
		minSumOf2 = A[1] + A[2];
		index2 = 1;
	}
	minSumOf3 = A[0] + A[1] + A[2];
	index3 = 0;

	int current2 = A[1] + A[2], current3 = A[0] + A[1] + A[2];
	for (int i = 3; i < n; i++) {
		current2 = current2 - A[i-2] + A[i];
		if (current2 < minSumOf2) {
			index2 = i - 1;
			minSumOf2 = current2;
		}
		current3 = current3 - A[i-3] + A[i];
		if (current3 < minSumOf3) {
			index3 = i - 2;
			minSumOf3 = current3;
		}
	}
	double ans2 = minSumOf2 / 2.0d;
	double ans3 = minSumOf3 / 3.0d;
	return (ans2 == ans3) ? Math.min(index2, index3) : ((ans2 < ans3) ? index2 : index3);
}

// reference
// https://stackoverflow.com/questions/21635397/min-average-two-slice-codility/46258952
// https://github.com/Behrouz-m/Codility/blob/master/05-PrefixSums/MinAvgTwoSlice.cpp
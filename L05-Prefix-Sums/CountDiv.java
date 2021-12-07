// Date: Nov 26, 2021
// https://app.codility.com/programmers/lessons/5-prefix_sums/count_div/

// time complexity: O(1)
// space complexity: O(1)
public int solution(int A, int B, int K) {
	if (K > B) {
		if (A > 0) {
			return 0;
		} else {
			return 1;
		}
	}
	int high = (int) Math.floor((double) B / K);
	int low = (int) Math.ceil((double) A / K);
	return (high - low + 1);
}

// Test Cases:
// A = B in {0, 1}, K = 11 => expect 1

// Recruiment swap: Integer Decimal Occurrence
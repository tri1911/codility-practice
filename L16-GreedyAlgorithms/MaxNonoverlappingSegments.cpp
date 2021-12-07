// Date: Dec 3, 2021
// MaxNonoverlappingSegments

// Segment positions are given in arrays A and B
// Segments are sorted by their ends

// find the size of a non-overlapping set containing the maximal number of segments

// For example
// A = [1,3,7,9,9]
// B = [5,6,8,9,10]
// The size of a non-overlapping set containing a maximal number of segments is 3. 
// For example, possible sets are {0, 2, 3}, {0, 2, 4}, {1, 2, 3} or {1, 2, 4}. 
// There is no non-overlapping set with four segments.
// =>  the function should return 3

// N is an integer within the range [0..30,000];
// each element of arrays A and B is an integer within the range [0..1,000,000,000];
// A[I] ≤ B[I], for each I (0 ≤ I < N);
// B[K] ≤ B[K + 1], for each K (0 ≤ K < N − 1).

// time complexity: O(n)
int solution(vector<int> &A, vector<int> &B) {
	int n = A.size();
	if (n == 0)
		return 0;
	int count = 1;
	int prev = B[0];
	for (int i = 1; i < n; i++) {
		if (prev < A[i]) {
			count++;
			prev = B[i];
		}
	}
	return count;
}

// reference
// https://github.com/Behrouz-m/Codility/blob/master/16-GreedyAlgorithms/MaxNonoverlappingSegments.cpp
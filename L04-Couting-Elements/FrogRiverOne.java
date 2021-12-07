// Date: Nov 26, 2021 (Not Done) -> Redo: Dec 6, 2021
// https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one/

// Given integer X = 5 and array A such that:
// A[0] = 1
// A[1] = 3
// A[2] = 1
// A[3] = 4
// A[4] = 2
// A[5] = 3
// A[6] = 5
// A[7] = 4
// In second 6, a leaf falls into position 5. 
// This is the earliest time when leaves appear in every position across the river.
// => the function should return 6

// If the frog is never able to jump to the other side of the river, 
// the function should return −1.

// N and X are integers within the range [1..100,000];
// each element of array A is an integer within the range [1..X]

// time complexity: O(N)
// space complezity: O(X)
// result: https://app.codility.com/demo/results/trainingSDPXMS-R9B/
public int solution(int X, int[] A) {
	int n = A.length;
	int count = 0;
	boolean[] filled = new boolean[X+1];
	for (int i = 0; i < n; i++) {
		if (!filled[A[i]]) {
			filled[A[i]] = true;
			count++;
			if (count == X) {
				return i;
			}
		}
	}
	return -1;
}
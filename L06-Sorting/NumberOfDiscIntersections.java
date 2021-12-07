// Date: Nov 27, 2021
// Similar to https://leetcode.com/problems/interval-list-intersections/

public int solution(int[] A) {
	int ans = 0;
	for (int i = 0; i < A.length; i++) {
		int start = A[i] - i;
		int end = A[i] + i;

	}
	return ans;
}

// A[0] = 1
// A[1] = 5
// A[2] = 2
// A[3] = 1
// A[4] = 4
// A[5] = 0
// We can represent the array as intervals:
// [-1,1], [-4,6], [0,4], [2,4], [0,8], [5,5]


//  -4 -1 0 1 2 4 5 6 8

//  -4              6
//     -1   1
//        0     4
//        0           8
//            2 4
//                5


// (start1 <= start2 and end1 <= end2) OR (start1 == end2) OR (start2 == end1)
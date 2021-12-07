// Date: Nov 29, 2021
// MinPerimeterRectangle

// Given integer N = 30, rectangles of area 30 are:
// (1, 30), with a perimeter of 62,
// (2, 15), with a perimeter of 34,
// (3, 10), with a perimeter of 26,
// (5, 6), with a perimeter of 22.
// => the function should return 22

#include <bits/stdc++.h>

// time complexity: O(sqrt(n))
// space complexity: O(1)
int solution(int N) {
    int ans = INT_MAX;
    for (int i = 1; i * i <= N; i++) {
    	if (N % i == 0)
    		ans = min(ans, 2 * (i + N/i));
    }
    return ans;
}
// Date: Nov 26, 2021
// https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/

// time complexity: O(1)
// space complexity: O(1)
public int solution(int X, int Y, int D) {
	return ((Y - X - 1) / D) + 1;
}
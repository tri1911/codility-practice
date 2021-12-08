// Date: Nov 26, 2021
// https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/

// time complexity: O(1)
// space complexity: O(1)
// result: https://app.codility.com/demo/results/trainingU8JAWS-BF4/
public int solution(int X, int Y, int D) {
	// return ((Y - X - 1) / D) + 1;
	return (int) Math.ceil(1.0 * (Y - X) / D);
}
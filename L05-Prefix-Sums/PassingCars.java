// Date: Nov 26, 2021
// https://app.codility.com/programmers/lessons/5-prefix_sums/passing_cars/

// time complexity O(n)
// space complexity O(1)
public int solution(int[] A) {
	int ans = 0;
	int zeros = 0;
	for (int num: A) {
		if (num == 0) {
			zeros++;
		} else {
			ans += zeros;
			if (ans > 1000000000) {
				return -1;
			}
		}
	}
	return ans;
}

// Reference Solution: https://www.youtube.com/watch?v=jJ4SqaHRofo
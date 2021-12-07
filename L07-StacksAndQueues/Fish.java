// Date: Nov 28, 2021
// Fish

// Example:
// A = [4,3,2,1,5]
// B = [0,1,0,0,0]
// return 2

// time complexity: O(n)
// space complexity: O(n)
public int solution(int[] A, int[] B) {
	int n = A.length;
	int ans = 0;
	Stack<Integer> stk = new Stack<>();
	int i = 0;
	int direction, size;
	while (i < n) {
		direction = B[i];
		size = A[i];
		if (direction == 0) { // go upstream
			if (stk.empty()) { // no fish downstream
				ans++;
			} else {
				if (size > stk.peek()) { // bigger than the fish going downstream
					stk.pop();
					continue;
				}
			}
		} else { // go downstream
			stk.push(size);
		}
		i++;
	}
	return ans + stk.size();
}
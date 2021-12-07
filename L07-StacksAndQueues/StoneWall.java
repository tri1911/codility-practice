// Date: Nov 28, 2021
// StoneWall
// Example:
// H = [8, 8, 5, 7, 9, 8, 7, 4, 8
// return 7

// time complexity: O(n)
// space complexity: O(n)
public int solution(int[] H) {
	int ans = 0;
	Stack<Integer> stk = new Stack<>();
	for (int height: H) {
		while (!stk.empty() && height < stk.peek()) {
			stk.pop();
			ans++;
		}
		if (!stk.empty() && height == stk.peek()) {
			continue;
		}
		stk.push(height);
	}
	return ans + stk.size();
}
// Date: Nov 28, 2021
// Nesting
// Given S = "(()(())())", the function should return 1
// Given S = "())", the function should return 0

// time complexity: O(n)
// space complexity: O(n)
public int solution(String S) {
	Stack<Character> stk = new Stack<>();
	for (char ch: S.toCharArray()) {
		if (ch == '(') {
			stk.push(')');
		} else if (stk.empty() || ch != stk.pop()) {
			return 0;
		}
	}
	return stk.empty() ? 1 : 0;
}
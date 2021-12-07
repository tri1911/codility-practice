// Date: Nov 28, 2021
// Brackets - Similar to https://leetcode.com/problems/valid-parentheses/
// Given S = "{[()()]}", the function should return 1
// Given S = "([)()]", the function should return 0

import java.util.*;

// time complexity: O(n)
// space complexity: O(n)
public int solution(String S) {
	Stack<Character> stk = new Stack<>();
	for (char ch: S.toCharArray()) {
		switch (ch) {
			case '{':
				stk.push('}');
				break;
			case '[':
				stk.push(']');
				break;
			case '(':
				stk.push(')');
				break;
			default:
				if (stk.empty() || ch != stk.pop())
					return 0;
		}
	}
	return stk.empty() ? 1 : 0;
}

// Reference: 
// https://stackoverflow.com/questions/196830/what-is-the-easiest-best-most-correct-way-to-iterate-through-the-characters-of-a
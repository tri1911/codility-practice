// Date: Nov 26, 2021

public class Solution {
	// time complexity O(n) where n is the number of digits of the binary representation
	// space complexity O(1)
	public int solution(int N) {
		// take O(logN) time to convert the integer N into binary string
		String binStr = Integer.toString(N, 2);

		int ans = 0;
		int last = -1;

		for (int i = 0; i < binStr.length(); i++) {
			char ch = binStr.charAt(i);
			if (ch == '1') {
				if (last != -1) {
					ans = Math.max(ans, i - last - 1);
				}
				last = i;
			}
		}
		return ans;
	}
}
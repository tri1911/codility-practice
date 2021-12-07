// Date: Nov 27, 2021
// MaxProductOfTree.java
// Similar to https://leetcode.com/problems/maximum-product-of-three-numbers/

// time complexity: O(n)
// space complexity: O(1)
public int solution(int[] A) {
	// min1 < min2
    int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
    // max1 > max2 > max3
    int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

    // take O(n) times
    for (int num: A) {
    	// update min1, min2
    	if (num <= min1) {
    		min2 = min1;
    		min1 = num;
    	} else if (num < min2) { // min1 < num < min2
    		min2 = num;
    	}

    	// update max1, max2, max3
    	if (num >= max1) {
    		max3 = max2;
    		max2 = max1;
    		max1 = num;
    	} else if (num >= max2) { // max2 <= num < max1
    		max3 = max2;
    		max2 = num;
    	} else if (num >= max3) { // max3 <= num < max2
    		max3 = num;
    	}
    }

    return Math.max(min1 * min2 * max1, max1 * max2 * max3);
}
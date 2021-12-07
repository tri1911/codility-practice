// Date: Nov 26, 2021
// https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/

// import java.util.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// time complexity: O(n)
// space complexity: O(n)
public int solution(int[] A) {
	Integer[] boxedArray = Arrays.stream(A) // IntStream
								 .boxed()   // Stream<Integer>
                                 .toArray(Integer[]::new);
	// take O(n) time
	Set<Integer> set = new HashSet<>(Arrays.asList(boxedArray));
	int ans = 1;
	// take O(n) time
	// worst case: 1, 2, 3, 4, 5
	while (set.contains(ans)) {
		ans++;
	}
	return ans;
}

// References: 
// https://simplenotions.wordpress.com/2009/05/13/java-standard-data-structures-big-o-notation/
// https://www.tutorialspoint.com/difference-between-hashmap-and-hashset-in-java#:~:text=HashMap%20and%20HashSet%20both%20are,classes%20of%20Java%20Collection%20framework.&text=HashMap%20Stores%20elements%20in%20form,such%20key%20value%20pairs%20maintained.
// https://www.tutorialspoint.com/checking-if-a-hashset-contains-certain-value-in-java
// https://www.techiedelight.com/convert-int-array-integer-array-java/
// N = [1...50000]
// A[i] = [1...2*N]

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountNonDivisible {
    // time complexity: O(N * log(N))
    // space complexity: O(N)
    // result: https://app.codility.com/demo/results/training7V9TWC-Z65/
    public static int[] solution(int[] A) {
        int N = A.length;
        if (N == 1) return new int[]{0};
        int[] ans = new int[N];
        Map<Integer, Integer> counters = new HashMap<>();
        for (int value : A) {
            if (counters.containsKey(value)) {
                counters.replace(value, counters.get(value) + 1);
            } else {
                counters.put(value, 1);
            }
        }
        for (int i = 0; i < N; i++) {
            int divisorCount = 0;
            for (int j = 1; j * j <= A[i]; j++) {
                if (A[i] % j == 0) {
                    int other = A[i] / j;
                    divisorCount += counters.containsKey(j) ? counters.get(j) : 0;
                    if (other != j) {
                        divisorCount += counters.containsKey(other) ? counters.get(other) : 0;
                    }
                }
            }
            ans[i] = N - divisorCount;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("Expect: [2, 4, 3, 2, 0]. Received: " + Arrays.toString(solution(new int[]{3, 1, 2, 3, 6})));
    }
}

package elliot.codility.lessons.sieveOfEratosthenes;

// N = [1...50,000]
// M = [1...30,000]
// P[i], Q[i] = [1..N]
// P[i] ≤ Q[i]

import java.util.Arrays;

public class CountSemiprimes {
    // detected time complexity: O(N * log(log(N)) + M)
    // result: https://app.codility.com/demo/results/trainingB9UABQ-W6H/
    public static int[] solution(int N, int[] P, int[] Q) {
        // array to check prime numbers using sieve algorithm
        boolean[] primes = new boolean[N + 1];
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;
        for (int i = 2; i * i <= N; i++) {
            if (primes[i]) {
                for (int j = i; i * j <= N; j++) {
                    primes[i * j] = false;
                }
            }
        }
        // create a pre-sum array for semi-prime numbers range from 1 to N
        int[] ps = new int[N + 1];
        for (int i = 4; i <= N; i++) {
            ps[i] = ps[i - 1];
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0 && primes[j] && primes[i / j]) {
                    // System.out.println(i + " is semi-prime");
                    ps[i] = ps[i - 1] + 1;
                }
            }
        }

        int M = P.length;
        int[] ans = new int[M];
        for (int i = 0; i < M; i++) {
            ans[i] = ps[Q[i]] - ps[P[i] - 1];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("Expect: [10, 4, 0]. Received: " + Arrays.toString(solution(26, new int[]{1, 4, 16}, new int[]{26, 10, 20})));
    }
}

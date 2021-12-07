// Date: Nov 26, 2021 (Not get 100%) => Redo: Dec 6, 2021
// https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query/

// A, C, G, T = 1, 2, 3, 4, respectively
// Example:
// S = CAGCCTA
// P = [2,5,0]
// Q = [4,5,6]
// from P[0] to Q[0] = from 2 to 4: ans[0] = min(G,C) = C = 2
// from P[1] to Q[1] = from 5 to 5: ans[1] = min(T) = T = 4
// from P[2] to Q[2] = from 0 to 6: ans[2] = A = 1
// returns [2, 4, 1]

// N is an integer within the range [1..100,000]
// M is an integer within the range [1..50,000]
// each element of arrays P and Q is an integer within the range [0..N − 1]
// P[K] ≤ Q[K], where 0 ≤ K < M
// string S consists only of upper-case English letters A, C, G, T

import java.util.*;

// presum approach
// time complexity: O(M+N)
// space complexity: O(N)
// result: https://app.codility.com/demo/results/trainingBCVAJU-ZTE/
public int[] solution(String S, int[] P, int[] Q) {
	int N = S.length(), M = P.length;
	Map<Character, Integer> dict = new HashMap<>();
	dict.put('A', 1);
	dict.put('C', 2);
	dict.put('G', 3);
	dict.put('T', 4);
	int[][] ps = new int[4][N];
	for (int i = 0; i < N; i++) {
		int value = dict.get(S.charAt(i)) - 1;
		for (int j = 0; j < 4; j++) {
			if (i == 0) {
				ps[value][i] = 1;
			} else {
				ps[j][i] = ps[j][i-1] + (value == j ? 1 : 0);
			}
		}
	}
	for (int[] row : ps) {
		for (int sum : row) {
			System.out.print(sum + " ");
		}
		System.out.println();
	}
	int[] ans = new int[M];
	for (int i = 0; i < M; i++) {
		int start = P[i], end = Q[i];
		System.out.println("start: " + start);
		System.out.println("end: " + end);
		if (start == end) {
			ans[i] = dict.get(S.charAt(start));
		} else {
			for (int j = 0; j < 4; j++) {
				if (start == 0 && ps[j][end] > 0 || start > 0 && ps[j][start - 1] < ps[j][end]) {
					ans[i] = j + 1;
					break;
				}
			}
		}
		System.out.println("ans[" + i + "]: " + ans[i]);
	}
	return ans;
}

// reference
// https://www.youtube.com/watch?v=4SyckIAmYXk&t=444s
// https://stackoverflow.com/questions/19552754/java-codility-training-genomic-range-query
// https://github.com/Behrouz-m/Codility/blob/master/05-PrefixSums/GenomicRangeQuery.cpp
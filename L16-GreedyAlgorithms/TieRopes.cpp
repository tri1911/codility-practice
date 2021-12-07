// Date: Dec 3, 2021
// TieRopes

// Two adjacent ropes can be tied together with a knot, and the length of the tied rope is the sum of lengths of both ropes.
// The resulting new rope can then be tied again
// A = [1, 2, 3, 4, 1, 1, 3] and K = 4
// For a given integer K, the goal is to tie the ropes in such a way that the number of ropes whose length 
// is greater than or equal to K is maximal.
// We can tie:
// rope 1 with rope 2 to produce a rope of length A[1] + A[2] = 5;
// rope 4 with rope 5 with rope 6 to produce a rope of length A[4] + A[5] + A[6] = 5.
// After that, there will be three ropes whose lengths are greater than or equal to K = 4.
// => the function should return 3

// Greedy method
// time complexity: O(n)
// space complexity: O(1)
int solution(int K, vector<int> &A) {
    int ans = 0;
    int current = 0;
    for (int num: A) {
    	current += num;
    	if (current >= K) {
    		current = 0;
    		ans++;
    	}
    }
    return ans;
}
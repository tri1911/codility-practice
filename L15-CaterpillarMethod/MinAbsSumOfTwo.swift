import Foundation
// result: https://app.codility.com/demo/results/training79VXSQ-KG9/
public class MinAbsSumOfTwo {
    public func solution(_ A : inout [Int]) -> Int {
        A.sort();
        var left = 0, right = A.count - 1;
        if A[left] >= 0 { return 2 * A[left] }
        if A[right] <= 0 { return -2 * A[right] }
        var answer = Int.max;
        while left < right {
            var best = min(abs(2 * A[left]), abs(2 * A[right]));
            best = min(best, abs(A[left] + A[right]));
            answer = min(answer, best);
            if abs(A[left] + A[right - 1]) < abs(A[left + 1] + A[right]) {
                right -= 1;
            } else {
                left += 1;
            }
        }
        return answer;
    }
}

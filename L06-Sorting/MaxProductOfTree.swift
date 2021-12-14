import Foundation
// result: https://app.codility.com/demo/results/trainingRBK2Q5-4UA/
public class MaxProductOfTree {
    public static func solution(_ A : inout [Int]) -> Int {
        let N = A.count
        A.sort()
        return max(A[0] * A[1] * A[N - 1], A[N - 1] * A[N - 2] * A[N - 3])
    }
}

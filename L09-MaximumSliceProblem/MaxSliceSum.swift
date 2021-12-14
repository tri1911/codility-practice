import Foundation
// result: https://app.codility.com/demo/results/trainingYU3JBS-GVP/
public class MaxSliceSum {
    public func solution(_ A : inout [Int]) -> Int {
        var currentSum = A[0]
        var maxSliceSum = currentSum
        for i in 1..<A.count {
            currentSum = max(A[i], A[i] + currentSum)
            maxSliceSum = max(maxSliceSum, currentSum)
        }
        return maxSliceSum
    }
}

import Foundation
// result: https://app.codility.com/demo/results/training8UMSX8-QR4/
public class MaxDoubleSliceSum {
    public func solution(_ A : inout [Int]) -> Int {
        let n = A.count
        var leftSum = [Int](repeating: 0, count: n)
        var rightSum = [Int](repeating: 0, count: n)
        for i in 1..<n-1 {
            if i == 1 {
                leftSum[i] = 0
                rightSum[n - i] = 0
            } else {
                // leftSum[i - 1] >= 0 -> A[i - 1] + leftSum[i - 1] >= A[i - 1]
                leftSum[i] = max(A[i - 1] + leftSum[i - 1], 0)
                rightSum[n - 1 - i] = max(A[n - i] + rightSum[n - i], 0)
            }
        }
        var maxSum = 0
        for mid in 1..<n-1 {
            maxSum = max(maxSum, leftSum[mid] + rightSum[mid])
        }
        return maxSum
    }
}

import Foundation
// result: https://app.codility.com/demo/results/trainingJHB5ZB-NKP/
class MaxNonoverlappingSegments {
    public func solution(_ A : inout [Int], _ B : inout [Int]) -> Int {
        let n = A.count
        if n == 0 { return 0 }
        var count = 1
        var lastEnd = B[0]
        for i in 1..<n {
            if A[i] > lastEnd {
                count += 1
                lastEnd = B[i]
            }
        }
        return count
    }
}

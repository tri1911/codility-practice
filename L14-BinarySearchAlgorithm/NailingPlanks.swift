import Foundation
// result: https://app.codility.com/demo/results/training56CSDE-PD9/
// each integer in A, B and C = [1...2*M] where M is the size of C
public class NailingPlanks {
    public func solution(_ A : inout [Int], _ B : inout [Int], _ C : inout [Int]) -> Int {
        let n = A.count, m = C.count
        var answer = -1
        var low = 0, high = m - 1
        var mid: Int
        while low <= high {
            mid = (low + high) / 2
            var psNails = [Int](repeating: 0, count: 2 * m + 1)
            for position in C[0...mid] {
                psNails[position] = 1
            }
            for i in 1...2*m {
                psNails[i] += psNails[i-1]
            }
            var nailedPlanks = 0
            for i in 0..<A.count {
                if psNails[B[i]] > psNails[A[i] - 1] {
                    nailedPlanks += 1
                }
            }
            if nailedPlanks == n {
                high = mid - 1
                answer = mid + 1
            } else {
                low = mid + 1
            }
        }
        return answer
    }
}

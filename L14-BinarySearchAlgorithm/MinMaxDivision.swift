import Foundation
// result: https://app.codility.com/demo/results/trainingC2KSQ5-NFQ/
public class MinMaxDivision {
    public func solution(_ K : Int, _ M : Int, _ A : inout [Int]) -> Int {
        var low = A.max()!
        var high = A.reduce(0, +)
        if A.count == 1 { return low }
        if K == 1 { return high }
        var mid: Int
        var answer = high
        while low <= high {
            mid = (low + high) / 2
            var currentSum = 0
            var blocks = 1
            for value in A {
                if currentSum + value > mid {
                    currentSum = value
                    blocks += 1
                } else {
                    currentSum += value
                }
            }
            if blocks <= K {
                high = mid - 1
                answer = mid
            } else {
                low = mid + 1
            }
        }
        return answer
    }
}

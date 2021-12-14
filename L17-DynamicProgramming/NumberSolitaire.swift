import Foundation
// result: https://app.codility.com/demo/results/trainingQTC5MP-A23/=
public class NumberSolitaire {
    public func solution(_ A : inout [Int]) -> Int {
        let n = A.count
        var answer = [Int](repeating: 0, count: n)
        answer[0] = A[0]
        for i in 1..<n {
            var best = Int.min
            for j in 1...6 {
                if i - j >= 0 {
                    best = max(best, answer[i-j])
                } else {
                    break
                }
            }
            answer[i] = A[i] + best
        }
        return answer[n-1]
    }
}

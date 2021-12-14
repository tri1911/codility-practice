import Foundation
// result: https://app.codility.com/demo/results/training83UPKG-N7U/
public class Flags {
    public static func solution(_ A : inout [Int]) -> Int {
        let n = A.count
        if n < 3 { return 0 }
        var peaks = [Int]()
        for i in 1..<n-1 {
            if A[i] > max(A[i-1], A[i+1]) {
                peaks.append(i)
            }
        }
        if peaks.isEmpty {
            return 0
        }
        var answer = 1
        var k = 1
        while k * (k - 1) < n {
            var setFlags = 1
            var current = peaks[0]
            var minNext = current + k
            for i in 1..<peaks.count {
                if peaks[i] >= minNext {
                    setFlags += 1
                    if setFlags == k {
                        answer = k
                    }
                    current = peaks[i]
                    minNext = current + k
                }
            }
            k += 1
        }
        return answer
    }
}

// For example, for the input [5] the solution terminated unexpectedly.

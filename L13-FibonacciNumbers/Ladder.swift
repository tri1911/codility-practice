import Foundation
// result: https://app.codility.com/demo/results/trainingQTD586-WN4/
public class Ladder {
    public static func solution(_ A : inout [Int], _ B : inout [Int]) -> [Int] {
        let L = A.count
        var dp = [Int](repeating: 0, count: L + 1)
        var i = 1
        while i <= L {
            if i == 1 {
                dp[i] = 1
            } else if i == 2 {
                dp[i] = 2
            } else {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 2 << (30 - 1)
            }
            i += 1
        }
        var answer = [Int]()
        for i in 0..<L {
            answer.append(dp[A[i]] % 2 << (B[i] - 1))
        }
        return answer
    }
}

// https://stackoverflow.com/questions/24065801/exponentiation-operator-in-swift

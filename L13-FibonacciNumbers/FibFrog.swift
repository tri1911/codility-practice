import Foundation
// result: https://app.codility.com/demo/results/training6MMCZN-W8M/
public class FibFrog {
    public static func solution(_ A : inout [Int]) -> Int {
        let n = A.count
        var fib = [0, 1, 1]
        var i = 3
        while fib[i - 1] < n + 1 {
            fib.append(fib[i - 2] + fib[i - 1])
            i += 1
        }
        // print("fib = \(fib)")
        var dp = [Int](repeating: Int.max, count: n + 1)
        for i in 0...n {
            // print("current i = \(i)")
            if i == n || A[i] == 1 {
                var j = 2
                var prev = i - fib[j]
                while prev >= -1 {
                    // print("fib(\(j)) = \(fib[j]) & prev = \(prev)")
                    if prev == -1 {
                        dp[i] = 1
                        break
                    }
                    if dp[prev] != Int.max {
                        dp[i] = min(dp[i], dp[prev] + 1)
                    }
                    j += 1
                    prev = i - fib[j]
                }
            }
        }
        return dp[n] != Int.max ? dp[n] : -1
    }
}

// from -1 to N
// A represents leaves on the river
// 0 - without leaves, 1 with leaves
// find the min jumps -> frog can jump F(K) - Kth fibonacci number
// if cannot reach N returns -1

// A = [0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0]
// the frog can make three jumps of length F(5) = 5, F(3) = 2 and F(5) = 5
// the function should return 3

// Fibonacci numbers: 0, 1, 1, 2, 3, 5

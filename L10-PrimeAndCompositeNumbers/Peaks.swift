import Foundation
// result: https://app.codility.com/demo/results/trainingKFRSBA-HF7/
public class Peaks {
    public static func solution(_ A : inout [Int]) -> Int {
        let n = A.count
        if n < 3 { return 0 }
        // calculate pre-sum to count the number of peaks in a slice with constant time
        var ps = [Int](repeating: 0, count: n)
        for i in 1..<n-1 {
            ps[i] = ps[i-1]
            if A[i] > max(A[i-1], A[i+1]) {
                ps[i] += 1
            }
        }
        ps[n-1] = ps[n-2]
        if ps[n-1] == 0 { return 0 }
        var k = ps[n-1]
        while k > 1 {
            if n % k == 0 {
                let length = n / k
                var validBlocks = 0
                for i in 0..<k {
                    let first = i * length
                    let last = first + length - 1
                    if first == 0 && ps[last] > 0 ||  first > 0 && ps[last] > ps[first - 1] {
                        validBlocks += 1
                    } else {
                        break
                    }
                }
                if validBlocks == k {
                    return k
                }
            }
            k -= 1
        }
        return 1
    }
}

// If A cannot be divided into some number of blocks, the function should return 0

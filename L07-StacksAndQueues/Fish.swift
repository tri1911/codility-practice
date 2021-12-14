import Foundation
// result: https://app.codility.com/demo/results/trainingXBV6WS-UJ7/
public class Fish {
    public static func solution(_ A : inout [Int], _ B : inout [Int]) -> Int {
        let n = A.count
        if n == 1 { return 1 }
        var upstreamCount = 0
        // stack used to push downstream fishes
        var downstreamFishes = [Int]()
        var currentSize, currentDirection: Int
        for index in 0..<n {
            currentSize = A[index]
            currentDirection = B[index]
            if currentDirection == 0 {
                if downstreamFishes.isEmpty {
                    upstreamCount += 1
                } else {
                    while !downstreamFishes.isEmpty && currentSize > A[downstreamFishes.last!] {
                        downstreamFishes.removeLast()
                    }
                    if downstreamFishes.isEmpty {
                        upstreamCount += 1
                    }
                }
            } else {
                downstreamFishes.append(index)
            }
        }
        return upstreamCount + downstreamFishes.count
    }
}

// A[0] = 4    B[0] = 0
// A[1] = 3    B[1] = 1
// A[2] = 2    B[2] = 0
// A[3] = 1    B[3] = 0
// A[4] = 5    B[4] = 0
// return 2

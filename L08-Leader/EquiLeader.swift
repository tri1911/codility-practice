import Foundation
// result: https://app.codility.com/demo/results/trainingZQAN95-Y7N/
public class EquiLeader {
    public static func solution(_ A : inout [Int]) -> Int {
        let n = A.count
        if n < 2 { return 0 }
        var leftCounters = [Int:Int]()
        var rightCounters = [Int:Int]()
        for number in A[0..<n] {
            rightCounters[number] = (rightCounters[number] ?? 0) + 1
        }
        var equiLeader = A[0]
        var count = 0
        for i in 0..<n {
            let value = A[i]
            leftCounters[value] = (leftCounters[value] ?? 0) + 1
            rightCounters[value] = rightCounters[value]! - 1
            if i == 0 || leftCounters[value]! > leftCounters[equiLeader]! {
                equiLeader = value
            }
            if leftCounters[equiLeader]! > (i + 1) / 2 && rightCounters[equiLeader]! > (n - i - 1) / 2 {
                count += 1
            }
        }
        return count
    }
}

// For example, given array A such that:
// A[0] = 4
// A[1] = 3
// A[2] = 4
// A[3] = 4
// A[4] = 4
// A[5] = 2
// we can find two equi leaders:
// 0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.
// 2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.



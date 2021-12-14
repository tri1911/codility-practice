import Foundation
// result: https://app.codility.com/demo/results/trainingKGZ4KD-GRY/
public class Dominator {
    public static func solution(_ A : inout [Int]) -> Int {
        if A.isEmpty { return -1 }
        var current = 0, size = 1
        for i in 1..<A.count {
            if size == 0 {
                current = i
                size += 1
            } else {
                if A[i] != A[current] {
                    size -= 1
                } else {
                    size += 1
                }
            }
        }
        if size == 0 {
            return -1
        }
        var count = 0
        for number in A {
            if number == A[current] {
                count += 1
            }
        }
        return (count > A.count / 2) ? current : -1
    }
}

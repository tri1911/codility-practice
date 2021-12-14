import Foundation
// result: https://app.codility.com/demo/results/trainingMTQK7T-XHX/
public class Triangle {
    public static func solution(_ A : inout [Int]) -> Int {
        let N = A.count
        if N < 3 {
            return 0
        }
        A.sort()
        for index in 0..<N-2 {
            if A[index] > A[index + 2] - A[index + 1] {
                return 1
            }
        }
        return 0
    }
}

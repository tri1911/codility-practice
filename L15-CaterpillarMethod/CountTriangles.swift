import Foundation
// result: https://app.codility.com/demo/results/training3RK47G-WA4/
public class CountTriangles {
    public func solution(_ A : inout [Int]) -> Int {
        let n = A.count
        if n < 3 { return 0 }
        A.sort()
        var count = 0
        for i in 0..<n-2 {
            var k = i + 2
            for j in i+1..<n-1 {
                while k < n && A[i] + A[j] > A[k] {
                    k += 1
                }
                count += k - j - 1
            }
        }
        return count
    }
}

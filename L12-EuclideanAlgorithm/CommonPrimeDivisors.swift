import Foundation
// result: https://app.codility.com/demo/results/trainingU4VCVB-YX7/
public class CommonPrimeDivisors {
    public static func solution(_ A : inout [Int], _ B : inout [Int]) -> Int {
        var count = 0
        var a, b: Int
        for i in 0..<A.count {
            a = A[i]
            b = B[i]
            let n = gcd(a, b)
            if check(a / n, n) && check(b / n, n) {
                count += 1
            }
        }
        return count
    }
    
    private static func gcd(_ a: Int, _ b: Int) -> Int {
        if a % b == 0 {
            return b
        }
        return gcd(b, a % b)
    }
    
    private static func check(_ a: Int, _ b: Int) -> Bool {
        var a = a
        var c = gcd(a, b)
        while a != 1 {
            c = gcd(a, b)
            a /= c
            if c == 1 { return false }
        }
        return true
    }
}

import Foundation
// result: https://app.codility.com/demo/results/trainingSXYGJB-8G7/
public class CountNonDivisible {
    public func solution(_ A : inout [Int]) -> [Int] {
        let n = A.count
        if n == 1 { return [0] }
        var counter = [Int:Int]()
        for number in A {
            counter[number] = (counter[number] ?? 0) + 1
        }
        var answer = [Int]()
        for number in A {
            var a = 1
            // find divisors of A[i]
            var divisorCount = 0
            while a * a <= number {
                if number % a == 0 {
                    divisorCount += (counter[a] ?? 0) + (a * a != number ? counter[number / a] ?? 0 : 0)
                }
                a += 1
            }
            answer.append(n - divisorCount)
        }
        return answer
    }
}

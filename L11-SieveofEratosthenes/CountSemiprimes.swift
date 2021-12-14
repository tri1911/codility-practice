import Foundation
// result: https://app.codility.com/demo/results/trainingGEX92W-Y6S/
public class CountSemiprimes {
    public func solution(_ N : Int, _ P : inout [Int], _ Q : inout [Int]) -> [Int] {
        // determine prime numbers from 1 to N / 2 + 1
        var isPrime = [Bool](repeating: true, count: N / 2 + 2)
        isPrime[0] = false
        isPrime[1] = false
        var p = 2
        while p * p <= N / 2 + 1 {
            if isPrime[p] {
                for number in stride(from: p * p, to: N / 2 + 1, by: p) {
                    isPrime[number] = false
                }
            }
            p += 1
        }
        // compute pre-sum arrays for semi primes from 1 to N
        var ps = [Int](repeating: 0, count: N + 1)
        var number = 4
        // Notice: uses "for number in 4...N" will go out of bound index
        while number <= N {
            ps[number] = ps[number - 1]
            var a = 2
            while a * a <= number {
                if number % a == 0 && isPrime[a] && isPrime[number/a] {
                    ps[number] += 1
                    break
                }
                a += 1
            }
            number += 1
        }
        
        // iterate through P and Q to compute the number of semi primes in the desired range
        let m = P.count
        var result = [Int]()
        for i in 0..<m {
            result.append(ps[Q[i]] - ps[P[i] - 1])
        }
        return result
    }
}

// (1, [1], [1]) the solution terminated unexpectedly

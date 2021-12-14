import Foundation
// result: https://app.codility.com/demo/results/trainingPRUYBW-EZY/
public class ChocolatesByNumbers {
    public static func solution(_ N : Int, _ M : Int) -> Int {
        var a = N, b = M
        while a % b != 0 {
            let tmp = a
            a = b
            b = tmp % b
        }
        return (N * M) / (b * M) // I wrote that for showing the formula -> can write as N / b
    }
}

// N = 10, M = 4
// 0, 4, 8, 2, 6

// Proof by contradiction: if we stopped at another index other than 0 such as 4 or 8 or 2
// then the previous position we revisit is 0th index -> does not make sense!
// -> we stopped eating at 0th index -> Exist i, j such that i * N = j * M -> find the least common multiple by m*n = lcm(m,n) * gcd(m,n)


import Foundation
// result: https://app.codility.com/demo/results/trainingKMYSD9-2VX/
public class CountFactors {
    public func solution(_ N : Int) -> Int {
        var count = 0
        var first = 1
        while first * first <= N {
            if N % first == 0 {
                if first * first == N {
                    count += 1
                } else {
                    count += 2
                }
            }
            first += 1
        }
        return count
    }
}

// given N = 24, the function should return 8, because 24 has 8 factors, namely 1, 2, 3, 4, 6, 8, 12, 24

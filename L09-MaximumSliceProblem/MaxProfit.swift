import Foundation
// result: https://app.codility.com/demo/results/trainingFZVXXV-FA4/
public class MaxProfit {
    public static func solution(_ A : inout [Int]) -> Int {
        let n = A.count
        if n == 0 { return 0 }
        var currentMin = Int.max
        var maxProfit = 0
        for price in A {
            currentMin = min(currentMin, price)
            maxProfit = max(maxProfit, price - currentMin)
        }
        return maxProfit
    }
}

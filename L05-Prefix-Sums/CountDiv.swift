import Foundation
// result: https://app.codility.com/demo/results/trainingR2NGA3-SH6/
public class CountDiv {
    public static func solution(_ A : Int, _ B : Int, _ K : Int) -> Int {
        var minDivisor = Double(A) / Double(K)
        minDivisor.round(.up)
        print("minDivisor is \(minDivisor)")
        var maxDivisor = Double(B) / Double(K)
        maxDivisor.round(.down)
        print("maxDivisor is \(maxDivisor)")
        return Int(maxDivisor - minDivisor + 1)
    }
}

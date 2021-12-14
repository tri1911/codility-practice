import Foundation
// result: https://app.codility.com/demo/results/trainingQG2V7T-JAF/
public class Distinct {
    public static func solution(_ A : inout [Int]) -> Int {
        var set = Set<Int>()
        for number in A {
            set.insert(number)
        }
        return set.count
    }
}

import Foundation
// result: https://app.codility.com/demo/results/trainingRT3EFD-MMP/
public class AbsDistinct {
    public func solution(_ A : inout [Int]) -> Int {
        var set = Set<Int>()
       for value in A {
           set.insert(abs(value))
       }
       return set.count
    }
}

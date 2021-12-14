import Foundation
// result: https://app.codility.com/demo/results/training8Q46RH-SS9/
public class CountDistinctSlices {
    public func solution(_ M : Int, _ A : inout [Int]) -> Int {
        var count = 0
        var currentSlice = [Int:Int]()
        var start = 0, value: Int
        for end in 0..<A.count {
            value = A[end]
            if let index = currentSlice[value], index >= start {
                start = index + 1
            }
            currentSlice[value] = end
            count += end - start + 1
            if count > 1_000_000_000 { return 1_000_000_000 }
        }
        return count
    }
}

import Foundation
// result: https://app.codility.com/demo/results/trainingXE5BME-434/
public class TieRopes {
    public func solution(_ K : Int, _ A : inout [Int]) -> Int {
        var count = 0
        var current = 0
        for length in A {
            current += length
            if current >= K {
                count += 1
                current = 0
            }
        }
        return count
    }
}

import Foundation
// result: https://app.codility.com/demo/results/training52X4N8-YZE/
public class GenomicRangeQuery {
    public static func solution(_ S : inout String, _ P : inout [Int], _ Q : inout [Int]) -> [Int] {
        let N = S.count, M = P.count
        let characters = Array(S)
        // dictionary to map letter to impact factor integer
        let impactFactors: [Character: Int] = ["A": 1, "C": 2, "G": 3, "T": 4]
        
        // compute pre-sum arrays for each A, C, G, T
        var ps: [[Int]] = Array(repeating: Array(repeating: 0, count: N), count: 4)
        // time complexity: O(N) where N is the string length
        var index = 0
        for character in characters {
            if index != 0 {
                for row in 0..<4 {
                    ps[row][index] = ps[row][index - 1]
                }
            }
            if let impactFactor = impactFactors[character] {
                ps[impactFactor - 1][index] += 1
            }
            index += 1
        }
        
        var result = [Int](repeating: 0, count: M)
        // time complexity: O(M) where M is the P or Q's size
        for index in 0..<M {
            let first = P[index], last = Q[index]
            if first == last {
                result[index] = impactFactors[characters[first]]!
            } else {
                for row in 0..<4 {
                    if (first == 0 && ps[row][last] > 0) || (first > 0 && ps[row][last] > ps[row][first - 1]) {
                        result[index] = row + 1
                        break
                    }
                }
            }
        }
        return result
    }
}

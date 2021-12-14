import Foundation
// result: https://app.codility.com/demo/results/training4GVNNY-236/
public class BinaryGap {
    public static func solution(_ N : Int) -> Int {
        let asBinaryString = String(N, radix: 2)
        var lastOne = -1, i = 0, result = 0
        for digit in asBinaryString {
            if digit == "1" {
                result = max(result, i - lastOne - 1)
                lastOne = i
            }
            i += 1
        }
        return result
    }
}

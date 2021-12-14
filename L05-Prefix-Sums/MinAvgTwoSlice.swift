import Foundation
// result: https://app.codility.com/demo/results/trainingK6EDST-PZ2/
public class MinAvgTwoSlice {
    public static func solution(_ A : inout [Int]) -> Int {
        let N = A.count
        
        if N == 2 {
            return 0
        }
        
        var min2 = A[0] + A[1]
        var start2 = 0
        var current2 = A[1] + A[2]
        if current2 < min2 {
            min2 = A[1] + A[2]
            start2 = 1
        }
        
        var current3 = A[0] + A[1] + A[2]
        var min3 = current3
        var start3 = 0
        
        for index in 3..<N {
            current2 = current2 - A[index - 2] + A[index]
            if current2 < min2 {
                min2 = current2
                start2 = index - 1
            }
            
            current3 = current3 - A[index - 3] + A[index]
            if current3 < min3 {
                min3 = current3
                start3 = index - 2
            }
        }
        
        let average2 = Double(min2) / 2
        let average3 = Double(min3) / 3
        
        return average2 == average3 ? min(start2, start3) : (average2 < average3 ? start2 : start3)
    }
}


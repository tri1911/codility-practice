import Foundation
// result: https://app.codility.com/demo/results/trainingJUC9P8-QMW/
public class MinPerimeterRectangle {
    public func solution(_ N : Int) -> Int {
        // find all possible pairs of side length, then update the global min
        var minPerimeter = Int.max
        var a, b: Int
        a = 1
        while a * a <= N {
            if N % a == 0 {
                b = N / a
                minPerimeter = min(minPerimeter, (a + b) * 2)
            }
            a += 1
        }
        return minPerimeter
    }
}

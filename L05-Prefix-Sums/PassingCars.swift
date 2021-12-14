import Foundation
// Notice: return −1 if answer > 1,000,000,000
// result: https://app.codility.com/demo/results/training2ZQCXX-KGY/
public class PassingCars {
    public static func solution(_ A : inout [Int]) -> Int {
        var passingCars = 0
        var eastCars = 0
        for number in A {
            if (number == 0) {
                eastCars += 1
            } else {
                passingCars += eastCars
                if (passingCars > 1000_000_000) {
                    return -1
                }
            }
        }
        return passingCars
    }
}



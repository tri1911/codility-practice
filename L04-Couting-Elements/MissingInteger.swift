// result: https://app.codility.com/demo/results/training4CRN4E-SHK/
public class MissingInteger {
    public static func solution(_ A : inout [Int]) -> Int {
        var set = Set<Int>()
        for number in A {
            if (number > 0) {
                set.insert(number)
            }
        }
        var missingInt = 1
        while set.contains(missingInt) {
            missingInt += 1
        }
        return missingInt
    }
}

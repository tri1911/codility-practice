// result: https://app.codility.com/demo/results/trainingV2WSSX-T67/
public class PermCheck {
    public static func solution(_ A : inout [Int]) -> Int {
        let N = A.count
        var set = Set<Int>()
        for number in A {
            if (number >= 1 && number <= N) {
                set.insert(number)
            }
        }
        return set.count == N ? 1 : 0
    }
}

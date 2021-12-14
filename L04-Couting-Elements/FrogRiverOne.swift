// result: https://app.codility.com/demo/results/trainingN5MT7V-P6N/
// return -1 otherwise
public class FrogRiverOne {
    public static func solution(_ X : Int, _ A : inout [Int]) -> Int {
        var set = Set<Int>()
        for second in 0..<A.count {
            set.insert(A[second])
            if set.count == X {
                return second
            }
        }
        return -1
    }
}

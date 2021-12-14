// result: https://app.codility.com/demo/results/trainingBK2ZBK-ZCB/
public class MaxCounters {
    public static func solution(_ N : Int, _ A : inout [Int]) -> [Int] {
        var counters = [Int](repeating: 0, count: N)
        var currentMax = 0
        var maxToUpdate = 0
        for operation in A {
            // update all counter to the current max
            if (operation == N + 1) {
                maxToUpdate = currentMax
            } else {
                counters[operation - 1] = max(counters[operation - 1], maxToUpdate) + 1
                // update the current max
                currentMax = max(currentMax, counters[operation - 1])
            }
        }
        for index in 0..<N {
            counters[index] = max(counters[index], maxToUpdate)
        }
        return counters
    }
}



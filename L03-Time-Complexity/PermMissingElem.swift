// result: https://app.codility.com/demo/results/trainingXTABS6-NWG/
public class PermMissingElem {
    public static func solution(_ A : inout [Int]) -> Int {
        var set = Set<Int>()
        for number in A {
            set.insert(number)
        }
        var answer = 1
        while set.contains(answer) {
            answer += 1
        }
        return answer
    }
}

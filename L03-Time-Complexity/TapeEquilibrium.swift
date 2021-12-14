// Notice: 0 < P < N => each part has at least 1 element
// result: https://app.codility.com/demo/results/trainingDZWSW3-6BC/
public class TapeEquilibrium {
    public static func solution(_ A : inout [Int]) -> Int {
        var leftSum = A[0], rightSum = A[1..<A.count].reduce(0, +)
        // print("initial value of leftSum is \(leftSum)")
        // print("initial value of rightSum is \(rightSum)")
        var answer = abs(leftSum - rightSum)
        // print("initial value of answer is \(answer)")
        for number in A[1..<A.count - 1] {
            leftSum += number
            // print("leftSum is updated to \(leftSum)")
            rightSum -= number
            // print("rightSum is updated to \(rightSum)")
            answer = min(answer, abs(leftSum - rightSum))
        }
        return answer
    }
}

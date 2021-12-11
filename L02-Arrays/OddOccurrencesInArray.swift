// result: https://app.codility.com/demo/results/trainingGY2WXD-282/

public func solution(_ A : inout [Int]) -> Int {
    var ans = A[0]
    for number in A[1...] {
        ans ^= number
    }
    return ans
}
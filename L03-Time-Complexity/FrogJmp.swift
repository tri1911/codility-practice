// Input: X = 10, Y = 85, D = 30
// Output: 3

// result: https://app.codility.com/demo/results/trainingY8JU2H-WKM/

public func solution(_ X : Int, _ Y : Int, _ D : Int) -> Int {
    var ans = Double(Y - X) / Double(D)
    ans.round(.up)
    return Int(ans)
}

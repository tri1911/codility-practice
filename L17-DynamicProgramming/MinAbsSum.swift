import Foundation
// result: https://app.codility.com/demo/results/trainingHXS3UT-X8W/
public class MinAbsSum {
    public func solution(_ A : inout [Int]) -> Int {
        A = A.map(abs);
        let sum = A.reduce(0, +);
        
        var counter = [Int:Int]()
        for number in A {
            counter[number] = (counter[number] ?? 0) + 1;
        }
        
        var dp = [Int](repeating: -1, count: sum + 1);
        dp[0] = 0;
        
        for (number, count) in counter {
            for i in 0...sum {
                if dp[i] >= 0 {
                    dp[i] = count;
                } else if i >= number && dp[i - number] > 0 {
                    dp[i] = dp[i - number] - 1;
                }
            }
        }
        var s = sum / 2;
        while (dp[s] < 0) {
            s -= 1;
        }
        return ((sum - s) - s);
    }
}

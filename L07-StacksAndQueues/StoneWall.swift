import Foundation
// result: https://app.codility.com/demo/results/trainingWPWFGB-KQH/
public class StoneWall {
    public static func solution(_ H : inout [Int]) -> Int {
        var total = 0
        var stack = [Int]()
        for height in H {
            while !stack.isEmpty && height < stack.last! {
                total += 1
                stack.removeLast()
            }
            if stack.isEmpty || height != stack.last! {
                stack.append(height)
            }
        }
        return total + stack.count
    }
}

// For example, given array H containing N = 9 integers:
// H[0] = 8    H[1] = 8    H[2] = 5
// H[3] = 7    H[4] = 9    H[5] = 8
// H[6] = 7    H[7] = 4    H[8] = 8
// -> return 7

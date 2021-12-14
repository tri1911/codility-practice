import Foundation
// result: https://app.codility.com/demo/results/trainingBDR4MK-9AV/
public class Nesting {
    public static func solution(_ S : inout String) -> Int {
        var stack = [Character]()
        for character in S {
            switch character {
            case "(":
                stack.append(")")
            default:
                if !stack.isEmpty, stack.last! == character {
                    stack.removeLast()
                    continue
                }
                return 0
            }
        }
        return stack.isEmpty ? 1 : 0
    }
}

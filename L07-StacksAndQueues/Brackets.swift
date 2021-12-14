import Foundation
// result: https://app.codility.com/demo/results/trainingSQGNBM-4AC/
public class Brackets {
    public static func solution(_ S : inout String) -> Int {
        var stack = [Character]()
        for character in S {
            if character == "{" {
                stack.append("}")
            } else if character == "(" {
                stack.append(")")
            } else if character == "[" {
                stack.append("]")
            } else {
                if stack.isEmpty {
                    return 0
                }
                if let top = stack.popLast(), top != character {
                    return 0
                }
            }
        }
        return stack.isEmpty ? 1 : 0
    }
}

// reference
// https://stackoverflow.com/questions/25921204/convert-swift-string-to-array/25921323

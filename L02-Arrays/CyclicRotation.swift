import Foundation
import Glibc

// Input: A = [3, 8, 9, 7, 6] and K = 3
// Output: [9, 7, 6, 3, 8]

// result: https://app.codility.com/demo/results/training9DM5NA-BCE/

func reverse(_ arr: inout [Int], first: Int, last: Int) {
	var first = first, last = last
	while (first < last) {
		let tmp = arr[first]
		arr[first] = arr[last]
		arr[last] = tmp
		first += 1
		last -= 1
	}
}

public func solution(_ A : inout [Int], _ K : Int) -> [Int] {
	let N = A.count
	if N == 0 { return [] }
	let K = K % N
    reverse(&A, first: 0, last: N - 1)
    reverse(&A, first: 0, last: K - 1)
    reverse(&A, first: K, last: N - 1)
    return A
}

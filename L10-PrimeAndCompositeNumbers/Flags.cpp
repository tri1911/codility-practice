// Date: Nov 29, 2021 => Redo: Dec 6, 2021
// Flags

// Peak: 0 < P < N − 1 and A[P − 1] < A[P] > A[P + 1]
// Flags can only be set on peaks. 
// if take K flags, flags' distance >= K
// The distance between indices P and Q is the absolute value |P − Q|

// Input: A = [1,5,3,4,3,4,1,2,3,4,6,2] (N = 12)
// 4 peaks: elements 1, 3, 5 and 10
// two flags, on peaks 1 and 5
// three flags, on peaks 1, 5 and 10
// four flags, impossible
// => return 3

// N = [1..400,000]
// A[i] = [0..1,000,000,000]

// detected time complexity: O(n) (actually ~ O(n*sqrt(n)))
// space complexity: O(n)
// result: https://app.codility.com/demo/results/trainingXP99JW-7EG/
int solution(vector<int> &A) {
	int N = A.size();
	vector<int> peaks;
	for (int i = 1; i < N - 1; i++) {
		if (A[i] > max(A[i-1], A[i+1])) {
			peaks.push_back(i);
		}
	}

	for (int num: peaks)
		cout << num << " ";
	cout << endl;

	if (peaks.size() == 0)
		return 0;

	int ans = 1;
	for (int flags = 2; flags * (flags - 1) <= N; flags++) {
		int setFlags = 1;
		int current = peaks[0];
		int minNext = current + flags;
		for (int i = 1; minNext < N && i < (int) peaks.size(); i++) {
			if (peaks[i] >= minNext) {
				if (++setFlags == flags) {
					ans = flags;
				}
				current = peaks[i];
				minNext = current + flags;
			}
		}
	}
	return ans;
}

// reference
// https://github.com/Behrouz-m/Codility/blob/master/10-PrimeAndCompositeNumbers/Flags.cpp

// solution 2 (bugged)
// time complexity: O(nlogn)
// space complexity: O(n)

bool setFlags(vector<int>& peaks, int flags) {
	int indexToSet = peaks[0] + flags;
	int flagsToSet = flags - 1;
	for (int i = 1; i < (int) peaks.size() && flagsToSet > 0; i++) {
		if (peaks[i] >= indexToSet) {
			indexToSet = peaks[i] + flags;
			flagsToSet--;
		}
	}
	return (flagsToSet == 0);
}

int solution(vector<int>& arr) {
	vector<int> peaks;
	for (int i = 1; i < (int) arr.size() - 1; i++) {
		if (arr[i-1] < arr[i] && arr[i] > arr[i+1]) {
			peaks.push_back(i);
		}
	}
	int left = 1, right = peaks.size();
	int ans = 1;
	while (left <= right) {
		ans = (left + right) / 2;
		if (setFlags(peaks, ans)) {
			left = ans + 1;
		} else {
			return ans - 1;	
		}
	}
	return 1;
}
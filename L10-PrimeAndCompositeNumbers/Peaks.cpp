// Date: Nov 29, 2021
// Peaks

// 81% (need to fix)
int solution(vector<int> &A) {
	int n = A.size();

	if (n < 3) 
		return 0;

	vector<int> peaks(n);
	for (int i = 1; i < n - 1; i++) {
		peaks[i] = peaks[i-1];
		if (A[i] > A[i - 1] && A[i] > A[i + 1]) 
			peaks[i]++;
	}
	peaks[n - 1] = peaks[n - 2];

	// for (int num: peaks) {
	// 	cout << num << " ";
	// }
	// cout << endl;

	if (peaks[n - 1] == 0) 
		return 0;

	for (int sliceCount = peaks[n - 1]; sliceCount >= 2; sliceCount--) {
		// cout << "sliceCount: " << sliceCount << endl;
		if (n % sliceCount == 0) {
			int sliceLength = n / sliceCount;
			int i = 0;
			for (; i < sliceCount; i++) {
				int first = i * sliceLength;
				int last = (first + sliceLength) - 1;
				// cout << "first: " << first << "; last: " << last << endl;
				// cout << "peaks[last] - peaks[first]: " << peaks[last] - peaks[first] << endl;
				if (peaks[last] - peaks[first] < 1)
					break;
			}
			if (i == sliceCount)
				return sliceCount; 
		}
	}

	return 1;
}
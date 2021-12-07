// Date: Nov 28, 2021

#include <iostream>
#include <map>

using namespace std;

int solution(vector<int> &A) {
    map<int, int> right;
    map<int, int> left;

    for (int num: A) {
        right[num]++;
    }
    int ans = 0;
    int leader = A[0];
    for (int i = 0; i < A.size(); i++) {
        right[A[i]]--;
        left[A[i]]++;
        if (left[A[i]] > left[leader])
            leader = A[i];
        if (left[leader] > (i + 1) / 2 && right[leader] > (A.size() - i - 1) / 2)
            ans++;
    }
    return ans;
}
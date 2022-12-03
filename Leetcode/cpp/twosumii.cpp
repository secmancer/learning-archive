#include <vector>
#include <iostream>

using namespace std;

vector<int> twoSum(vector<int>& numbers, int target) {
        int l = 0;
        int r = numbers.size() - 1;
        
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            
            if (sum > target) {
                r -= 1;
            } else if (sum < target) {
                l += 1;
            } else {
                return {l + 1, r + 1};
            }
        }
        return {};
}

int main() {
    
    vector<int> nums1 = {2, 7, 11, 15};
    vector<int> result1 = twoSum(nums1, 9);
    cout << result1[0] << " " << result1[1] << endl;

    vector<int> nums2 = {2, 3, 4};
    vector<int> result2 = twoSum(nums2, 6);
    cout << result2[0] << " " << result2[1] << endl;

    vector<int> nums3 = {-1, 0};
    vector<int> result3 = twoSum(nums3, -1);
    cout << result3[0] << " " << result3[1] << endl;

}
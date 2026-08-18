class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        int[] count = new int[51]; 
        
        for (int num : nums) {
            count[num]++;
        }
        
        if (k == n) {
            int max = -1;
            for (int num : nums) {
                max = Math.max(max, num);
            }
            return max;
        }
        
        if (k == 1) {
            int max = -1;
            for (int i = 0; i <= 50; i++) {
                if (count[i] == 1) {
                    max = Math.max(max, i);
                }
            }
            return max;
        }
        
        int ans = -1;
        if (count[nums[0]] == 1) {
            ans = Math.max(ans, nums[0]);
        }
        if (count[nums[n - 1]] == 1) {
            ans = Math.max(ans, nums[n - 1]);
        }
        
        return ans;
    }
}
class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        
        // Step 1: Precompute prefix maximums
        int[] prefMax = new int[n];
        prefMax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefMax[i] = Math.max(prefMax[i - 1], nums[i]);
        }
        
        // Step 2: Precompute suffix minimums
        int[] suffMin = new int[n];
        suffMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffMin[i] = Math.min(suffMin[i + 1], nums[i]);
        }
        
        // Step 3: Find the first index with instability score <= k
        for (int i = 0; i < n; i++) {
            if (prefMax[i] - suffMin[i] <= k) {
                return i;
            }
        }
        
        return -1;
    }
}
class Solution {
    public int longestSubsequence(int[] nums) {
        int xorval = 0;
        boolean hasNonZero = false;
        
        for (int i = 0; i < nums.length; i++) {
            xorval ^= nums[i];
            if (nums[i] != 0) {
                hasNonZero = true; 
            }
        }
        if (xorval != 0) {
            return nums.length;
        }
        
        if (hasNonZero) {
            return nums.length - 1;
        }
        return 0;
    }
}
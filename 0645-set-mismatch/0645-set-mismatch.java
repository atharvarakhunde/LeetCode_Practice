class Solution {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int dup = -1;
        int missing = 1; 
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                dup = nums[i]; 
            } else if (nums[i] > nums[i - 1] + 1) {
                missing = nums[i - 1] + 1; 
            }
        }
        if (nums[nums.length - 1] != nums.length) {
            missing = nums.length;
        }
        
        return new int[]{dup, missing};
    }
}
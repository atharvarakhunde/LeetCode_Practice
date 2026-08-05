class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length-1;
        return nums[n-k+1] ;
    }
}
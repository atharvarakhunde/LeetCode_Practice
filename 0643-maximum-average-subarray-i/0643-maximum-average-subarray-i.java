class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0 ;
        int max;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        max=sum;
        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i];
            max = Math.max(max,sum);
        }
    
        return (double) max / k;
    }
}
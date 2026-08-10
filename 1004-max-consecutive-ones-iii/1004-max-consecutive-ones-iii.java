class Solution {
    public int longestOnes(int[] nums, int k) {
        int count = 0 ; 
        int zerocount = 0 ;
        int left =0;
        int right =0 ;

       while (right < nums.length) {
            if (nums[right] == 0) {
                zerocount++;
            }

            if(zerocount > k) {
                if (nums[left] == 0) {
                    zerocount--;
                }
                left++;
            }
            count = Math.max(count, right - left + 1);
            right++;
        }
        return count;
    }
}
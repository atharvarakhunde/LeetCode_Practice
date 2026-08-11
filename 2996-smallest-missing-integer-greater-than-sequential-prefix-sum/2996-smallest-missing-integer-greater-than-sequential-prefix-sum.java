class Solution {
    public int missingInteger(int[] nums) {
        int left = 0 ; 
        int right = 0;
        int sum = 0 ;

        while (right < nums.length - 1 && nums[right + 1] == nums[right] + 1) {
            right++;
        }

        for (int i = 0; i <= right; i++) {
            sum += nums[i];
        }
 
        while (true) {
            boolean exists = false;
            for (int num : nums) {
                if (num == sum) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                break;
            }
            sum++;
        }


        return sum;
    }
}
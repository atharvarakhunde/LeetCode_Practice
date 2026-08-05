class Solution {
    public int findPeakElement(int[] nums) {
        int num = nums[0];
        int index = 0 ;
        for(int i=1; i<nums.length; i++){
            if(num < nums[i]){
                num = nums[i];
                index = i;
            }
        }
        return index;
    }
}
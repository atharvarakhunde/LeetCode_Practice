class Solution {
    public int dominantIndex(int[] nums) {
        int max = Integer.MIN_VALUE;
       int ind = -1;
        for(int i = 0 ; i< nums.length ; i++){
            max = Math.max(max,nums[i]);

        }
        for(int i = 0 ; i<nums.length ; i++){
            int val = nums[i] *2;
            if(nums[i]==max){
                ind = i;
                continue;
            }
            if(!(val<=max)){
                return -1;
            }
        }
        return ind;
    }
}
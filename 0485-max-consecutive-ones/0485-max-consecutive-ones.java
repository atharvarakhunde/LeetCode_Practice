class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxcount = 0  ; 
        int currentcount=0 ;
        for(int i =0 ; i< nums.length ; i++){
            if(nums[i]== 1){
                currentcount ++;
            }
            else {
                maxcount = Math.max(maxcount,currentcount);
                currentcount = 0;
            }
        }
        return Math.max(maxcount,currentcount);
    }
}
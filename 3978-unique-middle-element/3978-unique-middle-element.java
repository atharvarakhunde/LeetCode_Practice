class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        int index =  nums.length/2 ;
        int mid = nums[index];

        for(int i =0 ; i< nums.length ; i++){
            if(i==index){
                continue;
            }
            if(nums[i] ==mid){
                return false;
            }
        }
        return true ;
    }
}
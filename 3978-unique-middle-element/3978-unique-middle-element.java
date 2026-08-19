class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        int index =  nums.length/2 ;
        int mid = nums[index];
        for(int i =0 ; i< nums.length ; i++){
            if(nums[i] ==mid && i!= index){
                return false;
            }
        }
        return true ;
    }
}
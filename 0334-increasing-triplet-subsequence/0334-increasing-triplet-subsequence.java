class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        if (nums == null || nums.length < 3) {
            return false;
        }

        for(int num : nums){
            if(num <= first){
                first = num;
            }else if (num <=second){
                second = num;
            }else{
                return true ;
            }
        }

        return false;
    }
}
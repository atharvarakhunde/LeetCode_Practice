class Solution {
    public int[] getConcatenation(int[] nums) {
        int [] num1 = new int[nums.length * 2] ;
        for(int i = 0 ; i< nums.length *2 ; i++){
            int mod = i%nums.length ;
            num1[i] = nums[mod];
        }
        return num1;
    }
}
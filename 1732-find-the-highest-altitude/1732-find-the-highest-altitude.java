class Solution {
    public int largestAltitude(int[] gain) {
        int high = 0 ;
        int temp =0;
        for(int i =0 ; i< gain.length ; i++){
            temp += gain[i];
            high = Math.max(temp,high);
        }
        return high;
    }
}
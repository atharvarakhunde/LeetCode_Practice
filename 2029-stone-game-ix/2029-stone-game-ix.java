class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] count = new int[3];
        
        // Count frequencies of remainders when divided by 3
        for (int stone : stones) {
            count[stone % 3]++;
        }
        
        // If the number of stones with remainder 0 is even
        if (count[0] % 2 == 0) {
            // Alice wins if there is at least one stone of remainder 1 and one of remainder 2
            return count[1] > 0 && count[2] > 0;
        } else {
            // If the number of stones with remainder 0 is odd
            // Alice wins if the absolute difference between count of 1s and 2s is greater than 2
            return Math.abs(count[1] - count[2]) > 2;
        }
    }
}
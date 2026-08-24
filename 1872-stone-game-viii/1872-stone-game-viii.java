class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        
        // Compute prefix sums
        int[] prefixSum = new int[n];
        prefixSum[0] = stones[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + stones[i];
        }
        
        // Base case: if the last player takes all remaining stones (x = n)
        int maxScoreDiff = prefixSum[n - 1];
        
        // Iterate backwards from index n - 2 down to 1
        // maxScoreDiff tracks max(prefixSum[i] - maxScoreDiff, previous_maxScoreDiff)
        for (int i = n - 2; i >= 1; i--) {
            maxScoreDiff = Math.max(maxScoreDiff, prefixSum[i] - maxScoreDiff);
        }
        
        return maxScoreDiff;
    }
}
class Solution {
    int[][] memo;
    int[] prefixSum;

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        memo = new int[n][n];
        prefixSum = new int[n + 1];
        
        // Calculate prefix sums for O(1) subarray sum queries
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + stoneValue[i];
        }
        
        return solve(stoneValue, 0, n - 1);
    }

    private int solve(int[] stoneValue, int left, int right) {
        // Base case: only one stone left, score is 0
        if (left == right) {
            return 0;
        }
        
        // Return precalculated result if available
        if (memo[left][right] != 0) {
            return memo[left][right];
        }
        
        int maxScore = 0;
        
        // Try every possible partition point in the current subarray
        for (int i = left; i < right; i++) {
            int leftSum = prefixSum[i + 1] - prefixSum[left];
            int rightSum = prefixSum[right + 1] - prefixSum[i + 1];
            
            if (leftSum < rightSum) {
                // Bob throws away the right row
                maxScore = Math.max(maxScore, leftSum + solve(stoneValue, left, i));
            } else if (leftSum > rightSum) {
                // Bob throws away the left row
                maxScore = Math.max(maxScore, rightSum + solve(stoneValue, i + 1, right));
            } else {
                // Sums are equal, Alice decides which row to throw away to maximize score
                maxScore = Math.max(maxScore, leftSum + Math.max(
                    solve(stoneValue, left, i), 
                    solve(stoneValue, i + 1, right)
                ));
            }
        }
        
        // Memoize and return
        memo[left][right] = maxScore;
        return maxScore;
    }
}
class Solution {

    Integer[] dp;

    public String stoneGameIII(int[] stoneValue) {

        int n = stoneValue.length;
        dp = new Integer[n];

        int diff = solve(0, stoneValue);

        if (diff > 0)
            return "Alice";
        else if (diff < 0)
            return "Bob";
        else
            return "Tie";
    }

    private int solve(int i, int[] stoneValue) {

        if (i >= stoneValue.length)
            return 0;

        if (dp[i] != null)
            return dp[i];

        int take = 0;
        int best = Integer.MIN_VALUE;

        for (int k = 0; k < 3 && i + k < stoneValue.length; k++) {

            take += stoneValue[i + k];

            best = Math.max(best, take - solve(i + k + 1, stoneValue));
        }

        return dp[i] = best;
    }
}
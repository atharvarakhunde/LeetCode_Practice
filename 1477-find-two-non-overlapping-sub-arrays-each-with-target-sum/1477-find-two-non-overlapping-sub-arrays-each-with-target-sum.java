class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        // dp[i] will store the minimum length of a target subarray found in arr[0...i-1]
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE / 2); // Avoid overflow when adding lengths

        int left = 0;
        int sum = 0;
        int minSumLengths = Integer.MAX_VALUE / 2;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            // Shrink window if sum exceeds target
            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            // Copy best length from previous position
            dp[right + 1] = dp[right];

            // Valid subarray found
            if (sum == target) {
                int currLen = right - left + 1;

                // Check if we already have a valid non-overlapping subarray before 'left'
                if (dp[left] != Integer.MAX_VALUE / 2) {
                    minSumLengths = Math.min(minSumLengths, currLen + dp[left]);
                }

                // Update the minimum length subarray ending at or before 'right + 1'
                dp[right + 1] = Math.min(dp[right + 1], currLen);
            }
        }

        return minSumLengths >= Integer.MAX_VALUE / 2 ? -1 : minSumLengths;
    }
}
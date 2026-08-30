class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if (n <= 2) return n;

        int minIdx = 0;
        int maxIdx = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[minIdx]) minIdx = i;
            if (nums[i] > nums[maxIdx]) maxIdx = i;
        }

        int i = Math.min(minIdx, maxIdx);
        int j = Math.max(minIdx, maxIdx);

        // Scenario 1: Remove both from front
        int frontOnly = j + 1;

        // Scenario 2: Remove both from back
        int backOnly = n - i;

        // Scenario 3: Remove one from front, one from back
        int bothEnds = (i + 1) + (n - j);

        return Math.min(frontOnly, Math.min(backOnly, bothEnds));
    }
}
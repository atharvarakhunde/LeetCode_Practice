class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        // Size n + 1 prevents out-of-bounds access when checking right_match[w1_idx + 1]
        int[] right_match = new int[n + 1];
        
        // Initialize base case for index n
        right_match[n] = m;
        
        int j = m - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                j--;
            }
            right_match[i] = j + 1; // First unmatched index in word2 for suffix starting at i
        }
        
        int[] ans = new int[m];
        int w1_idx = 0;
        int w2_idx = 0;
        boolean used_change = false;
        
        while (w1_idx < n && w2_idx < m) {
            if (word1.charAt(w1_idx) == word2.charAt(w2_idx)) {
                ans[w2_idx++] = w1_idx++;
            } else if (!used_change && right_match[w1_idx + 1] <= w2_idx + 1) {
                // Use the single allowed change here
                ans[w2_idx++] = w1_idx++;
                used_change = true;
            } else {
                w1_idx++;
            }
        }
        
        if (w2_idx == m) {
            return ans;
        }
        
        return new int[0];
    }
}
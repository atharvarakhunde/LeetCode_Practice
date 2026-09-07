class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        // end[i] stores total distinct subsequences ending with character ('a' + i)
        long[] end = new long[26];

        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            
            // Calculate total subsequences formed before adding char 'c'
            long sum = 0;
            for (int i = 0; i < 26; i++) {
                sum = (sum + end[i]) % MOD;
            }

            // New count ending with 'c' is (all existing subsequences + 1 for 'c' itself)
            end[idx] = (sum + 1) % MOD;
        }

        // Sum up distinct subsequences ending with all 26 characters
        long total = 0;
        for (long count : end) {
            total = (total + count) % MOD;
        }

        return (int) total;
    }
}
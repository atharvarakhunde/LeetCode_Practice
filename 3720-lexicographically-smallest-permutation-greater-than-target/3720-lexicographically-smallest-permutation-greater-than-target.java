class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // Phase 1: Match target as long as possible
        int[] matchedCounts = count.clone();
        int matchedLen = 0;
        
        for (int i = 0; i < n; i++) {
            int chIdx = target.charAt(i) - 'a';
            if (matchedCounts[chIdx] > 0) {
                matchedCounts[chIdx]--;
                matchedLen++;
            } else {
                break;
            }
        }

        // Phase 2: Backtrack from longest match down to index 0 to find the rightmost valid pivot
        for (int i = matchedLen; i >= 0; i--) {
            int[] currentCount = count.clone();
            StringBuilder sb = new StringBuilder();
            
            // Rebuild exact prefix of length i
            for (int k = 0; k < i; k++) {
                sb.append(target.charAt(k));
                currentCount[target.charAt(k) - 'a']--;
            }

            if (i < n) {
                int targetChar = target.charAt(i) - 'a';
                // Try to find the smallest available character strictly greater than target[i]
                for (int c = targetChar + 1; c < 26; c++) {
                    if (currentCount[c] > 0) {
                        sb.append((char) ('a' + c));
                        currentCount[c]--;

                        // Fill all remaining characters in ascending (smallest first) order
                        for (int r = 0; r < 26; r++) {
                            while (currentCount[r] > 0) {
                                sb.append((char) ('a' + r));
                                currentCount[r]--;
                            }
                        }
                        return sb.toString();
                    }
                }
            }
        }

        return "";
    }
}
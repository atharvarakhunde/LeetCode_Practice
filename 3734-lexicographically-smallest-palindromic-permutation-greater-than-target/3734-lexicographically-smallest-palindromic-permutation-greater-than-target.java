import java.util.*;

class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        int oddCount = 0;
        char midChar = 0;
        int[] halfCnt = new int[26];

        for (int i = 0; i < 26; i++) {
            if (cnt[i] % 2 != 0) {
                oddCount++;
                midChar = (char) ('a' + i);
            }
            halfCnt[i] = cnt[i] / 2;
        }

        if (oddCount > 1) {
            return "";
        }

        int halfLen = n / 2;

        // 1. Try matching the exact prefix of target's half as closely as possible
        // Find the lexicographically smallest valid palindrome >= target
        String res = solve(0, new char[halfLen], halfCnt, midChar, target, n, s);
        return res;
    }

    private String solve(int idx, char[] half, int[] free, char midChar, String target, int n, String s) {
        // Construct smallest possible palindrome
        String smallest = getSmallestPalindrome(free, midChar, n);
        
        // Try building left half matching target prefix up to prefix length
        for (int prefixLen = halfLen(n); prefixLen >= 0; prefixLen--) {
            // Check if target[0...prefixLen-1] can be formed using free characters
            int[] tempCnt = free.clone();
            boolean possible = true;
            char[] currentHalf = new char[halfLen(n)];

            for (int i = 0; i < prefixLen; i++) {
                char t = target.charAt(i);
                if (tempCnt[t - 'a'] > 0) {
                    currentHalf[i] = t;
                    tempCnt[t - 'a']--;
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) continue;

            // Try picking a strictly larger character at index prefixLen
            int startChar = (prefixLen < halfLen(n)) ? (target.charAt(prefixLen) - 'a' + 1) : 26;
            
            // If prefixLen == halfLen(n), we match full half, check if middle or right half can be larger
            if (prefixLen == halfLen(n)) {
                String pal = buildFullPalindrome(currentHalf, midChar, n);
                if (pal.compareTo(target) > 0) {
                    return pal;
                }
                continue;
            }

            for (int c = startChar; c < 26; c++) {
                if (tempCnt[c] > 0) {
                    currentHalf[prefixLen] = (char) ('a' + c);
                    tempCnt[c]--;

                    // Fill remainder of half greedily with smallest available
                    int fillIdx = prefixLen + 1;
                    for (int ch = 0; ch < 26; ch++) {
                        while (tempCnt[ch] > 0) {
                            currentHalf[fillIdx++] = (char) ('a' + ch);
                            tempCnt[ch]--;
                        }
                    }

                    String pal = buildFullPalindrome(currentHalf, midChar, n);
                    if (pal.compareTo(target) > 0) {
                        return pal;
                    }
                    break; // Picked smallest valid character > target[prefixLen]
                }
            }
        }

        return "";
    }

    private int halfLen(int n) {
        return n / 2;
    }

    private String getSmallestPalindrome(int[] free, char midChar, int n) {
        int hLen = n / 2;
        char[] half = new char[hLen];
        int idx = 0;
        for (int i = 0; i < 26; i++) {
            for (int k = 0; k < free[i]; k++) {
                half[idx++] = (char) ('a' + i);
            }
        }
        return buildFullPalindrome(half, midChar, n);
    }

    private String buildFullPalindrome(char[] half, char midChar, int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(half);
        if (n % 2 != 0) {
            sb.append(midChar);
        }
        for (int i = half.length - 1; i >= 0; i--) {
            sb.append(half[i]);
        }
        return sb.toString();
    }
}
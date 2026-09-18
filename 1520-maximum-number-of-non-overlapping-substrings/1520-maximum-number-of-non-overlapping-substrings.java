import java.util.*;

class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);

        // Step 1: Record first and last occurrence of each character
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (first[c] == -1) {
                first[c] = i;
            }
            last[c] = i;
        }

        List<int[]> validIntervals = new ArrayList<>();

        // Step 2: Try to form valid substring intervals starting at each character's first occurrence
        for (int i = 0; i < 26; i++) {
            if (first[i] == -1) continue;

            int start = first[i];
            int end = last[i];
            boolean isValid = true;

            for (int j = start; j <= end; j++) {
                int c = s.charAt(j) - 'a';
                // If a character inside starts before our current start, this start point is invalid
                if (first[c] < start) {
                    isValid = false;
                    break;
                }
                // Expand the right bound if needed
                end = Math.max(end, last[c]);
            }

            if (isValid) {
                validIntervals.add(new int[]{start, end});
            }
        }

        // Step 3: Sort intervals by end index (Greedy Interval Scheduling)
        validIntervals.sort((a, b) -> Integer.compare(a[1], b[1]));

        List<String> result = new ArrayList<>();
        int prevEnd = -1;

        for (int[] interval : validIntervals) {
            int start = interval[0];
            int end = interval[1];

            // If non-overlapping, pick this substring
            if (start > prevEnd) {
                result.add(s.substring(start, end + 1));
                prevEnd = end;
            }
        }

        return result;
    }
}
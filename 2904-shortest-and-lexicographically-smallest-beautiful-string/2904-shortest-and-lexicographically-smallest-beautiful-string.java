class Solution {
   public String shortestBeautifulSubstring(String s, int k) {
    String ans = "";
    int left = 0, countOnes = 0;

    for (int right = 0; right < s.length(); right++) {
        if (s.charAt(right) == '1') {
            countOnes++;
        }

        while (countOnes == k) {
            String candidate = s.substring(left, right + 1);
            ans = checklarger(ans, candidate);

            if (s.charAt(left) == '1') {
                countOnes--;
            }
            left++;
        }
    }

    return ans;
}
    public String checklarger(String result , String window){
        if(result.isEmpty()){
            return window;
        }
        if(result.length() < window.length()){
            return result;
        }
        if (result.length() > window.length()) {
            return window;
        }
        if (result.compareTo(window) > 0) {
            return window;
        }
        return result;
    }
}
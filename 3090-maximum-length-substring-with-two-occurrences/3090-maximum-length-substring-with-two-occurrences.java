class Solution {
    public int maximumLengthSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right =0;
        int max = Integer.MIN_VALUE;
        while(right< s.length()){
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            while (map.get(s.charAt(right)) > 2) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            right++;
            max = Math.max(max, right - left + 1);
        }
        return --max;
    }
}
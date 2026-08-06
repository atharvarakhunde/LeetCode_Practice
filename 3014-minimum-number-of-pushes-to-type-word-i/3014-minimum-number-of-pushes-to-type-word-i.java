class Solution {
    public int minimumPushes(String word) {
        Set<Character> set = new HashSet();
        for(int i=0 ; i<word.length();i++){
            set.add(word.charAt(i));

        }
        int unique = set.size();
    int ans = 0;
    for (int i = 0; i < unique; i++) {
        ans += (i / 8) + 1;
    }
    return ans;
    }
}
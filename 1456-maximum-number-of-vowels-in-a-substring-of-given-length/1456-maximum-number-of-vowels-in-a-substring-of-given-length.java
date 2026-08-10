class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> set  = Set.of('a','e','i','o','u');
         int result =0 ;
        int left= 0 ;
        int right = 0 ;
       while(left<k)
       {
        if(set.contains(s.charAt(left))){
            result++;
        }
        left++;
       }
       int temp=result;
        while(left< s.length()){
             if(set.contains(s.charAt(right))){
            temp--;
        }
        if(set.contains(s.charAt(left))){
            temp++;
        }
        left++;
        right++;
        result = Math.max(result,temp);
        }
       return  result;
    }
}
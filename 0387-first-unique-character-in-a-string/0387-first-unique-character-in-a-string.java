class Solution {
    public int firstUniqChar(String s) {
        Map<Character , Integer> map =  new HashMap<>();
        for(Character c : s.toCharArray()){
            map.put(c , map.getOrDefault(c,0)+1);
        }
        
        for(int i = 0 ; i< s.length();i++){
            char temp = s.charAt(i);
         if(map.get(temp) < 2){
            return i;
         }
        }
        return -1;
    }
}
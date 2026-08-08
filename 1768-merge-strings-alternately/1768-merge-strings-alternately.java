class Solution {
    public String mergeAlternately(String word1, String word2) {
      StringBuilder sb =  new StringBuilder();
      int x = 0 ;
      int y = 0;
      int count = 0;
      while(x<word1.length() && y< word2.length()){
        if(count %2 ==0){
            sb.append(word1.charAt(x++));
        }else{
            sb.append(word2.charAt(y++));
        }
        count++;
      }
      while(x<word1.length()){
         sb.append(word1.charAt(x++));
      }
      while(y< word2.length()){
        sb.append(word2.charAt(y++));
      }
      return sb.toString();
    }
}
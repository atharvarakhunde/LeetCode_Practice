class Solution {
    public String convertToTitle(int columnNumber) {
        int temp = columnNumber ;
        StringBuilder sb =  new StringBuilder();
        while(temp!=0){
            temp--;
            char currentchar = (char) ('A'+(temp %26));
            sb.append(currentchar);
            temp /= 26 ;
        }
        return sb.reverse().toString();
    }
}
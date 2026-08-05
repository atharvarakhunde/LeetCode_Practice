class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack();
        for(char c : s.toCharArray()){
            if(c != '*'){
                stack.push(c);
            }else
            {
                stack.pop();
            }
        }
        StringBuilder sb =  new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}
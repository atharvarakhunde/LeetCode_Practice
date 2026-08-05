import java.util.Stack;

class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> str1 = new Stack<>();
        Stack<Character> str2 = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (!str1.isEmpty()) {
                    str1.pop();
                }
            } else {
                str1.push(s.charAt(i));
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '#') { 
                if (!str2.isEmpty()) {
                    str2.pop();
                }
            } else {
                str2.push(t.charAt(i));
            }
        } 
        
        return str1.equals(str2);
    }
}
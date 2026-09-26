import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        // Step 1: Build the lookup map
        Map<String, String> map = new HashMap<>();
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder result = new StringBuilder();
        int n = s.length();
        int i = 0;

        // Step 2: Traverse string s
        while (i < n) {
            char ch = s.charAt(i);

            if (ch == '(') {
                // Extract key name inside brackets
                int start = i + 1;
                while (i < n && s.charAt(i) != ')') {
                    i++;
                }
                String key = s.substring(start, i);

                // Look up value in map
                result.append(map.getOrDefault(key, "?"));
            } else {
                result.append(ch);
            }
            i++;
        }

        return result.toString();
    }
}
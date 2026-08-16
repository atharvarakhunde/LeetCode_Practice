import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        
        // Traverse both trees to collect their leaf values
        dfs(root1, leaves1);
        dfs(root2, leaves2);
        
        // Compare the two lists of leaf values
        return leaves1.equals(leaves2);
    }
    
    // Helper method to perform Depth-First Search
    private void dfs(TreeNode node, List<Integer> leafValues) {
        if (node != null) {
            // If it's a leaf node (no children), add its value to the list
            if (node.left == null && node.right == null) {
                leafValues.add(node.val);
            }
            // Recursively traverse the left and right subtrees
            dfs(node.left, leafValues);
            dfs(node.right, leafValues);
        }
    }
}
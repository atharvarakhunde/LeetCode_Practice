class Solution {
    class Node {
        int leftLen, rightLen, maxLen;
        char leftChar, rightChar;
        int length; // length of the segment

        Node(char c) {
            this.leftLen = 1;
            this.rightLen = 1;
            this.maxLen = 1;
            this.leftChar = c;
            this.rightChar = c;
            this.length = 1;
        }

        Node() {}
    }

    private Node[] tree;
    private char[] chars;

    private Node merge(Node left, Node right) {
        Node res = new Node();
        res.length = left.length + right.length;
        res.leftChar = left.leftChar;
        res.rightChar = right.rightChar;

        // Calculate leftLen
        res.leftLen = left.leftLen;
        if (left.leftLen == left.length && left.rightChar == right.leftChar) {
            res.leftLen += right.leftLen;
        }

        // Calculate rightLen
        res.rightLen = right.rightLen;
        if (right.rightLen == right.length && right.rightChar == left.rightChar) {
            res.rightLen += left.rightLen;
        }

        // Calculate maxLen
        res.maxLen = Math.max(left.maxLen, right.maxLen);
        if (left.rightChar == right.leftChar) {
            res.maxLen = Math.max(res.maxLen, left.rightLen + right.leftLen);
        }

        return res;
    }

    private void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = new Node(chars[start]);
            return;
        }
        int mid = start + (end - start) / 2;
        build(2 * node, start, mid);
        build(2 * node + 1, mid + 1, end);
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    private void update(int node, int start, int end, int idx, char val) {
        if (start == end) {
            chars[idx] = val;
            tree[node] = new Node(val);
            return;
        }
        int mid = start + (end - start) / 2;
        if (idx <= mid) {
            update(2 * node, start, mid, idx, val);
        } else {
            update(2 * node + 1, mid + 1, end, idx, val);
        }
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        chars = s.toCharArray();
        tree = new Node[4 * n];
        build(1, 0, n - 1);

        int k = queryIndices.length;
        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            update(1, 0, n - 1, queryIndices[i], queryCharacters.charAt(i));
            ans[i] = tree[1].maxLen;
        }

        return ans;
    }
}
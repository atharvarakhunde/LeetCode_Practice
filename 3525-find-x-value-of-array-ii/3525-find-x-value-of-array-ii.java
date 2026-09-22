class Solution {
    static class Node {
        int prod; // Total product modulo k for this range
        long[] counts; // counts[rem] = number of prefixes in this node with prefix product % k == rem

        Node(int k) {
            prod = 1;
            counts = new long[k];
        }
    }

    private int k;
    private Node[] tree;
    private int n;

    private Node merge(Node left, Node right) {
        if (left == null) return right;
        if (right == null) return left;

        Node parent = new Node(k);
        parent.prod = (int) ((1L * left.prod * right.prod) % k);

        // Copy left counts directly
        for (int i = 0; i < k; i++) {
            parent.counts[i] = left.counts[i];
        }

        // Add shifted right counts using left's total product
        for (int j = 0; j < k; j++) {
            if (right.counts[j] > 0) {
                int rem = (int) ((1L * left.prod * j) % k);
                parent.counts[rem] += right.counts[j];
            }
        }

        return parent;
    }

    private void build(int node, int start, int end, int[] nums) {
        if (start == end) {
            tree[node] = new Node(k);
            int val = nums[start] % k;
            tree[node].prod = val;
            tree[node].counts[val] = 1;
            return;
        }
        int mid = start + (end - start) / 2;
        build(2 * node, start, mid, nums);
        build(2 * node + 1, mid + 1, end, nums);
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    private void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            int rem = val % k;
            tree[node].prod = rem;
            for (int i = 0; i < k; i++) tree[node].counts[i] = 0;
            tree[node].counts[rem] = 1;
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

    private Node query(int node, int start, int end, int l, int r) {
        if (r < start || end < l) return null;
        if (l <= start && end <= r) return tree[node];

        int mid = start + (end - start) / 2;
        Node leftResult = query(2 * node, start, mid, l, r);
        Node rightResult = query(2 * node + 1, mid + 1, end, l, r);

        return merge(leftResult, rightResult);
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.k = k;
        this.n = nums.length;
        this.tree = new Node[4 * n];

        build(1, 0, n - 1, nums);

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            // 1. Point update on nums array
            update(1, 0, n - 1, index, value);

            // 2. Query range [start, n - 1]
            Node resNode = query(1, 0, n - 1, start, n - 1);

            // 3. Store total count for target remainder x
            ans[i] = resNode != null ? (int) resNode.counts[x] : 0;
        }

        return ans;
    }
}
class Solution {
    private Boolean[][][] memo;

    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // An even total path length (m + n - 1) is required
        if ((m + n - 1) % 2 != 0 || grid[0][0] == ')') {
            return false;
        }

        // Maximum open parenthesis balance can be at most m + n - 1
        memo = new Boolean[m][n][m + n];

        return dfs(grid, 0, 0, 0, m, n);
    }

    private boolean dfs(char[][] grid, int r, int c, int open, int m, int n) {
        // Update balance for current cell
        if (grid[r][c] == '(') {
            open++;
        } else {
            open--;
        }

        // Invalid path: closed brackets exceed open brackets
        if (open < 0) {
            return false;
        }

        // Reached destination: check if all brackets are matched
        if (r == m - 1 && c == n - 1) {
            return open == 0;
        }

        // Return cached result if already visited with this balance
        if (memo[r][c][open] != null) {
            return memo[r][c][open];
        }

        boolean res = false;
        // Move Down
        if (r + 1 < m) {
            res = res || dfs(grid, r + 1, c, open, m, n);
        }
        // Move Right
        if (c + 1 < n) {
            res = res || dfs(grid, r, c + 1, open, m, n);
        }

        return memo[r][c][open] = res;
    }
}
class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();
        
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char current = board[r][c];
                if (current == '.') {
                    continue;
                }
                
                String rowKey = current + " in row " + r;
                String colKey = current + " in col " + c;
                String boxKey = current + " in box " + (r / 3) + "-" + (c / 3);
                
                if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(boxKey)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
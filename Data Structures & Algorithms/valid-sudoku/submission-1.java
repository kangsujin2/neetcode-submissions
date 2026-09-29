class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> boxes = new HashMap<>();
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                char c = board[i][j];
                if (c == '.') continue;

                int box = (i/3)*3 + (j/3);
                    
                if (rows.computeIfAbsent(i, k -> new HashSet<>()).contains(c)
                || cols.computeIfAbsent(j, k -> new HashSet<>()).contains(c)
                || boxes.computeIfAbsent(box, k -> new HashSet<>()).contains(c)) {
                    return false;
                }
                rows.get(i).add(c);
                cols.get(j).add(c);
                boxes.get(box).add(c);
            }
        }

        return true;
    }
}

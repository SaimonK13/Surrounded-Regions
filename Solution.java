class Solution {
    public void solve(char[][] board) {
        
        int m = board.length; // row length
        int n = board[0].length; // column length
        boolean[][] visited = new boolean[m][n];
        
        //iterate over first and last columns. If 'O' is found, perform depth first search.
        //In dfs, keep finding 'O's 4-drirectionally and update the cell value in visited array if 'O' is found.
        for(int i = 0; i < m; i++){
            if(board[i][0] == 'O'){
                dfs(board, i, 0, visited);
            }
            
            if(board[i][n-1] == 'O'){
                dfs(board, i, n-1, visited);
            }
        }
        
        //iterate over first and last row and perform if 'O' is found.
        for(int j = 0; j < n; j++){
            if(board[0][j] == 'O'){
                dfs(board, 0, j, visited);
            }
            
            if(board[m-1][j] == 'O'){
                dfs(board, m-1, j, visited);
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board, int row, int col, boolean[][] visited){

        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] == 'X' ||  visited[row][col]){
            return;
        }

        visited[row][col] = true;
        dfs(board, row-1, col, visited);
        dfs(board, row+1, col, visited);
        dfs(board, row, col+1, visited);
        dfs(board, row, col-1, visited);
    }
}

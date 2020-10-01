class Solution {
    /*
    Issues to check:
    corner cases: recurse columnwise, if end of col, go to new row, if end of row, terminate
    validation of the filled in value: row-wise, column-wise and grid-wise
    */
    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board,0,0);
    }
    public static boolean solveSudokuHelper(char[][] board, int row, int col){
        
        if(col == board[0].length){
            col=0;
            row++;
        }
        
        if(row == board.length){
            return true;
        }
        
        if(board[row][col] != '.')
            return solveSudokuHelper(board,row,col+1);
        
        for(int i=1;i<=9;i++){
            if(isValid(board,row,col,i)){
                board[row][col] = (char)(i+'0');
                if(solveSudokuHelper(board,row,col+1))
                    return true;
            }
        }
        board[row][col]='.';
        return false;
    }
    public static boolean isValid(char[][] board, int row, int col, int num){
        
        for(int i=0;i<9;i++){
            if(board[row][i]==(char)(num+'0'))
                return false;
            if(board[i][col]==(char)(num+'0'))
                return false;
        }
        
        int grid_pos_row = (row/3)*3;
        int grid_pos_col = (col/3)*3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[grid_pos_row+i][grid_pos_col+j]==num+'0')
                    return false;
            }
        }
        return true;
    }   
}
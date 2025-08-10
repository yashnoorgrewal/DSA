class Solution {
    public boolean exist(char[][] board, String word) {
        //make a character array of word
        char[] word_arr = word.toCharArray();
        //iterate
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word_arr[0] && exists(board,i,j,word_arr,0)){
                    return true;
                }
            }
        }return false;
    }
    //exists function
    public static boolean exists(char[][] board, int i, int j, char[] word, int index){
        //base conditions
        if(i<0||i>=board.length || j<0||j>=board[0].length || board[i][j]=='*' || board[i][j]!=word[index]) return false;

        if(index == word.length-1){ //if this satisfies, we found the word in the board
            return true;
        }

        char ch = board[i][j];
        board[i][j] = '*'; //mark the cells already visited
        if(exists(board,i+1,j,word,index+1)||
        exists(board,i-1,j,word,index+1)||
        exists(board,i,j+1,word,index+1)||
        exists(board,i,j-1,word,index+1)){
            return true;
        }
        board[i][j] = ch; //Backtrack
        return false;
    }
}
// Day-15
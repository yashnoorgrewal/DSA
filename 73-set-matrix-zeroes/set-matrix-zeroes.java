class Solution {
    public void setZeroes(int[][] matrix) {
        //first row and column as markers
        boolean firstrow = false;
        boolean firstcol = false;

        //if found 0, make the first row and column as 0
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    if(i==0) firstrow = true;
                    if(j==0) firstcol = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        //for filling the sample matrix elements
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[0][j] == 0 || matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        
        //for first row and column
        if(firstrow){
            for(int j=0;j<matrix[0].length;j++){
                matrix[0][j] = 0;
            }
        }
        if(firstcol){
            for(int i=0;i<matrix.length;i++){
                matrix[i][0] = 0;
            }
        }
    }
}
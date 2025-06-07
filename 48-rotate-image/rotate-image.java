class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //first TRANSPOSE the matrix, then reverse each row
        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //now reverse the rows
        for(int i = 0; i < n; i++){
            int s = 0;
            int e = n - 1;
            while(s < e){
                int t = matrix[i][s];
                matrix[i][s] = matrix[i][e];
                matrix[i][e] = t;
                s++;
                e--;
            }
        }
    }
}
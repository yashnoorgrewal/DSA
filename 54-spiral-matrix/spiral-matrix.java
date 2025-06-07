class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if(matrix.length == 0){
            return list;
        }
        int rowbegin = 0;
        int colbegin = 0;
        int rowend = matrix.length - 1;
        int colend = matrix[0].length - 1;

        while(rowbegin <= rowend && colbegin <= colend){
            //traverse right
            for(int j = colbegin; j <= colend; j++){
                list.add(matrix[rowbegin][j]);
            }
            rowbegin++;
            //traverse down
            for(int j = rowbegin; j <= rowend; j++){
                list.add(matrix[j][colend]);
            }
            colend--;
            //traverse left
            if(rowbegin <= rowend){
                for(int j = colend; j >= colbegin; j--){
                    list.add(matrix[rowend][j]);
                }
            }
            rowend--;
            //traverse up
            if(colbegin <= colend){
                for(int j = rowend; j >= rowbegin; j--){
                    list.add(matrix[j][colbegin]);
                }
            }
            colbegin++;
        }
        return list;
    }    
}
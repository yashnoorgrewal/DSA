class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int s = 0;
        int e = n - 1;

        while(s <= e){
            int mid = s + (e - s) / 2;
            int row = maxincol(mat, m, n, mid);
            int left = mid - 1 >= 0 ? mat[row][mid-1] : -1;
            int right = mid + 1 < n ? mat[row][mid+1] : -1;
            if(mat[row][mid] > left && mat[row][mid] > right){
                return new int[]{row,mid};
            }else if(mat[row][mid] < left){
                e = mid - 1;
            }else{
                s = mid + 1;
            }
        }
        return new int[]{-1,-1};
    }

    static int maxincol(int[][] matrix, int m, int n, int col){
        int max = 0;
        for(int i = 1; i < m; i++){
            if(matrix[i][col] > matrix[max][col]){
                max = i;
            }
        }
        return max;
    }
}
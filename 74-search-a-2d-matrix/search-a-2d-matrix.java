class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // hypothetically think it as a single array intead of a matrix
        int m = matrix.length;
        int n = matrix[0].length;
        int s = 0;
        int e = m*n - 1;

        while(s <= e){
            int mid = s + (e - s) / 2;
            int row = mid / n, col = mid % n;
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] < target){
                s = mid + 1;
            }else{
                e = mid - 1;
            }
        }
        return false;
    }
}
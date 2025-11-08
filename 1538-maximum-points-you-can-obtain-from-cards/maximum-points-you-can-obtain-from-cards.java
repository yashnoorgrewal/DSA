class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int lsum = 0, rsum = 0;
        int maxsum = 0;
        for(int i = 0; i < k; i++){
            lsum += cardPoints[i];
            maxsum = lsum;
        }
        int r_idx = n-1;
        for(int j = k-1; j >= 0; j--){
            lsum -= cardPoints[j];
            rsum += cardPoints[r_idx];
            maxsum = Math.max(maxsum, lsum + rsum);
            r_idx--;
        }
        return maxsum;
    }
}
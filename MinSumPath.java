public class Solution {
    public int minPathSum(int[][] A) {
        
        int dp[] = new int[A[0].length];
        dp[0] = A[0][0];
        for(int i=1;i<A[0].length;i++){
            dp[i] = A[0][i] + dp[i-1];
        }
        for(int i=1;i<A.length;i++){
            int dp1[] = new int[A[0].length];
            dp1[0] = A[i][0] + dp[0];
            for(int j=1;j<A[0].length;j++){
                dp1[j] = Math.min(A[i][j] + dp[j], A[i][j] + dp1[j-1]);
            }
            dp = dp1;
        }
        return dp[A[0].length-1];
    }
}

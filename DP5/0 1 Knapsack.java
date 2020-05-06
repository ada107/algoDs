public class Solution {
    public int solve(int[] A, int[] B, int C) {
        
        int dp[] = new int[C+1];
        for(int i=0;i<A.length;i++){
            int dp1[] = new int[C+1];
            for(int j=1;j<=C;j++){
                if(j>=B[i]){
                    dp1[j] = Math.max(dp[j], A[i] + dp[j-B[i]]);
                }
                else dp1[j] = dp[j];
            }
            dp = dp1;
        }
        
        return dp[C];
    }
}

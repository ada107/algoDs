public class Solution {
    public int solve(int A, int[] B, int[] C) {
        
        
        int dp[] = new int[A + 1];
        
        
        for(int i=0;i<B.length;i++){
            int dp1[] = new int[A+1];
            for(int j=0;j<=A;j++){
                if(j>=C[i]){
                    dp1[j] = Math.max(dp1[j-C[i]] + B[i], dp[j]);
                }
                else dp1[j] = dp[j];
            }
            dp = dp1;
        }
        return dp[A];
        
    }
}

public class Solution {
    public int solve(int[] A, int[] B, int[] C, int D) {
        
        int s[] = new int[A.length];
        for(int i=0;i<A.length;i++){
            s[i] = A[i] * B[i];
        }
        int dp[] = new int[D+1];
        for(int i=0;i<C.length;i++){
            int dp1[] = new int[D+1];
            for(int j=0;j<=D;j++){
                if(j>=C[i]){
                    dp1[j] = Math.max(dp1[j - C[i]] + s[i], dp[j]);
                }
                else{
                    dp1[j] = dp[j];
                }
            }
            dp = dp1;
        }
        return dp[D];
    }
}

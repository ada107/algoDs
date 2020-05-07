public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int solve(final int[] A, final int[] B, final int[] C) {
        long dp[] = new long[1001];
        for(int i=0;i<1001;i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for(int i=0;i<B.length;i++){
            long dp1[] = new long[1001];
            for(int j=0;j<1001;j++){
                if(j>=B[i]){
                    dp1[j] = Math.min(dp1[j-B[i]] + C[i], dp[j]);
                }
                else{
                    dp1[j] = dp[j];
                }
                
            }
            dp = dp1;
        }
        long ans = 0;
        for(int i=0;i<A.length;i++){
            ans += dp[A[i]];
        }
        return (int)ans;
    }
}

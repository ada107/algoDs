public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int solve(final int[] A) {
        
        int sum = 0;
        for(int i=0;i<A.length;i++)
            sum+=A[i];
            
        int dp[] = new int[sum+1];
        for(int i=0;i<sum;i++){
            dp[i]= Integer.MAX_VALUE;
        }

        for(int i=0;i<A.length;i++){
            int dp1[] = new int[sum+1];
            for(int j=0;j<=sum;j++){
                if(j-2*A[i]>=0 && dp[j] != Integer.MAX_VALUE){
                    dp1[j-2*A[i]] = Math.min(dp1[j-2*A[i]], 1 + dp[j]);
                }
                dp1[j] = dp[j];
            }
            dp = dp1;   
        }
        
        for(int i=0;i<=sum;i++){
            if(dp[i]!=Integer.MAX_VALUE)
                return dp[i];
        }
        return 0;
        
        
    }
}

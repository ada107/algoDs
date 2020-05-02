public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int isMatch(final String A, final String B) {
        
    
        boolean dp[] = new boolean[A.length()+2];
        dp[A.length()] = true;
        for(int i=B.length()-1;i>=0;i--){
            boolean dp1[] = new boolean[A.length()+2];
            for(int j=A.length();j>=0;j--){
                if(B.charAt(i)=='*'){
                    dp1[j] = dp[j]|dp1[j+1];
                }
                else if(B.charAt(i)=='?'){
                    dp1[j] = dp[j+1];
                }
                else if(j!=A.length()&&B.charAt(i)==A.charAt(j)){
                    dp1[j] = dp[j+1];
                }
            }
            dp = dp1;
        }
        
        return dp[0]?1:0;
        
    }
}

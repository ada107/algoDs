public class Solution {
    public int coinchange2(int[] A, int B) {
        int dp1[] = new int[B+1];
        dp1[0] = 1;
        for(int i=0;i<A.length;i++){
            int dp2[] = new int[B+1];
            for(int j=0;j<=B;j++){
                if(j>=A[i]){
                    dp2[j] = (dp1[j] + dp2[j-A[i]])%1000007;
                }
                else dp2[j] = dp1[j];
            }
            dp1 = dp2;
        }
        return dp1[B];
    }
}

public class Solution {
	public int minimumTotal(ArrayList<ArrayList<Integer>> a) {
	    // bottom up
	    int dp1[] = new int[a.get(a.size()-1).size()];
	    for(int i=0;i<a.get(a.size()-1).size();i++){
	        dp1[i] = a.get(a.size()-1).get(i);
	    }
	    
	    for(int i=a.size()-2;i>=0;i--){
	        int dp2[] = new int[a.get(i).size()];
	        for(int j=0;j<a.get(i).size();j++){
	            dp2[j] = a.get(i).get(j) + Math.min(dp1[j], dp1[j+1]);
	        }
	        dp1 = dp2;
	    }
	    return dp1[0];
	}
}

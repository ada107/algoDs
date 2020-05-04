public class Solution {
    
    public long sqrt(long A, long start, long end){
        
        if(start>end)
            return -1;
        
        long mid = (start + end)/2;
        
        if(mid*mid > A){
            return sqrt(A, start, mid-1);
        }
        else{
            long ans = sqrt(A, mid+1, end);
            if(ans==-1)
                return mid;
            else return ans;
        }
    }
    
    public int sqrt(long A) {
        
        return (int)sqrt(A, 0, A);
        
    }
}

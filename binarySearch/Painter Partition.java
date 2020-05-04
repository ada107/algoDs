public class Solution {
    
    public long search(int A[], int B, long start, long end){
        
        if(start>end)
            return -1;
        
        long mid = (start + end)/2;
        int count = 1;
        long cur = 0;
        for(int i=0;i<A.length;i++){
            cur+=A[i];
            if(cur>mid){
                cur = A[i];
                count++;
            }
        }
        if(count>B){
            return search(A, B, mid+1, end);
        }
        else{
            long ans = search(A, B, start, mid-1);
            if(ans!=-1)
                return ans;
            else return mid;
        }
    }
    
    
    public int paint(int A, long B, int[] C) {
        long start = 0;
        long end = 0;
        for(int i=0;i<C.length;i++){
            start = Math.max(start, C[i]);
            end += C[i];
        }
        
        return (int) ((1l * search(C , A, start, end) * B) % 10000003);
    }
}

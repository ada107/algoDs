public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    
    public int search(int A[], int start, int end, int x){
        
        if(start>end)
            return -1;
        
        int mid = (start+end)/2;
        
        if(A[mid]==x)
            return mid;
        
        if(A[mid] <= A[end]){
            if(x<=A[end] && x>=A[mid])
                return search(A, mid+1, end, x);
            else return search(A, start, mid-1, x);
        }
        else{
            if(x<=A[mid] && x>=A[start])
                return search(A, start, mid-1, x);
            else return search(A, mid+1, end, x);
        }
    }
    
    public int search(final int[] A, int B) {
        
        return search(A, 0, A.length-1, B);
        
    }
}

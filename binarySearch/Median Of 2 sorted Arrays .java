class Solution {
    
    public double findMedian(int arr1[], int arr2[], int start, int end){
        
        int len = arr1.length + arr2.length;
        int mid1 = (start + end)/2;
        int mid2 = (len + 1)/2 - mid1;
        
        if(mid1!=0 && mid2!=arr2.length && arr1[mid1-1] > arr2[mid2]){
            return findMedian(arr1, arr2, start, mid1-1);
        }
        else if(mid2!=0 && mid1!=arr1.length && arr2[mid2-1] > arr1[mid1]){
            return findMedian(arr1, arr2, mid1+1, end);
        }
        else{
            //System.out.println(mid1 +" "+ mid2);
            int a1 = 0;
            int a2 = 0;
            if(mid1==0){
                a1 = arr2[mid2-1];
            }
            else if(mid2==0){
                a1 = arr1[mid1-1]; 
            }
            else a1 = Math.max(arr1[mid1-1], arr2[mid2-1]);
            if(len%2!=0)
                return a1*1.0;
            //System.out.println(a1);
            if(mid1==arr1.length){
                a2 = arr2[mid2];
            }
            else if(mid2==arr2.length){
                a2 = arr1[mid1];
            }
            else a2 = Math.min(arr1[mid1], arr2[mid2]);
            
            return (a1+a2)/2.0;
        }
        
        
        
    }
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        if(nums1.length < nums2.length){
            return findMedian(nums1, nums2, 0, nums1.length);
        }
        return findMedian(nums2, nums1, 0, nums2.length);
        
    }
}

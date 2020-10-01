class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        if(nums1.length>nums2.length)
            return findMedianSortedArrays(nums2,nums1);
        int x = nums1.length, y = nums2.length;
        if(x==0 && y==0) return 0;
        int low = 0, high = x;
        double ans=0;
        while(low<=high){
            int px = low + (high-low)/2;
            int py = (x+y+1)/2 - px;
            
            int maxLeftX = px==0?Integer.MIN_VALUE:nums1[px-1];
            int minRightX = px==x?Integer.MAX_VALUE:nums1[px];
            
            int maxLeftY = py==0?Integer.MIN_VALUE:nums2[py-1];
            int minRightY = py==y?Integer.MAX_VALUE:nums2[py];
            
            if(maxLeftX<=minRightY && maxLeftY<=minRightX){
                if((x+y)%2==0)
                    ans = (Math.max(maxLeftX,maxLeftY)+Math.min(minRightX,minRightY))/2.0;
                else
                    ans = Math.max(maxLeftX,maxLeftY);
                break;
            }
            else if(maxLeftX>minRightY)
                high=px-1;
            else
                low=px+1;
        }
        return ans;
    }
}
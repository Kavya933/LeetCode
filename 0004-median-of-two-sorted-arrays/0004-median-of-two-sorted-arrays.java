class Solution {
    private int[] mergeTwoSortedArrays(int[] nums1, int[] nums2){
        int i = 0, j = 0, k = 0;
        int[] ans = new int[nums1.length+nums2.length];
        if(nums1.length == 0 && nums2.length!=0){
            return nums2;
        }
        if(nums1.length != 0 && nums2.length==0){
            return nums1;
        }
        while(i < nums1.length && j < nums2.length){
            if(nums1[i]<nums2[j]){
                ans[k] = nums1[i];
                i++;
                k++;
            }
            else{
                ans[k] = nums2[j];
                k++;
                j++;
            }
        }
        while(i<nums1.length){
            ans[k] = nums1[i];
            k++;
            i++;
        }
        while(j<nums2.length){
            ans[k] = nums2[j];
            k++;
            j++;
        }
        return ans;
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergedArray = mergeTwoSortedArrays(nums1,nums2);
        if(mergedArray.length<=1){
            return (double)mergedArray[0]/1;
        }
        if(mergedArray.length == 2){
            return (double)(mergedArray[0]+mergedArray[1])/2;
        }
        if(mergedArray.length % 2 != 0){
            return (double)mergedArray[mergedArray.length/2];
        }
        else{
            return (double)(mergedArray[mergedArray.length/2]+mergedArray[mergedArray.length/2-1])/2;
        }
    }
}
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};
        int firstPos = first(nums, target);
        int lastPos = last(nums, target);
        ans[0] = firstPos;
        ans[1] = lastPos;
 
        return ans;
    }

    public int first(int[] nums, int target){
        int first = -1;
        int s = 0;
        int e = nums.length-1;
        while(s<=e){
            int mid = s + (e-s)/2;
            if(nums[mid] == target){
                first = mid;
                e = mid-1;
            }
            else if(nums[mid] > target){
                e = mid-1;
            }
            else{
                s = mid+1;
            }
        }
        return first;
    }

    public int last(int[] nums, int target){
        int last = -1;
        int s = 0;
        int e = nums.length-1;
        while(s<=e){
            int mid = s + (e-s)/2;
            if(nums[mid] == target){
                last = mid;
                s = mid+1;
            }
            else if(nums[mid] > target){
                e = mid-1;
            }
            else{
                s = mid+1;
            }
        }
        return last;
    }
}
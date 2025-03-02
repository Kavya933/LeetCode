class Solution {
    public int removeDuplicates(int[] nums) {
        ArrayList<Integer> expectedList = new ArrayList<>();
        int i = 0;
        for(int j = 1; j <= nums.length-1; j++){
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];  // different huda i ma insert gardine
            }
        }
        return i+1;   // will point to last index and size will be + 1
    }
}
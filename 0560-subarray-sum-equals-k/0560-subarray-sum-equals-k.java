class Solution {
    public int subarraySum(int[] nums, int k) {
        int prefixSum = 0;
        int count = 0;
        HashMap<Integer, Integer> prefixSumStore = new HashMap<>();
        prefixSumStore.put(0,1);
        for(int i = 0; i < nums.length; i++){
            prefixSum += nums[i];
            if(prefixSumStore.containsKey(prefixSum - k)){
                count += prefixSumStore.get(prefixSum - k);
            }
            prefixSumStore.put(prefixSum, prefixSumStore.getOrDefault(prefixSum,0)+1);
        }
        return count;
    }
   
}
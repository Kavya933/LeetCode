import java.util.Arrays;

class Solution {
    private int binarySearch(int[][] items, int query) {
        int low = 0; 
        int high = items.length - 1; // Initialize high to items.length - 1
        int maxBeauty = 0;
        
        // Corrected binary search condition
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (items[mid][0] <= query) {
                maxBeauty = Math.max(maxBeauty, items[mid][1]); // Update maxBeauty
                low = mid + 1; // Move to the right half to look for higher prices within query range
            } else {
                high = mid - 1; // Move to the left half if the price is greater than query
            }
        }
        
        return maxBeauty;
    }

    public int[] maximumBeauty(int[][] items, int[] queries) {
        int[] ans = new int[queries.length];
        
        // Sort items by price
        Arrays.sort(items, (a, b) -> a[0] - b[0]);
        
        // Track the maximum beauty seen so far for each price in sorted items
        int maximumBeautySeenSoFar = items[0][1];
        for (int[] item : items) {
            maximumBeautySeenSoFar = Math.max(maximumBeautySeenSoFar, item[1]);
            item[1] = maximumBeautySeenSoFar; // Update the beauty to max beauty seen so far
        }
        
        // Perform binary search for each query
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            ans[i] = binarySearch(items, query);
        }
        
        return ans;
    }
}

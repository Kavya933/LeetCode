class Solution {
    public void reverseString(char[] s) {
        int low = 0, high = s.length-1;
        reverse(low,high,s);
    }
    private void reverse(int low, int high, char[] s){
        if(low >= high){
            return;
        }
        char temp = s[low];
        s[low] = s[high];
        s[high] = temp;

        reverse(low + 1, high - 1, s);
    }
}
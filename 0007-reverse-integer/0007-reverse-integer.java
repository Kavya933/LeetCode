class Solution {
    public int reverse(int x) {
        int temp = x;
        int ans = 0;
        while(temp != 0){
            int rem = temp%10;
            if((ans > Integer.MAX_VALUE/10) || (ans < Integer.MIN_VALUE/10)){
                return 0;
            }
            ans = (ans*10)+rem;
            temp = temp/10;
        }
        return ans;
    }
}
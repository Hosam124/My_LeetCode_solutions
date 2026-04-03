class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] out  =new int[nums.length];
        int pref = 1;
        for(int i = 0 ; i<nums.length; i++ ){
            out[i] = pref;
            pref *= nums[i];
        }
        int post = 1;
        for(int i = nums.length -1  ; i>=0; i-- ){
            out[i] *= post;
            post *= nums[i];
        }

        return out;
    }
}
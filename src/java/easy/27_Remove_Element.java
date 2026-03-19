class Solution {
    public int removeElement(int[] nums, int val) {
        int cntNotVal = 0;
        int k = 0;
        for (int i =0 ; i< nums.length ; i++){
            if (nums[i] != val){
                cntNotVal++;
                nums[k] = nums[i];
                k++;
            }
        }
        return cntNotVal;
    }
}
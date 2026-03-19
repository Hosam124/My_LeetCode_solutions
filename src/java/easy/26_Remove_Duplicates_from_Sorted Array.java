class Solution {
    public int removeDuplicates(int[] nums) {
        int cntZeros =1;
        int k = 1;
        if (nums.length == 0){
            return 0;
        }
        for(int i =1 ; i<nums.length ; i++){
            if (nums[i] != nums[i-1]){
                cntZeros++;
                nums[k] = nums[i];
                k++;
            }

        }
        return cntZeros;
    }

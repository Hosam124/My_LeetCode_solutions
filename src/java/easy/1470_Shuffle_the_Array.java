class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] arr = new int[nums.length];
        int l = 0 , r = n;
        boolean flage = true;
        for(int i = 0 ; i < nums.length ; i++){
            if (flage){
                arr[i]=nums[l];
                l++;
            }
            else{
                arr[i]=nums[r];
                r++;
            }
            flage = !flage;
        }
        return arr;
    }
}
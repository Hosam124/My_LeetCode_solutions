class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> mp = new HashMap<>();
        int[] out = new int[2];

        for (int i = 0 ; i< nums.length ; i++){
            int val = target - nums[i];
            if (mp.containsKey(val)){
                out[0] = mp.get(val);
                out[1] = i;
                break;
            }
            mp.put(nums[i],i);
        }
        return out;
    }
}
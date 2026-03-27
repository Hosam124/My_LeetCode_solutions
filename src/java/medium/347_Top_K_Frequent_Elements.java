class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> mp = new HashMap<>();
        int len =  nums.length;
        List<Integer>[] buckets = new List[len+1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        for(int n : nums){
            mp.put(n,mp.getOrDefault(n,0)+1);
        }

        mp.forEach((key,value) -> buckets[value].add(key));
        List<Integer> out = new ArrayList<>();
        for(int i = len ; i>0 ; i--){
            for(int j = 0; j<buckets[i].size(); j++ ){
                k--;
                out.add(buckets[i].get(j));
                if(k == 0){
                    break;
                }
            }
            if(k == 0){
                break;
            }
        }

        int[] intArr = out.stream().mapToInt(Integer::intValue).toArray();
        return intArr;
    }
}
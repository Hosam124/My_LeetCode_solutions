class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0 , r = 0;
        Map<Character,Integer>mp = new HashMap<>();
        int maxLen = 0;
        while(r<s.length()){
            if (mp.containsKey(s.charAt(r))){
                if (mp.get(s.charAt(r)) >= l ){
                    maxLen = Math.max(maxLen,r-l);
                    l = mp.get(s.charAt(r))+1;
                }
            }
            mp.put(s.charAt(r), r);
            r++;
        }
        maxLen = Math.max(maxLen,r-l);

        return maxLen;
    }
}
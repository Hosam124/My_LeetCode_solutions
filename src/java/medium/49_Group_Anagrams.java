class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mp = new HashMap<>();
        if(strs.length == 0 ){
            return List.of(List.of(""));
        }
        for (String s : strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            List <String> res = mp.getOrDefault(key, new ArrayList<>());
            res.add(s);
            mp.put(key,res);
        }
        List<List<String>> out = new ArrayList<>();

        for(List<String> l : mp.values()){
            out.add(l);
        }
        return out;
    }
}
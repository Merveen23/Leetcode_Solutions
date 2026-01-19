class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map = new HashMap<>();

        for(String w : (s1 + " " + s2).split(" ")) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        List<String> res = new ArrayList<>();
        for(String key : map.keySet()) {
            if(map.get(key) == 1) {
                res.add(key);
            }
        }
        return res.toArray(new String[0]);
    }
}
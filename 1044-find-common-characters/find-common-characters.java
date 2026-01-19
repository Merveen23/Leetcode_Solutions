class Solution {
    public List<String> commonChars(String[] words) {
        int[] freq = new int[26];
        for(char c : words[0].toCharArray()) {
            freq[c - 'a']++;
        }

        for(int i = 1;i < words.length;i++) {
            int[] temp = new int[26];
            for(char c : words[i].toCharArray()) {
                temp[c - 'a']++;
            }
            for(int j = 0;j < 26;j++) {
                freq[j] = Math.min(freq[j], temp[j]);
            }
        }

        List<String> res = new ArrayList<>();
        for(int i = 0;i < 26;i++) {
            while(freq[i] --> 0) {
                res.add(String.valueOf((char)(i + 'a')));
            }
        }
        return res;
    }
}
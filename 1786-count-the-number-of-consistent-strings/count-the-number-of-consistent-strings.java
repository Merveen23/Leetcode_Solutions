class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for(char c : allowed.toCharArray()) {
            set.add(c);
        }

        int count = 0;
        for(String word : words) {
            boolean ok = true;
            for(char c : word.toCharArray()) {
                if(!set.contains(c)) {
                    ok = false;
                    break;
                }
            }
            if(ok) count++;    
        }
        return count;
    }
}
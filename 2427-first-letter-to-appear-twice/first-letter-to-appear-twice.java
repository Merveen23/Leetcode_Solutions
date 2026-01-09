class Solution {
    public char repeatedCharacter(String s) {
        boolean[] seen = new boolean[26];

        for(char c : s.toCharArray()) {
            int index = c - 'a';
            if(seen[index]) {
                return c;
            }
            seen[index] = true;
        }
        return ' ';
    }
}
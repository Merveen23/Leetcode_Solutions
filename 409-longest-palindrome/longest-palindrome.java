class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[128];
        for(char c : s.toCharArray()) {
            freq[c]++;
        }

        int length = 0;
        boolean oddFound = false;

        for(int f : freq) {
            if(f % 2 == 0) {
                length += f;
            }
            else {
                length += f - 1;
                oddFound = true;
            }
        }
        if(oddFound) length++;

        return length;
    }
}
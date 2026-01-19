class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] firstIndex = new int[26];
        Arrays.fill(firstIndex, -1);

        int maxLen = -1;

        for(int i = 0;i < s.length();i++) {
            int idx = s.charAt(i) - 'a';

            if(firstIndex[idx] == -1) {
                firstIndex[idx] = i;
            }
            else {
                maxLen = Math.max(maxLen, i - firstIndex[idx] - 1);
            }
        }
        return maxLen;
    }
}
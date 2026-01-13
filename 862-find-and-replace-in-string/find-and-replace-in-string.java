import java.util.*;

class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int n = indices.length;
        int[][] ops = new int[n][2];

        for(int i = 0;i < n;i++) {
            ops[i][00] = indices[i];
            ops[i][1] = i;
        }

        Arrays.sort(ops, (a, b) -> a[0] - b[0]);

        StringBuilder result = new StringBuilder();
        int i = 0;

        for(int[] op : ops) {
            int index = op[0];
            int idx = op[1];
            String src = sources[idx];
            String tgt = targets[idx];

            while(i < index) {
                result.append(s.charAt(i));
                i++;
            }
            if(s.startsWith(src, index)) {
                result.append(tgt);
                i += src.length();
            }
        }

        while(i < s.length()) {
            result.append(s.charAt(i));
            i++;
        }
        return result.toString();
    }
}
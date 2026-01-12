class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {

        int k = primes.length;

        long[] dp = new long[n];
        dp[0] = 1L;

        int[] idx = new int[k];
        long[] next = new long[k];

        for (int i = 0; i < k; i++) {
            next[i] = primes[i];
        }

        for (int i = 1; i < n; i++) {
            long min = Long.MAX_VALUE;

            for (int j = 0; j < k; j++) {
                if (next[j] < min) {
                    min = next[j];
                }
            }

            dp[i] = min;

            for (int j = 0; j < k; j++) {
                if (next[j] == min) {
                    idx[j]++;
                    next[j] = dp[idx[j]] * primes[j];
                }
            }
        }

        return (int) dp[n - 1];
    }
}

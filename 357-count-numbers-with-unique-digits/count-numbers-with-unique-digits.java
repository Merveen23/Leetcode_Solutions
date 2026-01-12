class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;

        int result = 10;
        int uniqueDigits = 9;
        int available = 9;

        for(int i = 2;i <= n;i++) {
            uniqueDigits *= available;
            result += uniqueDigits;
            available--;
        }
        return result;
    }
}
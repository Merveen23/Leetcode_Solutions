class Solution {
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(daysFrom1971(date1) - daysFrom1971(date2));
    }

    private int daysFrom1971(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));

        int[] daysInMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
        int days = 0;

        for (int y = 1971; y < year; y++) {
            days += isLeap(y) ? 366 : 365;
        }

        for (int m = 1; m < month; m++) {
            days += daysInMonth[m - 1];
            if (m == 2 && isLeap(year)) days++;
        }

        days += day;

        return days;
    }

    private boolean isLeap(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }
}

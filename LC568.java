//Dynamic programming
//Time: O(weeks * citites ^ 2)
//Space: O(cities) improved from O(cities * weeks)

class Solution {
    public int maxVacationDays(int[][] flights, int[][] days) {
        //dp[i][j]: the max number of days in the first i weeks, and stay in city j on the i-th week
        //dp[i][j] = max(dp[i - 1][k] + days[j][i - 1], if flights[k][j] == 1 || k == j)
        //dp[0][0] = 0
        //target: max of dp[weeks][k]
        //time: O(weeks * cities * cities) space: O(weeks * cities)
        if (flights.length == 0 || days.length == 0 || days[0].length == 0)
            return 0;
        int cities = flights.length;
        int weeks = days[0].length;
        //Version 1: space = weeks * cities
        /*
        int[][] dp = new int[weeks + 1][cities];
        for (int i = 0; i <= weeks; i++) {
            for (int j = 0; j < cities; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        dp[0][0] = 0;
        int max = 0;
        for (int i = 1; i <= weeks; i++) {
            for (int j = 0; j < cities; j++) {
                for (int k = 0; k < cities; k++) {
                    if (j == k || flights[k][j] == 1) {
                        dp[i][j] = Math.max(dp[i - 1][k] + days[j][i - 1], dp[i][j]);
                        if (i == weeks)
                            max = Math.max(dp[i][j], max);
                    }
                }
            }
        }
        */
        
        int[] dp = new int[cities];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        int[] temp = new int[cities];
        copy(temp, dp);
        int max = 0;
        for (int i = 1; i <= weeks; i++) {
            for (int j = 0; j < cities; j++) {
                for (int k = 0; k < cities; k++) {
                    if (k == j || flights[k][j] == 1) {
                        dp[j] = Math.max(temp[k] + days[j][i - 1], dp[j]);
                        if (i == weeks) {
                            max = Math.max(dp[j], max);
                        }
                    }
                }
            }
            copy(temp, dp);
        }
        return max;
    }
    
    public void copy(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            a[i] = b[i];
        }
    }
}
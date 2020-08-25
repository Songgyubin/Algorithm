package dp;

import java.util.Scanner;

public class BOJ_9465 {
    private static int[][] arr;
    private static int[][] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            arr = new int[2][n+1];
            dp = new int[2][n+1];


            for (int j = 0; j < 2; j++) {
                for (int k = 1; k <= n; k++) {
                    arr[j][k] = scanner.nextInt();
                }
            }
            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];

            for (int m = 2; m <= n; m++) {
                dp[0][m] = Math.max(
                        dp[1][m - 1], dp[1][m - 2]
                ) + arr[0][m];

                dp[1][m] = Math.max(
                        dp[0][m - 1], dp[0][m - 2]
                ) + arr[1][m];
            }
            System.out.println(Math.max(dp[0][n],dp[1][n]));
        }
    }
}

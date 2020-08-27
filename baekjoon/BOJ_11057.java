package dp;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11057 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int dp[][] = new int[n + 1][10];
        if (n == 1) {
            System.out.println(10);
            System.exit(0);
        }
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 9; j >= 0; j--) {
                if (j == 9) dp[i][9] = 1;
                else
                    dp[i][j] = (dp[i][j + 1])%10007 + (dp[i - 1][j])%10007;
            }
        }

        System.out.println((Arrays.stream(dp[n]).sum())%10007);

    }
}

package backtracking;

import java.util.Scanner;

public class BOJ_2661 {

    static int n;

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        if (n == 1) {
            System.out.println(1);
        }
        backtracking("");

    }

    static void backtracking(String s) {
        if (n == s.length()) {
            System.out.println(s);
            System.exit(0);
        }
        for (int i = 1; i <= 3; i++) {
            if (isGood(s + i))
                backtracking(s + i);
        }
    }

    static boolean isGood(String s) {
        int len = s.length() / 2;
        for (int i = 1; i <= len; i++) {
            if (s.substring(s.length() - i).equals(s.substring(s.length() - 2 * i, s.length() - i))) {
                return false;
            }
        }
        return true;
    }
}

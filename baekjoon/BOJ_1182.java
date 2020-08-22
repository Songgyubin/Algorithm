package backtracking;

import java.util.Scanner;


public class BOJ_1182 {

    static int[] arr;
    static boolean[] vis;
    static int answer = 0;

    static int n;
    static int s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        s = scanner.nextInt();

        arr = new int[n];
        vis = new boolean[2000001];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        backtracking(0,0);
        if (s==0) answer--;
        System.out.println(answer);
    }

    static private void backtracking(int count,int sum) {
        if (count == n){
            if (sum == s) answer++;
            return;
        }
        backtracking(count+1,sum);
        backtracking(count+1,sum+arr[count]);

    }
}

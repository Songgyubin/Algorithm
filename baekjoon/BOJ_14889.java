package backtracking;

import java.util.Scanner;

public class BOJ_14889 {
    private static int[][] arr;
    private static boolean[] vis;
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        arr = new int[n+1][n+1];
        vis = new boolean[n+1];

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        backtracking(1, 0, n);
        System.out.println(answer);
    }

    private static void backtracking(int start, int count, int n) {
        if (count == n/2){
            answer = Math.min(answer,getAnswer(n));
            return;
        }
        for (int i = start;i<n+1;i++){
            if (!vis[i]){
                vis[i] = true;
                backtracking(i+1,count+1,n);
                vis[i] = false;
            }
        }
    }
    private static int getAnswer(int n){
        int start = 0;
        int link = 0;

        for (int i =1;i<n+1;i++){
            for (int j = 1;j<n+1;j++){
                if (vis[i]&&vis[j]){
                    start+= arr[i][j];
                }
                if (!vis[i]&&!vis[j]){
                    link += arr[i][j];
                }
            }
        }
        return Math.abs(start-link);
    }
}
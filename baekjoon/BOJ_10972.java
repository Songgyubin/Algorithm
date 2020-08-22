package math;

import java.util.Scanner;

public class BOJ_10972 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = scanner.nextInt();
        if (next(arr)){
            for (int i =0; i<arr.length;i++){
                System.out.print(arr[i]+" ");
            }
        }
        else System.out.println(-1);
    }

    private static boolean next(int[] a) {
        int i = a.length - 1;
        while (i>0 && a[i-1]>=a[i]){
            i--;
        }

        if (i<=0){
            return false;
        }
        int j = a.length - 1;
        while (a[j]<=a[i-1]){
            j--;
        }
        swap(a,i-1,j);
        j = a.length-1;
        while (i<j){
            swap(a,i,j);
            i++;
            j--;
        }
        return true;

    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}

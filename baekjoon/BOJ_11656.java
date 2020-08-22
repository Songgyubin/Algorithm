package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Consumer;

public class BOJ_11656 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0;i<s.length();i++){
            ans.add(s.substring(i));
        }
        Collections.sort(ans);
        ans.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }
}

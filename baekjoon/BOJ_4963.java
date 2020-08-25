package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_4963 {

    private static int[] goX = {0, 0, 1, -1, -1, -1, 1, 1};
    private static int[] goY = {1, -1, 0, 0, -1, 1, 1, -1};

    private static int[][] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int w = scanner.nextInt();
            int h = scanner.nextInt();

            if (w == 0 && h == 0) System.exit(0);

            arr = new int[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    arr[i][j] = scanner.nextInt();
                }
            }
            System.out.println(bfs(w, h));
        }

    }

    private static int bfs(int w, int h) {
        int answer = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (arr[i][j] == 1) {
                    Queue<Node> queue = new LinkedList<>();
                    queue.add(new Node(i, j));
                    arr[i][j] = -1;
                    answer++;
                    while (!queue.isEmpty()) {
                        int x = queue.peek().getX();
                        int y = queue.peek().getY();
                        queue.poll();
                        for (int k = 0; k < 8; k++) {
                            int curX = x + goX[k];
                            int curY = y + goY[k];
                            if (curX >= 0 && curX < h && curY >= 0 && curY < w && arr[curX][curY] == 1) {
                                queue.add(new Node(curX, curY));
                                arr[curX][curY] = -1;
                            }
                        }
                    }

                }
            }
        }


        return answer;
    }
}

class Node {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

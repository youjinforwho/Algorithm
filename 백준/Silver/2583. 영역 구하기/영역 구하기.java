import java.io.*;
import java.util.*;


public class Main {
    static int[][] area;
    static boolean[][] check;
    static int res = 0;
    static int M, N;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<Integer> arr = new ArrayList<>();

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (area[i][j] == 0 && !check[i][j]) {
                    res++;
                    check[i][j] = true;
                    q.add(new int[] {i, j});
                    int num = 1;
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        for (int dir = 0; dir < 4; dir++) {
                            int nx = cur[0] + dx[dir];
                            int ny = cur[1] + dy[dir];

                            if (nx == M || ny == N || nx == -1 || ny == -1) continue;
                            if (check[nx][ny] || area[nx][ny] == 1) continue;
                            check[nx][ny] = true;
                            q.add(new int[] {nx, ny});
                            num++;
                        }
                    }
                    arr.add(num);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        int K = Integer.parseInt(s[2]);

        area = new int[M][N];
        check = new boolean[M][N];
        for (int i = 0; i < K; i++) {
            String[] s1 = br.readLine().split(" ");
            int x1 = Integer.parseInt(s1[0]);
            int y1 = Integer.parseInt(s1[1]);
            int x2 = Integer.parseInt(s1[2]) - 1;
            int y2 = Integer.parseInt(s1[3]) - 1;

            for (int j = x1; j <= x2; j++) {
                for (int k = y1; k <= y2; k++) {
                    area[j][k] = 1;
                }
            }
        }

        bfs();
        System.out.println(res);
        Collections.sort(arr);
        for (int i : arr) System.out.print(i + " ");
    }
}


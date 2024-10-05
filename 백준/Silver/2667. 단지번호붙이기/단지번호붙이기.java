import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static int[][] danji;
  static boolean[][] check;
  static int[] dx = {0, 0, -1, 1};
  static int[] dy = {1, -1, 0, 0};

  static void bfs() {
    Queue<int[]> q = new LinkedList<>();
    ArrayList<Integer> arr = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (danji[i][j] == 1 && !check[i][j]) {
          int area = 1;
          q.add(new int[]{i, j});
          check[i][j] = true;
          while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
              int nx = cur[0] + dx[dir];
              int ny = cur[1] + dy[dir];
              if (nx == N || ny == N || nx == -1 || ny == -1) continue;
              if (danji[nx][ny] == 0 || check[nx][ny]) continue;
              q.add(new int[]{nx, ny});
              check[nx][ny] = true;
              area++;
            }
          }
          arr.add(area);
        }
      }
    }
    System.out.println(arr.size());
    Collections.sort(arr);
    for (int i : arr) {
      System.out.println(i);
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    danji = new int[N][N];
    check = new boolean[N][N];
    for (int i = 0; i < N; i++) {
      String[] s = br.readLine().split("");
      for (int j = 0; j < N; j++) {
        danji[i][j] = Integer.parseInt(s[j]);
      }
    }
    bfs();
  }
}
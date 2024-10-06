import java.io.*;
import java.util.*;

public class Main {
  static int N, M, H;
  static int[][][] box, day;
  static boolean[][][] check;
  static Queue<int[]> q = new LinkedList<>();
  static int[] dx = {0, 0, -1, 1, 0, 0};
  static int[] dy = {1, -1, 0, 0, 0, 0};
  static int[] dz = {0, 0, 0, 0, -1, 1};


  static int bfs() {
    while (!q.isEmpty()) {
      int[] cur = q.poll();
      for (int dir = 0; dir < 6; dir++) {
        int nx = cur[0] + dx[dir];
        int ny = cur[1] + dy[dir];
        int nz = cur[2] + dz[dir];

        if (nx == -1 || ny == -1 || nz == -1 || nx == H || ny == N || nz == M) continue;
        if (!check[nx][ny][nz] && box[nx][ny][nz] == 0) {
          day[nx][ny][nz] = day[cur[0]][cur[1]][cur[2]] + 1;
          check[nx][ny][nz] = true;
          q.add(new int[] {nx, ny, nz});
        }
      }
    }
    int ans = 0;
    for (int i = 0; i < H; i++) {
      for (int j = 0; j < N; j++) {
        for (int k = 0; k < M; k++) {
          if (box[i][j][k] == 0) {
            if (day[i][j][k] == 0) return -1;
            ans = Math.max(ans, day[i][j][k]);
          }
        }
      }
    }
    return ans;
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    M = Integer.parseInt(s[0]);
    N = Integer.parseInt(s[1]);
    H = Integer.parseInt(s[2]);

    box = new int[H][N][M];
    day = new int[H][N][M];
    check = new boolean[H][N][M];
    for (int i = 0; i < H; i++) {
      for (int j = 0; j < N; j++) {
        String[] s1 = br.readLine().split(" ");
        for (int k = 0; k < M; k++) {
          box[i][j][k] = Integer.parseInt(s1[k]);
          if (box[i][j][k] == 1) {
            check[i][j][k] = true;
            q.add(new int[] {i, j, k});
          }
        }
      }
    }
    System.out.println(bfs());

  }
}
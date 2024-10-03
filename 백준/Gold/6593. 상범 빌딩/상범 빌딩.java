import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  static int[][][] arr, dist;
  static boolean[][][] check;
  static Queue<int[]> q;
  static int[] dx = {-1, 0, 1, 0, 0, 0};
  static int[] dy = {0, -1, 0, 1, 0, 0};
  static int[] dz = {0, 0, 0, 0, 1, -1};
  static int L, R, C, ans;
  static boolean flag;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      String[] s = br.readLine().split(" ");
      q= new LinkedList<>();

      L = Integer.parseInt(s[0]);
      R = Integer.parseInt(s[1]);
      C = Integer.parseInt(s[2]);

      if (L == 0 && R == 0 && C == 0) break;
      arr = new int[L][R][C];
      check = new boolean[L][R][C];

      for (int i = 0; i < L; i++) {
        for (int j = 0; j < R; j++) {
          String[] line = br.readLine().split("");
          for (int k = 0; k < C; k++) {
            char A = line[k].charAt(0);
            if (A == '#') arr[i][j][k] = -1;
            else if (A == 'S') {
              q.add(new int[] {i, j, k});
              check[i][j][0] = true;
            }
            else if (A == 'E') arr[i][j][k] = -2;
          }
        }
        br.readLine();
      }

      flag = false;
      ans = 0;
      dist = new int[L][R][C];

      while (!q.isEmpty()) {
        int[] cur = q.poll();
        if (arr[cur[0]][cur[1]][cur[2]] == -2) {
          flag = true;
          ans = dist[cur[0]][cur[1]][cur[2]];
          break;
        }

        for (int dir = 0; dir < 6; dir++) {
          int nx = cur[0] + dx[dir];
          int ny = cur[1] + dy[dir];
          int nz = cur[2] + dz[dir];

          if (nx == -1 || ny == -1 || nz == -1 || nx == L || ny == R || nz == C) continue;
          if (arr[nx][ny][nz] == -1 || check[nx][ny][nz]) continue;
          q.add(new int[] {nx, ny, nz});
          check[nx][ny][nz] = true;
          dist[nx][ny][nz] = dist[cur[0]][cur[1]][cur[2]] + 1;
        }
      }
      if (flag) {
        System.out.println("Escaped in " + ans + " minute(s).");
      } else {
        System.out.println("Trapped!");
      }

    }

  }
}
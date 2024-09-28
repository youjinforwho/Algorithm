import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import org.w3c.dom.ls.LSOutput;

public class Main {
  static int[] dx = {0, 0, -1, 1};
  static int[] dy = {1, -1, 0, 0};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    int N = Integer.parseInt(s[0]);
    int M = Integer.parseInt(s[1]);
    int max = 0;
    int[][] arr = new int[N][M];
    int K = Integer.parseInt(s[2]);
    for (int i = 0; i < K; i++) {
      String[] s2 = br.readLine().split(" ");
      int r = Integer.parseInt(s2[0]) - 1;
      int c = Integer.parseInt(s2[1]) - 1;
      arr[r][c] = 1;
    }
    boolean[][] visited = new boolean[N][M];
    Queue<int[]> q = new LinkedList<>();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (arr[i][j] == 1 && !visited[i][j]) {
          visited[i][j] = true;
          q.add(new int[]{i, j});
          int area = 1;
          while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int dir = 0; dir < 4; dir++) {
              int nx = cur[0] + dx[dir];
              int ny = cur[1] + dy[dir];
              if (nx == N || ny == M || nx == -1 || ny == -1)
                continue;
              if (visited[nx][ny] || arr[nx][ny] == 0)
                continue;
              visited[nx][ny] = true;
              q.add(new int[]{nx, ny});
              area++;
            }
          }
          if (area >= max) max = area;
        }
      }
    }
    System.out.println(max);
  }
}
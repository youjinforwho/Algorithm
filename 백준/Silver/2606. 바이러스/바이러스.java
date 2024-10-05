import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static int[][] computers;
  static boolean[] check;
  static int ans = 0;

  public static void dfs(int v) {
    for (int i= 0; i < N; i++) {
      if (computers[v][i] == 1 && !check[i]) {
        check[i] = true;
        ans++;
        dfs(i);
      }
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    computers = new int[N][N];
    check = new boolean[N];

    for (int i = 0; i < M; i++) {
      String[] s = br.readLine().split(" ");
      int x = Integer.parseInt(s[0]) - 1;
      int y = Integer.parseInt(s[1]) - 1;
      computers[x][y] = 1;
      computers[y][x] = 1;
    }

    check[0] = true;
    dfs(0);
    System.out.println(ans);
  }
}
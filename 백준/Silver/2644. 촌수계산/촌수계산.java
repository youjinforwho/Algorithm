import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  static int N;
  static int[][] arr;
  static boolean[] check;
  static int n1, n2;
  static int res;

  public static void dfs(int prev, int depth) {
    if (prev == n2) {
      if (res > depth) res = depth;
      return ;
    }
    for (int i = 0; i < N; i++) {
      if (!check[i] && arr[prev][i] == 1) {
        check[i] = true;
        dfs(i, depth + 1);
      }
    }

  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    arr = new int[N][N];
    check = new boolean[N];
    res = N;

    String[] s = br.readLine().split(" ");
    n1 = Integer.parseInt(s[0]) - 1;
    n2 = Integer.parseInt(s[1]) - 1;
    int M = Integer.parseInt(br.readLine());
    for (int i = 0; i < M; i++) {
      String[] s1 = br.readLine().split(" ");
      int x = Integer.parseInt(s1[0]) - 1;
      int y = Integer.parseInt(s1[1]) - 1;
      arr[x][y] = 1;
      arr[y][x] = 1;
    }
    check[n1] = true;
    dfs(n1, 0);
    if (res == N) {
      System.out.println(-1);
    } else {
      System.out.println(res);
    }
  }


}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  static int[][] node;
  static boolean[] check;
  static int N;

  public static void bfs(int v) {
    System.out.print((v + 1) + " ");
    check[v] = true;
    Queue<Integer> q = new LinkedList<>();
    q.add(v);
    while (!q.isEmpty()) {
      int cur = q.poll();
      for (int i = 0; i < N; i++) {
        if (!check[i] && node[cur][i] == 1) {
          q.add(i);
          check[i] = true;
          System.out.print((i + 1) + " ");
        }
      }
    }
    System.out.println();
  }

  public static void dfs(int v) {
    check[v] = true;
    for (int i = 0; i < N; i++) {
      if (!check[i] && node[v][i] == 1) {
        check[i] = true;
        System.out.print((i + 1) + " ");
        dfs(i);
      }
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    N = Integer.parseInt(s[0]);
    int M = Integer.parseInt(s[1]);
    int V = Integer.parseInt(s[2]) - 1;
    node = new int[N][N];
    check = new boolean[N];
    for (int i = 0; i < M; i++) {
      String[] s1 = br.readLine().split(" ");
      int x = Integer.parseInt(s1[0]) - 1;
      int y = Integer.parseInt(s1[1]) - 1;
      node[x][y] = 1;
      node[y][x] = 1;
    }
    System.out.print(V + 1 + " ");
    dfs(V);
    System.out.println();
    check = new boolean[N];
    bfs(V);
  }
}
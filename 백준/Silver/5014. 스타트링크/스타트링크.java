import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] s = br.readLine().split(" ");
    Queue<Integer> q = new LinkedList<>();
    
    int F = Integer.parseInt(s[0]);
    int S = Integer.parseInt(s[1]);
    int G = Integer.parseInt(s[2]);
    int U = Integer.parseInt(s[3]); // 위
    int D = Integer.parseInt(s[4]); // 아래

    int[] dist = new int[F + 1];
    boolean[] check = new boolean[F + 1];
    check[S] = true;
    q.add(S);
    while (!q.isEmpty()) {
      int cur = q.poll();
      if (cur == G) {
        System.out.println(dist[cur]);
        System.exit(0);
      }
      if (cur + U <= F && !check[cur + U]) {
        check[cur + U] = true;
        dist[cur + U] = dist[cur] + 1;
        q.add(cur + U);
      }
      if (cur - D >= 1 && !check[cur - D]) {
        check[cur - D] = true;
        dist[cur - D] = dist[cur] + 1;
        q.add(cur - D);
      }
    }
    System.out.println("use the stairs");

  }
}
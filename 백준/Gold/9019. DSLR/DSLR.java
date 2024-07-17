import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String[] s = br.readLine().split(" ");
            int A = Integer.parseInt(s[0]);
            int B = Integer.parseInt(s[1]);

            boolean[] check = new boolean[10001];
            String[] ans = new String[10001];
            Arrays.fill(ans, "");

            Queue<Integer> q = new LinkedList<>();
            q.add(A);
            check[A] = true;
            while (!q.isEmpty()) {
                int cur = q.poll();
                int D = (2 * cur) % 10000;
                int S = (cur == 0) ? 9999 : cur - 1;
                int L = (cur % 1000) * 10 + cur / 1000;
                int R = (cur % 10) * 1000 + cur / 10;

                if (!check[D]) {
                    q.add(D);
                    check[D] = true;
                    ans[D] = ans[cur] + "D";
                }

                if (!check[S]) {
                    q.add(S);
                    check[S] = true;
                    ans[S] = ans[cur] + "S";
                }

                if (!check[L]) {
                    q.add(L);
                    check[L] = true;
                    ans[L] = ans[cur] + "L";
                }

                if (!check[R]) {
                    q.add(R);
                    check[R] = true;
                    ans[R] = ans[cur] + "R";
                }
            }
            sb.append(ans[B] + "\n");
        }
        System.out.println(sb);
    }
}
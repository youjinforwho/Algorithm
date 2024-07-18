import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        long A = Integer.parseInt(s[0]);
        long B = Integer.parseInt(s[1]);

        Queue<long[]> q = new LinkedList<>();

        q.add(new long[] {A, 0});
        while (!q.isEmpty()) {
            long[] cur = q.poll();
            if (cur[0] == B) {
                System.out.println(cur[1] + 1);
                System.exit(0);
            }
            if (cur[0] * 2 <= B) {
                q.add(new long[] {cur[0] * 2, cur[1] + 1});
            }
            if ((cur[0] * 10 + 1) <= B) {
                q.add(new long[] {cur[0] * 10 + 1, cur[1] + 1});
            }
        }
        System.out.println(-1);

    }
}
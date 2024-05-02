import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		if (N >= K) {
			System.out.println(N - K);
			System.exit(0);
		}
		int[] dist = new int[200001];
		boolean[] check = new boolean[200001];
		Queue<Integer> q = new LinkedList<>();
		q.offer(N);
        check[N] = true;
		while (!q.isEmpty()) {
            //if (dist[K] != 0) break;
			int cur = q.poll();
			if (cur * 2 <= 200000 && !check[cur * 2]) {
				check[cur * 2] = true;
				dist[cur * 2] = dist[cur] + 1;
				q.offer(cur * 2);
			}
			if (cur + 1 <= K && !check[cur + 1]) {
				check[cur + 1] = true;
				dist[cur + 1] = dist[cur] + 1;
				q.offer(cur + 1);
			}
			if (cur - 1 >= 0 && !check[cur - 1]) {
				check[cur - 1] = true;
				dist[cur - 1] = dist[cur] + 1;
				q.offer(cur - 1);
			}
		}
		System.out.println(dist[K]);
	}
}
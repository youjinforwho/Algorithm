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
			if (check[K] == true) break;
			int cur = q.poll();
			int mult = cur * 2;
			while (mult != 0 && mult <= 200000 && !check[mult]) {
				check[mult] = true;
				dist[mult] = dist[cur];
				q.offer(mult);
				mult *= 2;
			}
			if (cur - 1 >= 0 && !check[cur - 1]) {
				check[cur - 1] = true;
				dist[cur - 1] = dist[cur] + 1;
				q.offer(cur - 1);
			}
			if (cur + 1 <= K && !check[cur + 1]) {
				check[cur + 1] = true;
				dist[cur + 1] = dist[cur] + 1;
				q.offer(cur + 1);
			}
		}
		System.out.println(dist[K]);
	}
}
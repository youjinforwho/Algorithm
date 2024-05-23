import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] dist;
	static int[] move;
	static boolean[] check;
	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		check[1] = true;
		int next;
		while (!q.isEmpty() && !check[100]) {
			int cur = q.poll();
			for (int i = 1; i <= 6; i++) {
				next = cur + i;
				if (next > 100) continue;
				if (check[next]) continue;
				if (move[next] != 0 && dist[move[next]] != 0) continue;
				if (move[next] != 0) {
					check[next] = true;
					check[move[next]] = true;
					dist[next] = dist[cur] + 1;
					dist[move[next]] = dist[cur] + 1;
					q.offer(move[next]);
				} else {
					check[next] = true;
					dist[next] = dist[cur] + 1;
					q.offer(next);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		dist = new int[101];
		
		move = new int[101];
		check = new boolean[101];
		
		for (int i = 0; i < M + N; i++) {
			String[] coordinate = br.readLine().split(" ");
			int u = Integer.parseInt(coordinate[0]);
			int v = Integer.parseInt(coordinate[1]);
			move[u] = v;
		}
		
		bfs();
		System.out.println(dist[100]);
	}
}
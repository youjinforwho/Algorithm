import java.util.*;
import java.io.*;

public class Main {
	static int[][] node, dist;
	static int N;
	
	public static void bfs(int who) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(who);
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 0; i < N; i++) {
				if (node[cur][i] == 1 && dist[who][i] == 0) {
					dist[who][i] = 1;
					q.offer(i);
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		node = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				node[i][j] = Integer.parseInt(s[j]);
			}
		}
		dist = new int[N][N];
		for (int i = 0; i < N; i++) {
			bfs(i);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(dist[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
import java.util.*;
import java.io.*;

public class Main {
	public static void bfs(int N, int M, int[][] dist, int[][] miro) {
		int dx[] = {1, 0, 0, -1};
		int dy[] = {0, -1, 1, 0};
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0, 0});
		dist[0][0] = 1;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if (nx < 0 || ny < 0 || nx == N || ny == M) continue;
				if (dist[nx][ny] != 0 || miro[nx][ny] == 0) continue;
				dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
				q.offer(new int[] {nx, ny});
			}
		}
		System.out.println(dist[N - 1][M - 1]);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s1 = br.readLine().split(" ");
		int N = Integer.parseInt(s1[0]);
		int M = Integer.parseInt(s1[1]);
		int[][] miro = new int[N][M];
		int[][] dist = new int[N][M];
		for (int i = 0; i < N; i++) {
			String[] s2 = br.readLine().split("");;
			for (int j = 0; j < M; j++) {
				miro[i][j] = Integer.parseInt(s2[j]);
			}
		}
		bfs(N, M, dist, miro);
	}
}


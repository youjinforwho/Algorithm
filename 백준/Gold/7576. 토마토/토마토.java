import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int M = Integer.parseInt(s[0]);
		int N = Integer.parseInt(s[1]);
		int[][] tomato = new int[N][M];
		int[][] dist = new int[N][M];
		Queue<int[]> q = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			String[] s1 = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				tomato[i][j] = Integer.parseInt(s1[j]);
				if (tomato[i][j] == 1) {
					q.add(new int[] {i, j});
					dist[i][j] = 1;
				} else if (tomato[i][j] == -1) dist[i][j] = -1;
				else dist[i][j] = 0;
			}
		}
		int ans = 0;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if (nx < 0 || nx == N || ny < 0 || ny == M) continue;
				if (dist[nx][ny] != 0) continue;
				q.offer(new int[] {nx, ny});
				tomato[nx][ny] = tomato[cur[0]][cur[1]] + 1;
				dist[nx][ny] = 1;
				ans = Math.max(ans, tomato[nx][ny]);
			}
		}
		boolean flag = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tomato[i][j] == 0) {
					System.out.println(-1);
					System.exit(0);
				}
				if (tomato[i][j] > 1) flag = false;
			}
		}
		if (flag)System.out.println(0); 
		else System.out.println(ans - 1);
		
	}
}
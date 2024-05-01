import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		int[] dh = {0, 0, 0, 0, 1, -1};
		int[] dx = {0, 1, 0, -1, 0, 0};
		int[] dy = {1, 0, -1, 0, 0, 0};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int M = Integer.parseInt(s[0]);
		int N = Integer.parseInt(s[1]);
		int H = Integer.parseInt(s[2]);
		
		int[][][] tomato = new int[H][N][M];
		int[][][] dist = new int[H][N][M];
		Queue<int[]> q = new LinkedList<>();
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				String[] s1 = br.readLine().split(" ");
				for (int k = 0; k < M; k++) {
					tomato[i][j][k] = Integer.parseInt(s1[k]);
					if (tomato[i][j][k] == 1) {
						q.add(new int[] {i, j, k});
						dist[i][j][k] = 1;
					} else if (tomato[i][j][k] == -1) dist[i][j][k] = -1;
					else dist[i][j][k] = 0;
				}
			}
		}
		int ans = 0;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 6; i++) {
				int nh = cur[0] + dh[i];
				int nx = cur[1] + dx[i];
				int ny = cur[2] + dy[i];
				if (nh < 0 || nh == H || nx < 0 || nx == N || ny < 0 || ny == M) continue;
				if (dist[nh][nx][ny] != 0) continue;
				q.offer(new int[] {nh, nx, ny});
				tomato[nh][nx][ny] = tomato[cur[0]][cur[1]][cur[2]] + 1;
				dist[nh][nx][ny] = 1;
				ans = Math.max(ans, tomato[nh][nx][ny]);
			}
		}
		boolean flag = true;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (tomato[i][j][k] == 0) {
						System.out.println(-1);
						System.exit(0);
					}
					if (tomato[i][j][k] > 1) flag = false;
				}
			}
		}
		if (flag)System.out.println(0); 
		else System.out.println(ans - 1);
		
	}
}
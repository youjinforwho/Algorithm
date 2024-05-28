import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static char[][] friends;
	static boolean[][] check;
	static int ans = 0;
	public static void bfs(Queue<int[]> q) {
		
		int[] dx = new int[] {0, 0, 1, -1};
		int[] dy = new int[] {1, -1, 0, 0};
		
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = dx[i] + cur[0];
				int ny = dy[i] + cur[1];
				if (nx == N || ny == M || nx == -1 || ny == -1) continue;
				if (check[nx][ny] || friends[nx][ny] == 'X') continue;
				if (friends[nx][ny] == 'P') ans++;
				check[nx][ny] = true;
				q.offer(new int[] {nx, ny});
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		friends = new char[N][M];
		check = new boolean[N][M];
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < N; i++)
		{
			String[] s1 = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				friends[i][j] = s1[j].charAt(0);
				if (friends[i][j] == 'I') {
					q.offer(new int[] {i, j});
					check[i][j] = true;
				}
			}
		}
		bfs(q);
		if (ans == 0)System.out.println("TT");
		else System.out.println(ans);
	}
}


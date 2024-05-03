import java.util.*;
import java.io.*;

public class Main {
	public static Queue<int[]> q = new LinkedList<>();
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	
	public static void bfs_fire(int[][] arr, int[][] check) {
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if (nx == arr.length || ny == arr[0].length || nx < 0 || ny < 0) continue;
				if (arr[nx][ny] == -1 || check[nx][ny] == 1) continue;
				check[nx][ny] = 1;
				arr[nx][ny] = arr[cur[0]][cur[1]] + 1;
				q.offer(new int[] {nx, ny});
			}
		}
	}
	public static void bfs_jihoon(int[][] arr, int[][] check, int[][] fire) {
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if (nx == arr.length || ny == arr[0].length || nx < 0 || ny < 0) continue;
				if (arr[nx][ny] == -1 || check[nx][ny] == 1) continue;
				if (fire[nx][ny] > 0 && arr[cur[0]][cur[1]] + 1 >= fire[nx][ny]) continue;
				check[nx][ny] = 1;
				arr[nx][ny] = arr[cur[0]][cur[1]] + 1;
				q.offer(new int[] {nx, ny});
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s1 = br.readLine().split(" ");
		int R = Integer.parseInt(s1[0]);
		int C = Integer.parseInt(s1[1]);
		int[][] miro = new int[R][C];
		int[][] fire = new int[R][C];
		int[][] check = new int[R][C];
		int[] jihoon = new int[2];
		for (int i = 0; i < R; i++) {
			String[] s2 = br.readLine().split("");
			for (int j = 0; j < C; j++) {
				String s = s2[j];
				if (s.equals("#")) {
					miro[i][j] = -1;
					fire[i][j] = -1;
				}
				if (s.equals("F")) {
					fire[i][j] = 1;
					check[i][j] = 1;
					q.add(new int[] {i, j});
				}
				if (s.equals("J")) {
					if (i == 0 || j == 0 || i == (R - 1) || j == (C - 1)) {
						System.out.println(1);
						System.exit(0);
					}
					jihoon = new int[] {i, j};
					miro[i][j] = 1;
				}
			}
		}
		bfs_fire(fire, check);
		check = new int[R][C];
		check[jihoon[0]][jihoon[1]] = 1;
		q.offer(jihoon);
		bfs_jihoon(miro, check, fire);
		int ans = 2147483647;
		boolean flag = false;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (i == 0 || j == 0 || i == (R - 1) || j == (C - 1)) {
					if (check[i][j] == 1 && miro[i][j] != 0 && miro[i][j] != -1) {
						ans = Math.min(ans, miro[i][j]);
						flag = true;
					}
				} else continue;
			}
		}
		
		if (flag) System.out.println(ans);
		else System.out.println("IMPOSSIBLE");
	}
}
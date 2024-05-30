import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int max;
	static int ans = 0;
	static int cnt = 0;
	
	public static void dfs(int depth, int[][] lab) {
		if (depth == 3) {
			bfs(lab);
			return ;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (lab[i][j] == 0) {
					lab[i][j] = 1;
					dfs(depth + 1, lab);
					lab[i][j] = 0;
				}
			}
		}
	}
	
	public static void bfs(int[][] lab) {
		int[][] lab2 = new int[N][M];
	
		for (int i= 0 ; i < N; i++) {
			for (int j = 0; j < M; j++) {
				lab2[i][j] = lab[i][j];
			}
		}
		Queue<int[]> q = new LinkedList<>();
		int[] dx = new int[] {0, 0, 1, -1};
		int[] dy = new int[] {1, -1, 0, 0};
		boolean[][] check = new boolean[N][M];
		//바이러스 먼저 체크 -2 확산
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (lab2[i][j] == 2 && !check[i][j]) {
					q.offer(new int[] {i, j}); 
					check[i][j] = true;
					while (!q.isEmpty()) {
						int[] cur = q.poll();
						for (int dir = 0; dir < 4; dir++) {
							int nx = dx[dir] + cur[0];
							int ny = dy[dir] + cur[1];
							if (nx == N || nx == -1 || ny == M || ny == -1) continue;
							if (lab2[nx][ny] == 0 && !check[nx][ny]) {
								lab2[nx][ny] = 2;
								check[nx][ny] = true;
								q.offer(new int[] {nx, ny});
							}
						}
					}
					
				}
			}
		}
		

		int area = 0;
		//안전 영역 구하기 - 0 구하기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (lab2[i][j] == 0) {
					area++;
				}
			}
		}
		
		//안전 영역 비교하기
		if (area > ans) ans = area;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		int[][] lab = new int[N][M];
		boolean[][] check = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String[] s1 = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				lab[i][j] = Integer.parseInt(s1[j]);
			}
		}
		
		dfs(0, lab);
		System.out.println(ans);
	}
}
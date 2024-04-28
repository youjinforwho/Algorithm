import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		int[][] board = new int[502][502];
		boolean[][] check = new boolean[502][502];
		int N, M;
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		
		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(line[j]);
			}
		}
		int max = 0; //그림의 최댓값
		int num = 0; //그림의 수
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 0 || check[i][j]) continue;
				num++;
				Queue<int[]> q = new LinkedList<>();
				check[i][j] = true;
				q.add(new int[] {i, j});
				int area = 0;
				while (!q.isEmpty()) {
					area++;
					int[] cur = q.poll();
					for (int dir = 0; dir < 4; dir++) {
						int nx = cur[0] + dx[dir];
						int ny = cur[1] + dy[dir];
						if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
						if (check[nx][ny] || board[nx][ny] != 1) continue;
						check[nx][ny] = true;
						q.add(new int[] {nx, ny});
					}
					max = Math.max(max, area);
				}
			}
		}
		System.out.println(num + "\n" + max);
	}
}
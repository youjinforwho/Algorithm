import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
	static StringBuilder sb = new StringBuilder();
	static int[] dx = new int[] {1, -1, 0, 0, 1, 1, -1, -1};
	static int[] dy = new int[] {0, 0, -1, 1, 1, -1, -1, 1};
	static int w, h;
	static int[][] island;
	
	public static void bfs(int res) {
		boolean[][] check = new boolean[h][w];
		Queue<int[]> q = new LinkedList<>();
		
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (!check[i][j] && island[i][j] == 1) {
					q.offer(new int[] {i, j});
					res++;
					while (!q.isEmpty()) {
						int[] cur = q.poll();
						for (int dir = 0; dir < 8; dir++) {
							int nx = dx[dir] + cur[0];
							int ny = dy[dir] + cur[1];
							if (nx == h || ny == w || nx == -1 || ny == -1) continue;
							if (island[nx][ny] == 1 && !check[nx][ny]) {
								q.offer(new int[] {nx, ny});
								check[nx][ny] = true;
							}
						}
						
					}
				}
			}
		}
		sb.append(res + "\n");
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String[] s = br.readLine().split(" ");
			if (s[0].charAt(0) == '0') break;
			w = Integer.parseInt(s[0]);
			h = Integer.parseInt(s[1]);
			island = new int[h][w];
			for (int i = 0; i < h; i++) {
				String[] s1 = br.readLine().split(" ");
				for (int j = 0; j < w; j++) {
					island[i][j] = Integer.parseInt(s1[j]);
				}
			}
			
			bfs(0);
		}
		System.out.println(sb);
	}
}
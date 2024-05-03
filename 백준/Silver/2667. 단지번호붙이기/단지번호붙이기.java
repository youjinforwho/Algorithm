import java.util.*;
import java.io.*;

public class Main {
	static Queue<int []> q = new LinkedList<>();
	
	public static void bfs(int[][] danji, boolean[][] check) {
		int[] dx = {0, 0, 1, -1};
		int[] dy = {1, -1, 0, 0};
		
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < danji.length; i++) {
			for (int j = 0; j < danji[0].length; j++) {
				if (danji[i][j] == 1 && !check[i][j]) {
					int area = 1;
					q.offer(new int[] {i, j});
					while (!q.isEmpty()) {
						int [] cur = q.poll();
						check[i][j] = true;
						for (int k = 0 ; k < 4; k++) {
							int nx = cur[0] + dx[k];
							int ny = cur[1] + dy[k];
							if (nx == danji.length || ny == danji.length || nx < 0 || ny < 0) continue;
							if (danji[nx][ny] == 0 || check[nx][ny]) continue;
							q.offer(new int[] {nx, ny});
							check[nx][ny] = true;
							area++;
						}
					}
					arr.add(area);
				}
			}
		}
		System.out.println(arr.size());
		Collections.sort(arr);
		for (int a : arr) System.out.println(a);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] danji = new int[N][N];
		boolean[][] check = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				danji[i][j] = Integer.parseInt(s[j]);
			}
		}
		bfs(danji, check);
	}
}
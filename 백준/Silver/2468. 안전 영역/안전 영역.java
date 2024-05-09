import java.util.*;
import java.io.*;

public class Main {
	public static void dfs(boolean[][] check, int[][] area, int N, int x, int y, int standard) {
		if (x + 1 < N && !check[x + 1][y] && area[x + 1][y] > standard) {
			check[x + 1][y] = true;
			dfs(check, area, N, x + 1, y, standard);
		}
		if (x - 1 >= 0 && !check[x - 1][y] && area[x - 1][y] > standard) {
			check[x - 1][y] = true;
			dfs(check, area, N, x - 1, y, standard);
		}
		if (y + 1 < N && !check[x][y + 1] && area[x][y + 1] > standard) {
			check[x][y + 1] = true;
			dfs(check, area, N, x, y + 1, standard);
		}
		if (y - 1 >= 0 && !check[x][y - 1] && area[x][y - 1] > standard) {
			check[x][y - 1] = true;
			dfs(check, area, N, x, y - 1, standard);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] area = new int[N][N];
		int st = 2147483647;
		int ed = -2147483648;
		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				area[i][j] = Integer.parseInt(s[j]);
				if (st > area[i][j]) st = area[i][j];
				if (ed < area[i][j]) ed = area[i][j];
			}
		}
		boolean[][] check;
		int standard;
		int cnt;
		int ans = 0;
		for (int idx = st; idx <= ed; idx++) {
			check = new boolean[N][N];
			standard = idx;
			cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (area[i][j] > idx && !check[i][j]) {
						cnt++;
						check[i][j] = true;
						dfs(check, area, N, i, j, standard);
					}
				}
			}
			if (cnt > ans) ans = cnt;
		}
		if (ans == 0) System.out.println(1);
		else System.out.println(ans);
	}
}
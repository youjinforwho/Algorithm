import java.util.*;
import java.io.*;

public class Main {
	public static void dfs(int N, int x, int y, char[][] arr, boolean[][] check) {
		char color = arr[x][y];
		if (x + 1 < N && !check[x + 1][y] && arr[x + 1][y] == color) {
			check[x + 1][y] = true;
			dfs(N, x + 1, y, arr, check);
		}
		if (x - 1 >= 0 && !check[x - 1][y] && arr[x - 1][y] == color) {
			check[x - 1][y] = true;
			dfs(N, x - 1, y, arr, check);
		}
		if (y + 1 < N && !check[x][y + 1] && arr[x][y + 1] == color) {
			check[x][y + 1] = true;
			dfs(N, x, y + 1, arr, check);
		}
		if (y - 1 >= 0 && !check[x][y - 1] && arr[x][y - 1] == color) {
			check[x][y - 1] = true;
			dfs(N, x, y - 1, arr, check);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] normal = new char[N][N];
		char[][] unique = new char[N][N];
		boolean[][] check1 = new boolean[N][N];
		boolean[][] check2 = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				char a = s.charAt(j);
				if (a == 'R') unique[i][j] = 'G';
				else unique[i][j] = a;
				normal[i][j] = a;
			}
		}
		
		int ans1 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!check1[i][j]) {
					check1[i][j] = true;
					dfs(N, i, j, normal, check1);
					ans1++;
				}
			}
		}
		
		int ans2 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!check2[i][j]) {
					check2[i][j] = true;
					dfs(N, i, j, unique, check2);
					ans2++;
				}
			}
		}
		System.out.println(ans1 + " " + ans2);
	}
}
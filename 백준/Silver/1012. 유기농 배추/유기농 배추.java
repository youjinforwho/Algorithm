import java.util.*;
import java.io.*;

public class Main {
	static int cnt = 0;
	static int[][]arr;
	public static void dfs(int flag, int x, int y, int M, int N) {
		if (arr[x][y] == 1) {
			arr[x][y] = 0;
			if (flag == 0) cnt += 1;
			if (x + 1 < M) dfs(1, x + 1, y, M, N);
			if (y + 1 < N) dfs(1, x, y + 1, M, N);
			if (x - 1 >= 0) dfs(1, x - 1, y, M, N);
			if (y - 1 >= 0) dfs(1, x, y - 1, M, N);
		} else {
			return ;
		}
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();
		
		while (T-- > 0) {
			int M = sc.nextInt();
			int N = sc.nextInt();
			int K = sc.nextInt();
			arr = new int[M][N];
			cnt = 0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = 0;
				}
			}
			while (K-- > 0) {
				int X = sc.nextInt();
				int Y = sc.nextInt();
				arr[X][Y] = 1;
			}
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 1) dfs(0, i, j, M, N);
				}
			}
			sb.append(cnt + "\n");
		}
		System.out.println(sb.toString());
	}
}

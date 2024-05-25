import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[][] tertemino;
	static int max = 0;
	public static void unique(int x, int y) {
		int cnt = 0;
		int[] arr = new int[4];
		if (x + 1 != N) arr[cnt++] = tertemino[x + 1][y];
		if (x - 1 != -1) arr[cnt++] = tertemino[x - 1][y];
		if (y + 1 != M) arr[cnt++] = tertemino[x][y + 1];
		if (y - 1 != -1) arr[cnt++] = tertemino[x][y - 1];
		
		if (cnt < 3) return ;
		Arrays.sort(arr);
		int sum = arr[1] + arr[2] + arr[3] + tertemino[x][y];
		if (max < sum) max = sum;

	}
	
	public static void dfs(int depth, int x, int y, boolean[][] check, int sum) {
		if (depth == 4) {
			if (sum > max) max = sum;
			return;
		}
		check[x][y] = true;
		if (x + 1 != N && !check[x + 1][y]) dfs(depth + 1, x + 1, y, check, sum + tertemino[x + 1][y]);
		if (x - 1 != -1 && !check[x - 1][y]) dfs(depth + 1, x - 1, y, check, sum + tertemino[x - 1][y]);
		if (y + 1 != M && !check[x][y + 1]) dfs(depth + 1, x, y + 1, check, sum + tertemino[x][y + 1]);
		if (y - 1 != -1 && !check[x][y - 1]) dfs(depth + 1, x, y - 1, check, sum + tertemino[x][y - 1]);
		check[x][y] = false;
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		tertemino = new int[N][M];
		boolean[][] check = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				tertemino[i][j] = Integer.parseInt(line[j]);
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dfs(1, i, j, check, tertemino[i][j]);
				unique(i, j);
			}
		}
		System.out.println(max);
	}
	
} 
import java.util.*;
import java.io.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void dfs(int start, int[][] arr, boolean[] check, int depth, int N) {
		if (depth == 0) {
			check[start] = true;
			sb.append((start + 1) + " ");
		}
		if (depth == N) return;
		else {
			for (int i = 0; i < arr.length; i++) {
				if (i != start && arr[start][i] == 1 && !check[i]) {
					check[i] = true;
					sb.append((i + 1) + " ");
					dfs(i, arr, check, depth + 1, N);
				}
			}
		}
	}
	
	public static void bfs(int start, int[][] arr, boolean[] check) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		sb.append((start + 1) + " ");
		check[start] = false;
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 0; i < arr.length; i++) {
				if (i == cur || arr[cur][i] == 0 || !check[i]) continue;
				sb.append((i + 1) + " ");
				q.offer(i);
				check[i] = false;
			}
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s1 = br.readLine().split(" ");
		int N = Integer.parseInt(s1[0]);
		int M = Integer.parseInt(s1[1]);
		int V = Integer.parseInt(s1[2]);
		
		int[][] arr = new int[N][N];
		boolean[] check = new boolean[N];
		for (int i = 0; i < M; i++) {
			String[] s2 = br.readLine().split(" ");
			int x = Integer.parseInt(s2[0]) - 1;
			int y = Integer.parseInt(s2[1]) - 1;
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		
		dfs(V - 1, arr, check, 0, N);
		sb.append("\n");
		bfs(V - 1, arr, check);
		System.out.println(sb);
	}
}
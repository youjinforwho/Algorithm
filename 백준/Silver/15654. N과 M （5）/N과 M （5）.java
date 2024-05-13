import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] arr;
	public static void dfs(int depth, int M, int[] pick, boolean[] check) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(pick[i] + " ");
			}
			sb.append("\n");
			return ;
		}

		for (int i = 0; i < N; i++) {
			if (!check[i]) {
				check[i] = true;
				pick[depth] = arr[i];
				dfs(depth + 1, M, pick, check);
				check[i] = false;
			}
		}
	}
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s1 = br.readLine().split(" ");
		N = Integer.parseInt(s1[0]);
		M = Integer.parseInt(s1[1]);
		
		String[] s2 = br.readLine().split(" ");
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(s2[i]);
		}
		Arrays.sort(arr);
		boolean[] check = new boolean[N];
		int[] pick = new int[M];
		dfs(0, M, pick, check);
		System.out.println(sb);
	}
}

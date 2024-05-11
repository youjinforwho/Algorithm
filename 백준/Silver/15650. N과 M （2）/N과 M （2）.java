import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
	public static void dfs(int start, int depth, int M, int[] pick, boolean[] check) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(pick[i] + " ");
			}
			sb.append("\n");
			return ;
		}

		for (int i = start; i < check.length; i++) {
			if (!check[i]) {
				check[i] = true;
				pick[depth] = i + 1;
				dfs(i + 1, depth + 1, M, pick, check);
				check[i] = false;
			}
		}
	}
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		boolean[] check = new boolean[N];
		int[] pick = new int[M];
		dfs(0, 0, M, pick, check);
		System.out.println(sb);
	}
}

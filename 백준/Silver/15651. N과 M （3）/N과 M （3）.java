import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
	public static void dfs(int depth, int M, int[] pick) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(pick[i] + " ");
			}
			sb.append("\n");
			return ;
		}

		for (int i = 0; i < N; i++) {
			pick[depth] = i + 1;
			dfs(depth + 1, M, pick);
		}
	}
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		int[] pick = new int[M];
		dfs(0, M, pick);
		System.out.println(sb);
	}
}

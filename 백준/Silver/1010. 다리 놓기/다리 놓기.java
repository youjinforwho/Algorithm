import java.util.*;
import java.io.*;

public class Main {
	static int[][] dp = new int[30][30];
	
	public static int combination(int n, int r) {
		if (dp[n][r] > 0 ) return dp[n][r];
		if (n == r || r == 0) return dp[n][r] = 1;
		return dp[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
	}
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			String[] s = br.readLine().split(" ");
			int N = Integer.parseInt(s[0]);
			int M = Integer.parseInt(s[1]);
			
			sb.append(combination(M, N)+"\n");
		}
		System.out.println(sb);
	}
	
} 
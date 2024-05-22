import java.util.*;
import java.io.*;

public class Main {
	static int[][] arr;
	static int n, res, t;
	static boolean[] check;
	public static void dfs(int depth, int start) {
		if (depth == t) {
			res = Math.min(res, diff());
			if (res == 0) {
				System.out.println(res);
				System.exit(0);
			}
			return ;
		}
		
		for (int i = start; i < n; i++) {
			if (!check[i]) {
				check[i] = true;
				dfs(depth + 1, i + 1);
				check[i] = false;
			}
		}
	}
	
	public static int diff() {
		int start = 0;
		int link = 0;
		
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (check[i] && check[j]) start += (arr[i][j] + arr[j][i]);
				else if (!check[i] && !check[j]) link += (arr[i][j] + arr[j][i]);
			} 
		}
		return Math.abs(start - link);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		check = new boolean[n];
		res = 2147483647;
		t = 0;
		
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		for (t = 1; t < n; t++) dfs(0, 0);
		System.out.println(res);
	}
	
} 
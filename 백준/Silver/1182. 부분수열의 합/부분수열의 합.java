import java.util.*;
import java.io.*;

public class Main {
	static int res = 0;
	static boolean[] check;
	static int[] arr;
	static int N, S;
	
	public static void dfs(int depth, int pick, int st, int sum) {
		//if (sum > S) return ;
		if (depth == pick) {
			if (sum == S) res++;
			return ;
		}
		for (int i = st; i < N; i++) {
			if (!check[i]) {
				check[i] = true;
				dfs(depth + 1, pick, i + 1, sum + arr[i]);
				check[i] = false;
				
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s1 = br.readLine().split(" ");
		N = Integer.parseInt(s1[0]);
	    S = Integer.parseInt(s1[1]);
		arr = new int[N];
		check = new boolean[N];
		
	    String[] s2 = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(s2[i]);
		}
		for (int i = 1; i <= N; i++) {
			dfs(0, i, 0, 0);
		}
		System.out.println(res);
		
		
	}
	
} 
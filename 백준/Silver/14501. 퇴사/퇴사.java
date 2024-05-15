import java.util.*;
import java.io.*;

public class Main {
	public static int res = 0;
	public static int[] money;
	
	public static void dfs(int start, int N, boolean[] check, int[] arr) {
		if (start >= N - 1) {
			int mon = 0;
			int last = 0;
			for (int i = 0; i < N; i++) {
				if (check[i]) {
					mon += money[i];
					last = money[i];
				}
			}
			if (start >= N) mon -= last;
			if (res < mon) res = mon;
			return;
		}

		for (int i = start + 1; i < N; i++) {
			if (!check[i]) {
				check[i] = true;
				dfs(arr[i], N, check, arr);
				check[i] = false;
			}
		}
		
	}
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		money = new int[N];
		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			arr[i] = i + Integer.parseInt(s[0])- 1;
			money[i] = Integer.parseInt(s[1]);
		}
		boolean[] check = new boolean[N];
		dfs(-1, N, check, arr);
		System.out.println(res);
    }
}

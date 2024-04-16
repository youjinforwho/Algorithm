import java.util.*;

public class Main {
	public static int res;
	public static Set<Integer> set = new HashSet<>();
	public static void dfs(int toFind, int[][] arr, int cnt) {
		if (cnt == 2) return; 
		for (int i = 0; i < arr.length; i++) {
			if (arr[toFind][i] == 1) {
				arr[toFind][i] = 0;
				arr[i][toFind] = 0;
				set.add(i);
				dfs(i, arr, cnt + 1);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		int m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		res = 0;
		dfs(0, arr, 0);
		System.out.println(set.size());
		sc.close();
	}
}

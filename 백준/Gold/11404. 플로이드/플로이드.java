import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int[][] table = new int[n][n];
		for (int i = 0; i < n; i++) Arrays.fill(table[i], 2147483647);
		for (int i = 0; i < n; i++) {
			table[i][i] = 0;
		}
		for (int i = 0; i < m; i++) {
			String[] s = br.readLine().split(" ");
			int x = Integer.parseInt(s[0]) - 1;
			int y = Integer.parseInt(s[1]) - 1;
			int dist = Integer.parseInt(s[2]);
			table[x][y] = Math.min(dist, table[x][y]);
		}
		
		for (int i = 0; i < n; i ++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (table[j][i] != 2147483647 && table[i][k] != 2147483647) table[j][k] = Math.min(table[j][k], table[j][i] + table[i][k]);
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (table[i][j] != 2147483647) sb.append(table[i][j] + " ");
				else sb.append("0 ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
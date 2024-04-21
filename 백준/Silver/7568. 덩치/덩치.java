import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(s[0]);
			arr[i][1] = Integer.parseInt(s[1]);
		}
		int[] rank = new int[N];
		for (int i = 0; i < N; i++) {
			rank[i] = N;
			for (int j = 0; j < N; j++) {
				if (j != i && arr[i][0] >= arr[j][0]) rank[i] = rank[i] - 1;
			}
			for (int j = 0; j < N; j++) {
				if (j != i && arr[i][0] < arr[j][0] && arr[i][1] >= arr[j][1]) rank[i] = rank[i] - 1;
			}
		}
		for (int r : rank) System.out.print(r + " ");
	}
}


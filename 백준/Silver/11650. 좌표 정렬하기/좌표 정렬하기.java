import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		for (int i =  0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(s[0]);
			arr[i][1] = Integer.parseInt(s[1]);
		}
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) return (a[1] - b[1]);
                else return (a[0] - b[0]);
            }
		});
		for (int i = 0; i < N; i++) sb.append(arr[i][0] + " " + arr[i][1] + "\n");
		System.out.println(sb);
	}
}


import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[][] = new int[N][2];
		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(s[0]);
			arr[i][1] = Integer.parseInt(s[1]);
		}
		Arrays.sort(arr, Comparator.comparingInt((int[]a) -> a[1]).thenComparingInt(a -> a[0]));
		int endTime = arr[0][1];
		int cnt = 1;
		for (int i = 1; i < N; i++) {
			int startTime = arr[i][0];
			if (startTime >= endTime) {
				endTime = arr[i][1];
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}

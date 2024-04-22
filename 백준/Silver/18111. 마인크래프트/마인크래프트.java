import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int B = Integer.parseInt(s[2]);
		int[] arr = new int[N * M];
		int idx = 0;
		for (int i = 0; i < N; i++) {
			String[] s1 = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				arr[idx++] = Integer.parseInt(s1[j]);
			}
		}
		Arrays.sort(arr);
		int min_time = 2147483647;
		int high = -2147483648;
		for (int i = arr[0]; i <= arr[arr.length - 1]; i++) {
			int temp_time = 0;
			int inven = B;
			for (int j = 0; j < N * M; j++) {
				if (i < 0 || i > 256) {
					inven = -1;
					break;
				}
				if (arr[j] > i) {
					temp_time += (2 * (arr[j] - i));
					inven += (arr[j] - i);
				} else {
					temp_time += (i - arr[j]);
					inven -= (i - arr[j]);
				}
			}
			if (inven >= 0 && temp_time <= min_time) {
				if (temp_time == min_time) {
					high = (high > i) ? high : i;
				}
				else {
					min_time = temp_time;
					high = i;
				}
				
			}
		}
		System.out.println(min_time + " " + high);
	}
}


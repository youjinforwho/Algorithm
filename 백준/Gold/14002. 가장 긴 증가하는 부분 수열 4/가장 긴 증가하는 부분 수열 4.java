import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		int[] arr = new int[N];
		int[] dp = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(s[i]);
		}
		int max = 0;
		int init = 0;
		int len = 0;
		for (int i = 0; i < N; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && dp[i] < dp[j] + 1) dp[i] = dp[j] + 1;
 			}
			if (max < dp[i]) {
				max = dp[i];
				init = arr[i] + 1;
			}
		}
		len = max;
		int[] res = new int[max];
//		res[len--] = init;
		for (int i = N - 1; i >= 0; i--) {
			if (dp[i] == len && arr[i] < init) {
				res[--len] = arr[i];
				init = arr[i];
			}
		}
		sb.append(max+"\n");
		for (int i = 0; i < max; i++) sb.append(res[i] + " ");
		System.out.println(sb);
	}
	
} 
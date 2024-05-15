import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		String[] line = br.readLine().split(" ");
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(line[i]);
		}
		
		int max = 0;
		int[] dp = new int[N];
		for (int i = 0; i < N; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && dp[i] < dp[j] + 1) dp[i] = dp[j] + 1;
			}
			if (max < dp[i]) max = dp[i];
		}
		System.out.println(max);
		
	}
}

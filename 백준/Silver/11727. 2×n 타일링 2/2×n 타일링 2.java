import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		int[] dp = new int[1001];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 3;
		for (int i = 3; i <= 1000; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
		}
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.println(dp[n]);
		sc.close();
	}
}


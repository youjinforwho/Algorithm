import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans;
		
		int[][] RGB = new int[N][3];
		int[][] dp = new int[N][3];
		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			RGB[i][0] = Integer.parseInt(s[0]);
			RGB[i][1] = Integer.parseInt(s[1]);
			RGB[i][2] = Integer.parseInt(s[2]);
		}
		
		//N이 3 이하인 경우 
		if (N == 2) {
			dp[1][0] = Math.min(RGB[0][1],RGB[0][2]) + RGB[1][0];
			dp[1][1] = Math.min(RGB[0][0],RGB[0][2]) + RGB[1][1];
			dp[1][2] = Math.min(RGB[0][0],RGB[0][1]) + RGB[1][2];
			System.out.println(Math.min(Math.min(dp[1][0], dp[1][1]), dp[1][2]));
			System.exit(0);
		}
		
		if (N == 3) {
			dp[2][0] = Math.min(RGB[0][1] + RGB[1][2], RGB[0][2] + RGB[1][1]) + RGB[2][0];  
			dp[2][1] = Math.min(RGB[0][0] + RGB[1][2], RGB[0][2] + RGB[1][0]) + RGB[2][1];
			dp[2][2] = Math.min(RGB[0][0] + RGB[1][1], RGB[0][1] + RGB[1][0]) + RGB[2][2];
			System.out.println(Math.min(Math.min(dp[2][0], dp[2][1]), dp[2][2]));
			System.exit(0);
		}
		
		//1번 집이 R인 경우 (RG, RB)
		dp[2][0] = Math.min(RGB[1][1], RGB[1][2]) + RGB[0][0] + RGB[2][0]; //RGR, RBR 
		dp[2][1] = RGB[1][2] + RGB[0][0] + RGB[2][1]; //RBG
		dp[2][2] = RGB[1][1] + RGB[0][0] + RGB[2][2]; //RGB
		
		for (int i = 3; i < N - 1; i++) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + RGB[i][0]; //R
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + RGB[i][1]; //G
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + RGB[i][2]; //B
		}
		dp[N - 1][1] = Math.min(dp[N - 2][0], dp[N - 2][2]) + RGB[N - 1][1];
		dp[N - 1][2] = Math.min(dp[N - 2][0], dp[N - 2][1]) + RGB[N - 1][2];
		ans = Math.min(dp[N - 1][1], dp[N - 1][2]);
		
		//1번 집이 G인 경우 (GR, GB)
		dp[2][0] = RGB[1][2] + RGB[0][1] + RGB[2][0]; //GBR
		dp[2][1] = Math.min(RGB[1][0], RGB[1][2]) + RGB[0][1] + RGB[2][1]; //GRG, GBG
		dp[2][2] = RGB[1][0] + RGB[0][1] + RGB[2][2]; //GRB
		
		for (int i = 3; i < N - 1; i++) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + RGB[i][0];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + RGB[i][1];
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + RGB[i][2];
		}
		dp[N - 1][0] = Math.min(dp[N - 2][1], dp[N - 2][2]) + RGB[N - 1][0];
		dp[N - 1][2] = Math.min(dp[N - 2][0], dp[N - 2][1]) + RGB[N - 1][2];
		ans = Math.min(Math.min(dp[N - 1][0], dp[N - 1][2]), ans);
		
		//1번 집이 B인 경우 (BR, BG)
		dp[2][0] = RGB[1][1] + RGB[0][2] + RGB[2][0]; //BGR
		dp[2][1] = RGB[1][0] + RGB[0][2] + RGB[2][1]; //BRG
		dp[2][2] = Math.min(RGB[1][0], RGB[1][1]) + RGB[0][2] + RGB[2][2]; //BRB, BGB
		
		for (int i = 3; i < N - 1; i++) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + RGB[i][0];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + RGB[i][1];
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + RGB[i][2];
		}
		dp[N - 1][0] = Math.min(dp[N - 2][1], dp[N - 2][2]) + RGB[N - 1][0];
		dp[N - 1][1] = Math.min(dp[N - 2][0], dp[N - 2][2]) + RGB[N - 1][1];
		ans = Math.min(Math.min(dp[N - 1][0], dp[N - 1][1]), ans);
		System.out.println(ans);
		
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.w3c.dom.ls.LSOutput;

public class Main {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];
    int[] dp = new int[N];
    String[] s = br.readLine().split(" ");
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(s[i]);
      dp[i] = 1;
    }
    int max = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < i; j++) {
        if (arr[i] < arr[j]) {
          dp[i] = Math.max(dp[i], 1 + dp[j]);
        }
      }
      max = Math.max(max, dp[i]);
    }
    System.out.println(max);
  }
}
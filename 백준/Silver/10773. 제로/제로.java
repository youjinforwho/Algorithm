import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int res = 0;
		for (int i = 0; i < K; i++) {
			int N = Integer.parseInt(br.readLine());
			if (N == 0) res -= stack.pop();
			else {
				stack.push(N);
				res += N;
			}
		}
		System.out.println(res);
	}
}


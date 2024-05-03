import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		int[] atm = new int[N];
		for (int i = 0; i < N; i++) {
			atm[i] = Integer.parseInt(s[i]);
		}
		Arrays.sort(atm);
		int res = 0;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += atm[i];
			res += sum;
		}
		System.out.println(res);
	}
}
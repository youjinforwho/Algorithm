import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String S = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		sb.append("I");
		for (int i = 0; i < N; i++) {
			sb.append("OI");
		}
		int cnt = 0;
		String P = sb.toString();
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			if (c == P.charAt(0) && i + P.length() <= S.length()) {
				boolean flag = true;
				for (int j = 0; j < P.length(); j++) {
					if (S.charAt(i + j) != P.charAt(j)) flag = false;
				}
				if (flag) cnt++;
			}
		}
		System.out.println(cnt);
	}
	
} 
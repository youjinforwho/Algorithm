import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			boolean flag = true;
			String S = br.readLine();
			if (S.equals("0")) break;
			for (int i = 0; i < (S.length() / 2); i++) {
				if (S.charAt(i) != S.charAt(S.length() - 1 - i)) {
					flag = false;
					break;
				}
			}
			if (flag) System.out.println("yes");
			else System.out.println("no");
		}
	}
}

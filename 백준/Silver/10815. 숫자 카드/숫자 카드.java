import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		String[] card = br.readLine().split(" ");
		LinkedHashSet<String> set = new LinkedHashSet<>();
		for (String c: card) set.add(c);
		int M = Integer.parseInt(br.readLine());
		String[] sangeun = br.readLine().split(" ");
		for (String s : sangeun) {
			if (set.contains(s)) sb.append("1 ");
			else sb.append("0 ");
		}
		System.out.println(sb);
	}
}
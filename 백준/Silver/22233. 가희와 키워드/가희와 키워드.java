import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		HashSet<String> keyword = new HashSet<>();
		for (int i = 0; i < N; i++) {
			keyword.add(br.readLine());
		}
		int total = N;
		for (int i = 0; i < M; i++) {
			String[] line = br.readLine().split(",");
			for (int j = 0; j < line.length; j++) {
				if (keyword.contains(line[j])) {
					keyword.remove(line[j]);
					total -= 1;
				}
			}
			sb.append(total + "\n");
		}
		System.out.println(sb);
	}
}
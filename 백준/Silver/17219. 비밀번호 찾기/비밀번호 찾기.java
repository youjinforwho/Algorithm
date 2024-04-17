import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		HashMap<String, String> map = new HashMap<>();
		while (N-- > 0) {
			String[] line = br.readLine().split(" ");
			map.put(line[0], line[1]);
		}
		while (M-- > 0) {
			String toFind = br.readLine();
			sb.append(map.get(toFind) + "\n");
		}
		System.out.println(sb);
	}
}

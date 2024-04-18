import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> map = new HashMap<>();
		while (N-- > 0) {
			String S = br.readLine();
			map.put(S, S.length());
		}
		List<String> words = new ArrayList<>(map.keySet());
		Collections.sort(words, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() == o2.length()) {
					return o1.compareTo(o2);
				}
				return o1.length() - o2.length();
			}
		});
		for (String s: words) sb.append(s + "\n");
		System.out.println(sb);
	}
}

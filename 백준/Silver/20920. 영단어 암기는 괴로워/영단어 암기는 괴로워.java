import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> map = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			if (s.length() >=  M) map.put(s, map.getOrDefault(s, 0) + 1);
		}
		
		List<String> words = new ArrayList<>(map.keySet());
		
		Collections.sort(words, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if (Integer.compare(map.get(o1), map.get(o2)) != 0) {
					return Integer.compare(map.get(o2), map.get(o1));
				}
				if (o1.length() != o2.length()) {
					return o2.length() - o1.length();
				}
				return o1.compareTo(o2);
			}
			
		});
		
		StringBuilder sb = new StringBuilder();
		for (String s: words) sb.append(s + "\n");
		System.out.println(sb.toString());
	}
}

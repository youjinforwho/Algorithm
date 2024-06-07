import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String[] s = br.readLine().split(" ");
		int[] tanghuru = new int[N];
		for (int i = 0; i < N; i++) {
			tanghuru[i] = Integer.parseInt(s[i]);
		}

		int max = 0, start = 0;
		HashMap<Integer, Integer> countMap = new HashMap<>();
		
		for (int end = 0; end < N; end++) {
			countMap.put(tanghuru[end], countMap.getOrDefault(tanghuru[end], 0) + 1);
			
			while (countMap.size() > 2) {
				countMap.put(tanghuru[start], countMap.get(tanghuru[start]) - 1);
				if (countMap.get(tanghuru[start]) == 0) {
					countMap.remove(tanghuru[start]);
				}
				start++;
			}
			
			max = Math.max(max, end - start + 1);
		}
		
		System.out.println(max);
	}
}
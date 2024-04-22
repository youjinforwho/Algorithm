import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		HashMap<String, Integer> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		ArrayList<String> arr = new ArrayList<>();
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		for (int i = 0; i < N; i++) {
			String poketmon = br.readLine();
			map.put(poketmon, i + 1);
			arr.add(poketmon);
		}
		
		for (int i = 0; i < M; i++) {
			String toFind = br.readLine();
			try {
	            int intValue = Integer.parseInt(toFind);
	            sb.append(arr.get(intValue - 1) + "\n");
	        } catch (NumberFormatException e) {
	        	sb.append(map.get(toFind) + "\n");
	        }
			
		}
		System.out.println(sb);
	}
}


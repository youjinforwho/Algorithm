import java.io.*;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String line = br.readLine();
			String[] arr = line.split("");
			Stack<String> s = new Stack<>();
			for (int j = 0; j < arr.length; j++) {
				if (arr[j].compareTo(")") == 0) {
					if (!s.isEmpty() && (s.peek().compareTo("(")) == 0) {
						s.pop();
					} else {
						s.push(arr[j]);
						break;
					}
				}
				else {
					s.push(arr[j]);
				}
			}
			if (s.isEmpty()) {
				System.out.println("YES");
			} else System.out.println("NO");
		}
	}
}

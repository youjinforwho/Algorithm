import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			HashMap<String, Integer> map = new HashMap<>();
			int n = sc.nextInt();
			if (n == 0) System.out.println(0);
			else {
				for (int j = 0; j < n; j++) {
					sc.next();
					String temp = sc.next();
					if (map.containsKey(temp)) {
						map.put(temp, map.get(temp) + 1);
					}
					else {
						map.put(temp, 1);
					}
					sc.nextLine();
				}
				int res = 1;
				for (String s: map.keySet()) {
					res *= (map.get(s) + 1);
				}
				System.out.println(res - 1);
			}
		}
		sc.close();
	}
}

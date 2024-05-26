import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		

		for (int s = 0; s < T; s++) {

			boolean check = false;
			int M = sc.nextInt();
			int N = sc.nextInt();
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;

			for (int i = x; i < (N * M); i += M) {
				if (i % N == y) {
					System.out.println(i + 1);
					check = true;
					break;
				}
			}

			if (!check) {
				System.out.println(-1);

			}
		}
	}
}
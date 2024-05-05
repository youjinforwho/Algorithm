import java.io.*;

public class Main {
	public static int white = 0;
	public static int blue = 0;
	public static void divide(int[][] arr, int x, int y, int N) {
		int check = arr[x][y];
		boolean flag = true;
		for (int i = x; i < x + N; i++) {
			for (int j = y; j < y + N; j++) {
				if (arr[i][j] != check) {
					flag = false;
					break;
				}
			}
			if (!flag) break;
		}
		if (!flag) {
			N /= 2;
			divide(arr, x, y, N);
			divide(arr, x + N, y, N);
			divide(arr, x, y + N, N);
			divide(arr, x + N, y + N, N);
		} else {
			if (check == 1) blue += 1;
			else white += 1;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(s[j]);
			}
		}
		divide(arr, 0, 0, N);
		System.out.println(white);
		System.out.println(blue);
	}
	
}
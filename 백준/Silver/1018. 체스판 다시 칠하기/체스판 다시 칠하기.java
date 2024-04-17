import java.util.*;
import java.io.*;

public class Main {
	public static int check(char[][] arr, int x, int y) {
		char A;
		int cnt1 = 0;
		int cnt2 = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i % 2 == 0) {
					if (j % 2 == 0) A = 'B';
					else A = 'W';
				} else {
					if (j % 2 == 0) A = 'W';
					else A = 'B';
				}
				if (arr[x + i][y + j] != A) cnt1 += 1;
			}
		}
		
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i % 2 == 0) {
					if (j % 2 == 0) A = 'W';
					else A = 'B';
				} else {
					if (j % 2 == 0) A = 'B';
					else A = 'W';
				}
				if (arr[x + i][y + j] != A) cnt2 += 1;
			}
		}
		return ((cnt1 < cnt2)? cnt1 : cnt2);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		char[][] arr = new char[N][M];
		for (int i = 0; i < N; i++) {
			String s1 = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = s1.charAt(j);
			}
		}
		int min = 2147483647;
		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				int temp = check(arr, i, j);
				if (min > temp) min = temp;
			}	
		}
		System.out.println(min);
	}
}

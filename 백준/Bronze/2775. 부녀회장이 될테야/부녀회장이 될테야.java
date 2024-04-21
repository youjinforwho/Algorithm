import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		int[][] arr = new int[15][15];
		for (int i = 1; i < 15; i++) arr[0][i] = i;
		for (int i = 1; i < 15; i++) {
			for (int j = 1; j < 15; j++) {
				int sum = 0;
				for (int k = 1; k <= j; k++) {
					sum += arr[i-1][k];
				}
				arr[i][j] = sum;
			}
		}
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			System.out.println(arr[k][n]);
		}
		sc.close();
	}
}


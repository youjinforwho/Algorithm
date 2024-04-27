import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Main {
	public static int cnt = 0;
	public static void divide(int row, int col, int size) {
		if (size == 1) return;
		int num = size / 2;
		if (row < size / 2 && col < size / 2) divide(row, col, size/ 2);
		else if(row < num && col >= num) {
			cnt += (size * size) / 4;
			divide(row, col - size / 2, num);
		}
		else if (row >= num && col < num) {
			cnt += (size * size) / 4 * 2;
			divide(row - size / 2, col, num);
		}
		else if (row >= num && col >= num) {
			cnt += (size * size) / 4 * 3;
			divide(row - size / 2, col - size / 2, num);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int r = Integer.parseInt(s[1]);
		int c = Integer.parseInt(s[2]);
		
		int size = (int)Math.pow(2, N);
		divide(r, c, size);
		System.out.println(cnt);
	}
}
 
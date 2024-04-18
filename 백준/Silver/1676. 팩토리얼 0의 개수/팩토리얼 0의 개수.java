import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int num_2 = 0;
		int num_5 = 0;
		
		for (int i = 1; i <= N; i++) {
			int temp = i;
			while (temp != 0 && temp % 10 == 0) {
				temp /= 10;
				num_2 += 1;
				num_5 += 1;
			}
			while (temp != 0 && temp % 5 == 0) {
				temp /= 5;
				num_5 += 1;
			}
			while (temp != 0 && temp % 2 == 0) {
				temp /= 2;
				num_2 += 1;
			}
		}
		System.out.println((num_2 > num_5)? num_5:num_2);
	}
}

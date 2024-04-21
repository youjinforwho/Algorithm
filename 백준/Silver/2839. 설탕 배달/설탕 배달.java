import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int kg_5 = N / 5;
		int kg_3 = 0;
		boolean flag = false;
		while (kg_5 >= 0) {
			kg_3 = (N - kg_5 * 5) / 3;
			if (kg_5 * 5 + kg_3 * 3 == N) {
				flag = true;
				break;
			}
			kg_5--;
		}
		if (flag) System.out.println(kg_3 + kg_5);
		else System.out.println(-1);
	}
}


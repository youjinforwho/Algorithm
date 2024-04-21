import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		sc.nextLine();
		String s = sc.nextLine();
		long hash = 0;
		for (int i = 0; i < L; i++) {
			char A = s.charAt(i);
			hash += ((int)A - 96) * Math.pow(31, i);
		}
		System.out.println(hash % 1234567891);
		sc.close();
	}
}


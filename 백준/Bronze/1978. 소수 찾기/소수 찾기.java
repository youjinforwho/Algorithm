import java.util.*;
import java.io.*;

public class Main {
	public static boolean isPrime(int N) {
		if (N == 1) return false;
		for (int i = 2; i * i <= N; i++) {
			if (N % i == 0) return false;
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (isPrime(sc.nextInt())) cnt++;
		}
		System.out.println(cnt);
		sc.close();
	}
}

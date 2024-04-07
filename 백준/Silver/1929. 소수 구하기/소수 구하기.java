import java.util.*;

public class Main {
	
	public static boolean isPrime(int num) {
		boolean flag = true;
		if (num == 1) {
			return false;
		}
		else {
			for (int i = 2; i * i <= num; i++) {
				if (num % i == 0) {
					flag = false;
				}
			}
		}
		return flag;
	}
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        for (int i = M; i <= N; i++) {
        	if (isPrime(i) == true) {
        		System.out.println(i);
        	}
        }
        sc.close();
    }
}

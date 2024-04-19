import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int min = (num1 > num2)? num2 : num1;
		int max = (num1 > num2)? num1 : num2;
		int res1 = 0;
		int res2 = 0;
		for (int i  = 1; i <= min; i++) {
			if (min % i == 0 && max % i == 0) res1 = i;
		}
		for (int i = 1; i <= min; i++) {
			if ((i * max) % min == 0) {
				res2 = i * max;
				break;
			}
		}
		System.out.println(res1+"\n"+res2);
	}
}

import java.util.Scanner;

class Main {
	
	public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int min = 2147483647;
        int max = -2147483648;
        
        for (int i = 0; i < num; i++) {
        	int comp = sc.nextInt();
        	if (i == 0) {
        		min = comp;
        		max = comp;
        	}
        	else {
        		if (min > comp) {
        			min = comp;
        		}
        		if (max < comp) {
        			max = comp;
        		}
        	}
        }
        sc.close();
        System.out.println(min + " " + max);
	}
}
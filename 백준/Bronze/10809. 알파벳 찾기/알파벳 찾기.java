import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char character = 'a';
        String S = sc.nextLine();
        for (int i = 0; i < 26; i++) {
        	System.out.print(S.indexOf((char)(character + i)) + " ");
        }
        sc.close();
        
    }
}

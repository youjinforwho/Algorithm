import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int total_price = sc.nextInt();
        int stuff_cnt = sc.nextInt();
        int calculate = 0;
        
        for (int i = 0; i < stuff_cnt; i++) {
            int price = sc.nextInt();
            int cnt = sc.nextInt();
            calculate += price * cnt;
        }
        if (calculate == total_price) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}
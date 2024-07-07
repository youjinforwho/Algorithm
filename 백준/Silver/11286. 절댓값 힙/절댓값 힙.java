import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);

            if(abs1 == abs2) return o1 > o2 ? 1 : -1;
            return abs1 - abs2;
        });

        while (N-- > 0) {
            int val = Integer.parseInt(br.readLine());
            if(val == 0){
                if(queue.isEmpty()) sb.append("0\n");
                else sb.append(queue.poll() + "\n");
            }else{
                queue.add(val);
            }
        }
        System.out.println(sb);
    }
}
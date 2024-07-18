import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] line = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);

            line[i][0] = x;
            line[i][1] = y;
        }
        Arrays.sort(line, (o1, o2) -> {
           if (o1[0] == o2[0]) {
               return o1[1] - o2[1];
           }
           return o1[0] - o2[0];
        });

        int prev_X = line[0][0];
        int prev_Y = line[0][1];
        int sum = prev_Y - prev_X;
        if (N == 1) {
            System.out.println(sum);
            System.exit(0);
        }
        for (int i = 1; i < N; i++) {
            int cur_X = line[i][0];
            int cur_Y = line[i][1];

            // 겹치는 경우
            if (prev_Y >= cur_Y) continue;

            // 겹치지만 끝은 더 긴 경우 => 차이만 더해준다
            if (prev_Y > cur_X && prev_Y < cur_Y) {
                sum += (cur_Y - prev_Y);
            }

            // 겹치지 않는 경우 => 그냥 더해줌
            if (prev_Y <= cur_X) {
                sum += (cur_Y - cur_X);
            }
            prev_Y = cur_Y;
        }
        System.out.println(sum);

    }
}
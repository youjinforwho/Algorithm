import java.io.*;

public class Main {
    //1부터 11까지 순서 안겹치게 11개 뽑기
    //뽑는 중간에 0인 값 있으면 안뽑기
    static int[][] league;
    static int res = 0;
    public static void backtracking(int depth, boolean[] check, int sum) {
        if (depth == 11) {
            //TODO : max랑 비교 후 sum값이 클 경우 결과 저장
            if (sum > res) res = sum;
            return ;
        }
        for (int i = 0; i < 11; i++) {
            if (!check[i] && league[depth][i] != 0) {
                check[i] = true;
                backtracking(depth + 1, check, sum + league[depth][i]);
                check[i] = false;

            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());
        league = new int[11][11];
        while (C-- > 0){
            for (int i = 0; i < 11; i++) {
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < 11; j++) {
                    league[i][j] = Integer.parseInt(line[j]);
                }
            }
            res = 0; //값 초기화
            boolean[] check = new boolean[11];
            backtracking(0, check, 0);
            System.out.println(res);
        }


    }
}
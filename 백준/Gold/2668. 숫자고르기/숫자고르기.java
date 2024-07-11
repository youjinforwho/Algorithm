import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static HashMap<Integer, Integer> map = new HashMap<>();
    static int N;
    static HashSet<Integer> set = new HashSet<>();
    public static void dfs(int init, int target, boolean[] check) {
        if (map.get(target) == init) {
            for (int i = 1; i<= N; i++) {
                if (check[i]) set.add(i);
            }
            return ;
        } else {
            if (!check[map.get(target)]) {
                check[map.get(target)] = true;
                dfs(init, map.get(target), check);
                check[map.get(target)] = false;
            }
            return ;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            map.put(i, Integer.parseInt(br.readLine()));
        }
        boolean[] check = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            check[i] = true;
            dfs(i, i, check);
            check[i] = false;
        }
        sb.append(set.size() + "\n");
        for (int i = 1; i <= N; i++) {
            if (set.contains(i)) sb.append(i + "\n");
        }
        System.out.println(sb);

    }

}
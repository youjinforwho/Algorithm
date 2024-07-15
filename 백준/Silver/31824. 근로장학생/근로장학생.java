import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        HashMap<String, String> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            String[] s1 = br.readLine().split(" ");
            map.put(s1[0], s1[1]);
        }
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        while (M-- > 0) {
            String S = br.readLine();
            boolean flag = false;
            for (int idx = 0; idx < S.length(); idx++) {
                for (String str : list) {
                    if (S.indexOf(str, idx) == idx) {
                        flag = true;
                        sb.append(map.get(str));
                    }
                }
            }
            if (flag) sb.append("\n");
            else sb.append("-1\n");
        }

        System.out.println(sb);
    }

}
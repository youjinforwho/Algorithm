import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            q.add((int)Math.ceil((100.0 - progresses[i]) / speeds[i]));
        }
        int bef_max = 0;
        int cnt = 0;
        boolean flag = false;
        while (!q.isEmpty()) {
            int num = q.poll();
            if (!flag) { // 처음 수
                bef_max = num;
                cnt++;
                flag = true;
            }
            else if (bef_max < num) {
                bef_max = num;
                arr.add(cnt);
                cnt = 1;
            } else {
                cnt++;
            }
        }
        arr.add(cnt);
        int[] answer = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }
        return answer;
    }
}
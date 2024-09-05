import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int st = commands[i][0] - 1;
            int ed = commands[i][1] - 1;
            int[] arr = new int[ed - st + 1];
            int idx = 0;
            for (int j = st; j <= ed; j++) {
                arr[idx++] = array[j];
            }
            Arrays.sort(arr);
            answer[i] = arr[commands[i][2] - 1];
        }
        return answer;
    }
}
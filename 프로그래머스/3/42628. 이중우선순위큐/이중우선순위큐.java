import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < operations.length; i++) {
            String[] s = operations[i].split(" ");
            int num = Integer.parseInt(s[1]);
            if (s[0].equals("I")) {
                minQ.add(num);
                maxQ.add(num);
            } else if (!maxQ.isEmpty()) {
                if (num == 1) {
                    minQ.remove(maxQ.poll());
                } else {
                    maxQ.remove(minQ.poll());
                }
            }
        }
        int[] answer = new int[2];
        if (maxQ.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
        }
        else if (maxQ.size() == 1) {
            answer[0] = minQ.peek();
            answer[1] = minQ.peek();
        }
        else {
            answer[0] = maxQ.peek();
            answer[1] = minQ.peek();
        }
        
        return answer;
    }
}
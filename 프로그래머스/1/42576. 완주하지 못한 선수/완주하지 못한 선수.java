import java.util.*;

class Solution {
    
    public String solution(String[] participant, String[] completion) {
		String answer = "";
		int num;
		HashMap<String, Integer> hash = new HashMap<>();
		for (String s: completion) {
			if (hash.containsKey(s)) hash.put(s, hash.get(s) + 1);
			else hash.put(s, 1);
		}
		for (String s: participant) {
			if (hash.containsKey(s)) {
				num = hash.get(s);
				if (num == 1) hash.remove(s);
				else hash.put(s, hash.get(s) - 1);
			}
			else answer = s;
		}
		return answer;
	}
}
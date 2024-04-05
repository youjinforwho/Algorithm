import java.util.*;
class Solution {
    public int solution(int[] nums) {
		int answer = 0;
		int pick = (nums.length) / 2;
		HashMap<Integer, Integer> hash = new HashMap<>();
		for (int num: nums) {
			if (hash.containsKey(num) == true) {
				hash.put(num, hash.get(num) + 1);
			}
			else {
				hash.put(num, 1);
				if (pick > answer) answer += 1;
			}
		}
		return answer;
	}
}
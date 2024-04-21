import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int meanVal = 0;
		int midVal = 0;
		int frequentVal = 0;
		int rangeVal = 0;
		
		int sum = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(br.readLine());
			if (map.containsKey(temp)) {
				map.put(temp, map.get(temp) + 1);
			}
			else map.put(temp, 1);
			sum += temp;
			arr[i] = temp;
		}
		List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			@Override
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				if (o1.getValue() == o2.getValue()) {
					return o1.getKey() - o2.getKey();
				}
				else return o2.getValue() - o1.getValue();
			}
		});
		Arrays.sort(arr);
		if (list.size() != 1 && list.get(0).getValue() == list.get(1).getValue()) {
			frequentVal = list.get(1).getKey();
		} else frequentVal = list.get(0).getKey();
		midVal = arr[arr.length / 2];
		if (sum >= 0) meanVal = (int)((double)sum / arr.length + 0.5);
		else meanVal = (int)((double)sum / arr.length * -1 + 0.5) * (-1);
		rangeVal = arr[arr.length - 1] - arr[0];
		System.out.println(meanVal+"\n"+midVal+"\n"+frequentVal+"\n"+rangeVal);
	}
}


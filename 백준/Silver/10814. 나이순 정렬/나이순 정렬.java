import java.util.*;
import java.io.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[][] s = new String[N][2];
		int i = 0;
		while (N-- > 0) {
			String[] arr = br.readLine().split(" ");
			s[i][0] = arr[0];
			s[i++][1] = arr[1];
		}
		
		Arrays.sort(s, new Comparator<String[]>() {

			@Override
			public int compare(String[] s1, String[] s2) {
				return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
			}
			
		});
		for (String[] str : s) {
			System.out.println(str[0] + " " + str[1]);
		}
	}
}


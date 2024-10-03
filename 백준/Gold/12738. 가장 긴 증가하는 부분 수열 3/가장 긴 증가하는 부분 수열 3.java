import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import org.w3c.dom.ls.LSOutput;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];

    String[] s = br.readLine().split(" ");
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(s[i]);
    }
    ArrayList<Integer> dp = new ArrayList<>();
    for (int num : arr) {
      int pos = Collections.binarySearch(dp, num);

      if (pos < 0) {
        pos = - (pos + 1);
      }

      if (pos >= dp.size()) {
        dp.add(num);
      } else {
        dp.set(pos, num);
      }
    }
    System.out.println(dp.size());
  }
}
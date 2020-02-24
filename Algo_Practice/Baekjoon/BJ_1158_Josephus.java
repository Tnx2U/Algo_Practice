import java.util.LinkedList;
import java.util.Scanner;

public class BJ_1158_Josephus {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int N = scan.nextInt();
		int K = scan.nextInt();
		int[] result = new int[N];
		int result_idx = 0;

		LinkedList<Integer> list = new LinkedList<>();
		int now = 0;

		for (int i = 0; i < N; i++) {
			list.add(i);
		}

		while (!list.isEmpty()) {
			now += K - 1;
			if (now >= list.size())
				now = now % list.size();
			result[result_idx++] = list.get(now) + 1;
			list.remove(now);
		}

		System.out.print("<");
		for (int i = 0; i < result.length; i++) {
			if (i == result.length - 1)
				System.out.println(result[i] + ">");
			else
				System.out.print(result[i] + ", ");
		}
	}
}

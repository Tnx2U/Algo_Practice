package D2;
import java.util.Scanner;

public class SE_D2_1859_MillionRich {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();

		for (int t = 1; t <= T; t++) {
			long ans = 0;
			int start = 0;

			int N = scan.nextInt();
			long[] input = new long[N];

			for (int i = 0; i < N; i++) {
				input[i] = scan.nextInt();
			}

			while (start < N) {
				int max_idx = 0;
				long max = 0;
				for (int i = start; i < input.length; i++) {
					if (input[i] > max) {
						max = input[i];
						max_idx = i;
					}
				}
				if (max_idx != 0) {
					for (int j = start; j <= max_idx; j++) {
						ans += max - input[j];
					}
				}

				start = max_idx + 1;

			}
			System.out.println("#" + t + " " + ans);
		}
	}
}

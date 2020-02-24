import java.util.Scanner;

public class BJ_1592_영식이와친구들 {
	static int N, M, L, now;
	static int[] table;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		L = sc.nextInt();
		table = new int[N];
		now = 0;
		int ans = -1;

		while (true) {
			ans++;
			if ((table[now]) % 2 == 0)
				now -= L % N;
			else
				now += L % N;

			if (now < 0) {
				now = N + now;
			} else if (now >= N) {
				now = now - N;
			}
			table[now]++;
			if(table[now] == M)
				break;
		}
		
		System.out.println(ans);
	}
}

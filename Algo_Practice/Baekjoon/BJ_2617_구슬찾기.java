import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BJ_2617_구슬찾기 {
	static Coin[] coins;
	static boolean[] visit;
	static int result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		coins = new Coin[N];
		int ans = 0;
		int middle = (N/2)+1;

		for (int i = 0; i < N; i++) {
			coins[i] = new Coin(i + 1);
		}

		int M = sc.nextInt();

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			coins[a - 1].light.add(coins[b - 1]);// 코인별 무게관계 기록
			coins[b - 1].heavy.add(coins[a - 1]);
		}

		for (int i = 0; i < N; i++) {
			visit = new boolean[N + 1];
			result = -1;
			heavySideSearch(i);
			if (result >= middle) {
				ans++;
				continue;
			}
			result = -1;
			visit = new boolean[N + 1];
			lightSideSearch(i);
			if (result >= middle) {
				ans++;
			}
		}

		System.out.println(ans);

	}

	private static void lightSideSearch(int i) {
		// i+1번 동전보다 가벼운 동전의 개수를 검색
		result++;
		if (coins[i].light.size() == 0)
			return;

		for (int j = 0; j < coins[i].light.size(); j++) {
			if (!visit[coins[i].light.get(j).id]) {
				visit[coins[i].light.get(j).id] = true;
				lightSideSearch(coins[i].light.get(j).id-1);
			}
		}

	}

	private static void heavySideSearch(int i) {
		// i+1번 동전보다 무거운 동전의 개수를 검색
		result++;
		if (coins[i].heavy.size() == 0)
			return;

		for (int j = 0; j < coins[i].heavy.size(); j++) {
			if (!visit[coins[i].heavy.get(j).id]) {
				visit[coins[i].heavy.get(j).id] = true;
				heavySideSearch(coins[i].heavy.get(j).id-1);
			}
		}

	}

	static class Coin {
		int id;
		List<Coin> heavy;
		List<Coin> light;

		public Coin(int id) {
			super();
			this.id = id;
			heavy = new ArrayList<Coin>();
			light = new ArrayList<Coin>();
		}
	}
}

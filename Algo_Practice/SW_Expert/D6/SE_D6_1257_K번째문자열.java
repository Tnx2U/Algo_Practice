package D6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SE_D6_1257_K번째문자열 {
	static Set<String> set;
	static StringBuilder sb;
	static int[] arr = new int[2];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			int k = Integer.parseInt(br.readLine());
			String[] arr;
			set = new HashSet<>();

			sb = new StringBuilder();
			sb.append(br.readLine());

			pickSubstring(0, 0);
			
			Object[] list = set.toArray();
			Arrays.sort(list);

//			for (int i = 0; i < list.size(); i++) {
//				System.out.println(list.get(i));
//			}
			
			if (k > list.length)
				System.out.println("#" + tc + " " + "none");
			else
				System.out.println("#" + tc + " " + list[k-1]);
		}
	}

	private static void pickSubstring(int cnt, int target) {
		if (cnt == 2) {
			if (arr[0] <= arr[1]) {
				String cdd = sb.substring(arr[0], arr[1]);
				if(!set.contains(cdd))
					set.add(cdd);
				// System.out.println(sb.substring(arr[0], arr[1]));
			}
			return;
		} else if (target == sb.length() + 1)
			return;

		arr[cnt] = target;
		pickSubstring(cnt + 1, target + 1);
		pickSubstring(cnt, target + 1);
	}
}

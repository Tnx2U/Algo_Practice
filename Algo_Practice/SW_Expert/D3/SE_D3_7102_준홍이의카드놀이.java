package D3;

import java.util.Scanner;

public class SE_D3_7102_준홍이의카드놀이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {

			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] table = new int[N + M + 1];

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					table[i+j]++;
				}
			}
			
			int max = 0;
			
			for (int i = 0; i < table.length; i++) {
				if(table[i] > max) {
					max = table[i];
				}
			}
			
			System.out.print("#"+tc);
			
			for (int i = 0; i < table.length; i++) {
				if(table[i] == max)
					System.out.print(" "+i);
			}
			
			System.out.println();
		}
	}
}

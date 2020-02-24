package D2;
import java.util.Scanner;

public class SE_D2_2001_파리퇴치 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int ans = 0;
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] table = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					table[i][j] = sc.nextInt();
				}
			}
			
			for (int i = 0; i <= N-M; i++) {
				for (int j = 0; j <= N-M; j++) {
					int killed=0;
					for (int k = 0; k < M; k++) {
						for (int k2 = 0; k2 < M; k2++) {
							killed += table[i+k][j+k2];
						}
					}
					if(ans < killed) {
						ans = killed;
					}
				}
			}
			
			System.out.println("#"+t+" "+ans);
		}
	}
}






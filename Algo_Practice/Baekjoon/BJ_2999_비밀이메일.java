import java.util.Scanner;

public class BJ_2999_비밀이메일 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] ori = sc.nextLine().toCharArray();
		char[][] copy;
		
		int N = ori.length;
		int R = getC(N);
		int C = N/R;
		copy = new char[R][C];
		
//		for (int i = 1; i <= 100; i++) {
//			System.out.println(getC(i));
//		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				copy[i][j] = ori[i*C+j];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				sb.append(copy[j][i]);
			}
		}
		
		System.out.println(sb.toString());
	}

	private static int getC(int n) {
		int div=0;
		for (int i = 1; i <= Math.sqrt(n); i++) {
			if(n%i == 0) {
				div = Math.max(i, div);
			}
		}
		return div;
	}
}

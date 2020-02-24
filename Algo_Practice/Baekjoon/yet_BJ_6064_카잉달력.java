import java.util.Scanner;

public class yet_BJ_6064_카잉달력 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 0; t < T; t++) {
			int ans = -1;
			int M = sc.nextInt();
			int N = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			int cycle = 0;
			
			int enday = getMinMultiple(M, N);
			
			while(true) {
//				int day = x+M*cycle++;
//				
//				if(day == enday && M == x && N == y) {
//					ans = day;
//					break;
//				}
//				
//				if(day > enday)
//					break;
				
				if(x > enday || (x-1)%N+1 == y)
					break;
				x += M;
				
//				if(N == M && x != y)
//					break;
//				
//				if(day%N == 0) {
//					if(N%M == 0 || M%N == 0) {
//						ans = day;
//						break;
//					}
//				}
//				
//				if(day%N == y) {
//					ans = day;
//					break;
//				}
				
				// -1일때의 조건 예외처리
				// 정답은 나오지 않으면서 같은 상황이 무한반복될 때
			}
			if( x > enday)
				System.out.println(-1);
			else
				System.out.println(x);
		}
	}

	private static int getMinMultiple(int n, int m) {
		int x =n;
		int y = m;
		
		while(y > 0) {
			int temp = y;
			y = x%y;
			x = temp;
		}
		
		return (m*n)/x;
	}
}

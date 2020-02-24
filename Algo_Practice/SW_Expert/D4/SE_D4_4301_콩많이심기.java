package D4;

import java.util.Scanner;

//풀이핵심 : 테이블의 좌상단부터 차례대로 콩을 심었을때, 4칸을 주기로 같은 패턴이 반복되는 것을 활용하여 수식으로 계산

public class SE_D4_4301_콩많이심기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			int ans=0;
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			int row_A,row_B;
			int col_A,col_B;
			
			//많을때 행당 콩 개수
			if(N%4 > 2) 
				row_A = (N/4)*2 + 2;
			else 
				row_A = (N/4)*2 + N%4;
 			//적을때 행당 콩 개수
			row_B = N - row_A;
			
			//많을때 열당 콩 개수
			if(M%4 > 2) 
				col_A = (M/4)*2 + 2;
			else 
				col_A = (M/4)*2 + M%4;
			//적을때 열당 콩 개수
			col_B = M - col_A;
			
			//전체 콩 계산
			ans = col_A*row_A + col_B*row_B;
			
			System.out.println("#"+tc+" "+ans);
		}
	}
}

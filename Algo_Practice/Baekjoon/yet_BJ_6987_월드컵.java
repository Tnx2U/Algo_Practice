import java.util.Scanner;

public class yet_BJ_6987_월드컵 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 0; tc < 4; tc++) {
			boolean ans = true;
			int[][] table = new int[6][3];
			
			for (int i = 0; i < table.length; i++) {
				table[i][0] = sc.nextInt();
				table[i][1] = sc.nextInt();
				table[i][2] = sc.nextInt();
			}
			//입력 끝
			
			//1.모든 승수 = 모든 패수
			int win = 0;
			int lose = 0;
			int same = 0;
			for(int[] country : table) {
				win += country[0];
				same += country[1];
				lose += country[2];
			}
			if(win != lose)
				ans = false;
			
			//2.한 나라의 승+무+패 = 5
			if(ans) {
				for(int[] country : table) {
					if(country[0]+country[1]+country[2] != 5) {
						ans = false;
						break;
					}
				}
			}
			
			//3. 모든 승(패) 수 = 15 - 무승부 수/20.
			if(ans) {
				if(win != 15-same/2)
					ans = false;
			}
			//4. 무승부는 최소 2개 이상의 나라에 있으며 0이거나 짝수여야 함.
			//5. 한 나라가 전체무승부 수 절반 초과의 값을 무승부 수로 가질 수 없음
			if(ans) {
				if(same == 0) {
					
				}else if(same%2 == 0){
					for(int[] country : table) {
						if(country[1] > same/2) {
							ans = false;
							break;
						}
					}
				}else 
					ans = false;
			}
			
			
			if(ans)
				System.out.print(1+" ");
			else
				System.out.print(0+" ");
		}
		
	}
}

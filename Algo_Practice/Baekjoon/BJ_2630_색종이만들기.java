import java.util.Scanner;

public class BJ_2630_색종이만들기 {
	static int[][] table;
	static int white,blue;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		table = new int[N][N];
		white = 0;
		blue = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				table[i][j] = sc.nextInt();
			}
		}
		
		divTable(0,0,N);
		
		System.out.println(white);
		System.out.println(blue);
	}
	private static void divTable(int srt_x, int srt_y, int len) {
		boolean allsame = true;
		
		//전체 일치하는지 확인
		int target = table[srt_y][srt_x];
		for (int i = srt_y; i < srt_y+len; i++) {
			for (int j = srt_x; j < srt_x+len; j++) {
				if(table[i][j] != target) {
					allsame = false;
					break;
				}
			}
			if(!allsame)
				break;
		}
		
		if(allsame) {//모두 같으면
			if(target == 1)
				blue++;
			else
				white++;
		}else { // 다르면
			divTable(srt_x, srt_y, len/2);
			divTable(srt_x+len/2, srt_y, len/2);
			divTable(srt_x, srt_y+len/2, len/2);
			divTable(srt_x+len/2, srt_y+len/2, len/2);
		}
		//
	}
}

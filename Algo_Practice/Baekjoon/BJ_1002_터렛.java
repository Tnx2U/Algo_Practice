import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1002_터렛 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for (int tc = 1; tc <= TC; tc++) {
			int ans = -2; 
			st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			double L = (double) Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));

			if(r2 > r1) {
				int temp = r2;
				r2 = r1;
				r1 = temp;
			}
			
			
			if(L == 0) { //두 사람이 같은 곳에 서있음
				if(r1==r2) // 발견한 거리가 같음
					ans = -1; // 무한대
				else // 같은데 서있는데 발견한 거리는 서로 다름
					ans = 0; // 없지 뭐
			}else if(L == r1+r2) { //외곽에서 한 점에서 만남
				ans = 1;
			}else if(L < r1+r2) {
				if(r1 < r2+L) {
					ans = 2;
				}else if(r1 == r2+L) {
					ans = 1;
				}else {
					ans = 0;
				}
			}else if(L > r1+r2)
				ans = 0;
			
			System.out.println(ans);
		}
	}
}

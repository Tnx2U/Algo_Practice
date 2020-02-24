import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_3109_빵집 {
	static char[][] table;
	static int[] dy = {-1,0,1};
	static Stack<Position> stk;
	
	public static void main(String[] args) throws IOException {
		int ans = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] RC = br.readLine().split(" ");
		int R = Integer.parseInt(RC[0]);
		int C = Integer.parseInt(RC[1]);
		
		char[][] table = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			table[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < R; i++) {
			stk = new Stack<>();
			stk.push(new Position(i, 0));
			while(true) {
				boolean back = false;
				Position now = stk.peek();
				for (int j = 0; j < 3; j++) {
					if(now.y+dy[j] >=0 && now.y+dy[j] < R) {
						if(table[now.y+dy[j]][now.x+1]=='.') {
							stk.push(new Position(now.y+dy[j], now.x+1));
							table[now.y+dy[j]][now.x+1] = 'X';
							back = true;
							break;
						}
					}
				}
				if(!back) { //이동할곳이 하나도 없으면
					if(now.x == 0)
						break;
					stk.pop();
				}else {
					if(now.x+1 == C-1) {
						ans++;
						break;
					}
				}
			}
		}
		
		System.out.println(ans);
	}

	
	static class Position{
		int x,y;

		public Position(int y, int x) {
			this.x = x;
			this.y = y;
		}
	}
}

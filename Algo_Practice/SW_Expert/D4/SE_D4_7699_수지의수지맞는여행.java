package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SE_D4_7699_수지의수지맞는여행 {
	static char[][] table;
	static boolean[] visit;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int R,C;
	static int ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			ans = 0;
			
			String[] RC = br.readLine().split(" ");
			R = Integer.parseInt(RC[0]);
			C = Integer.parseInt(RC[1]);
			
			table = new char[R][C];
			visit = new boolean[27];
			
			for (int i = 0; i < R; i++) {
				char[] inputs = br.readLine().toCharArray();
				for (int j = 0; j < C; j++) {
					table[i][j] = inputs[j];
				}
			}
			
			visit[table[0][0]-'A'] = true;
			perm(0,0,1);
			
			System.out.println("#"+t+" "+ans);
		}
	}
	private static void perm(int i, int j, int count) {
		int[] r_pos = new int[4];
		int[] c_pos = new int[4];
		int pos_idx = 0;
		
		for (int k = 0; k < dc.length; k++) {
			if(i+dr[k] < R && i+dr[k] >=0 && j+dc[k] < C && j+dc[k] >= 0) {
				if(!visit[table[i+dr[k]][j+dc[k]] - 'A']) {
					r_pos[pos_idx] = i+dr[k];
					c_pos[pos_idx++] = j+dc[k];
				}
			}
		}
		
		if(pos_idx == 0) { // 갈 수 있는곳 없음
			ans = Math.max(ans, count);
			return;
		}
		
		for (int k = 0; k < pos_idx; k++) { //목적지 수만큼 순회
			visit[table[r_pos[k]][c_pos[k]] - 'A'] = true;
			perm(r_pos[k], c_pos[k], count+1);
			visit[table[r_pos[k]][c_pos[k]] - 'A'] = false;
		}
	}
}

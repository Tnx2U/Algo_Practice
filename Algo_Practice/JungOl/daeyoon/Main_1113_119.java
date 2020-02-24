package daeyoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1113_119 {

	static int M, N, m, n;
	static int[][] map;
	static int[][] memo;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] MN = br.readLine().split(" ");
		N = Integer.parseInt(MN[0]);
		M = Integer.parseInt(MN[1]);
		
		String[] mn = br.readLine().split(" ");
		n = Integer.parseInt(mn[0]);
		m = Integer.parseInt(mn[1]);
		 
		map = new int[M][N];
		memo = new int[M][N];
		min =  Integer.MAX_VALUE;
		
		for(int i=0; i<M; i++) {
			String[] input = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				 map[i][j] = Integer.parseInt(input[j]);
				 memo[i][j] = Integer.MAX_VALUE;
			}
		}
		memo[0][0] = 0;
		for(int d=0; d<4; d++) {
			int nx = 0+dx[d];
			int ny = 0+dy[d];
			if(nx>=0&&nx<N&&ny>=0&&ny<M) {
				if(map[nx][ny]==1)
					dfs(nx,ny,0,d);
			}
		}
		if(min==Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		System.out.println(min);
	}
	public static void dfs(int x, int y, int cnt, int drec) {
		if(cnt>min) {
			return;
		}
		if(x==n&&y==m) {
			min = Math.min(cnt, min);
			return;
		}
		for(int d=0; d<4; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			if(nx>=0&&nx<N&&ny>=0&&ny<M) {
				if(memo[nx][ny]>cnt&&map[nx][ny]==1) {
					memo[nx][ny] = cnt;
					if(drec==d)
						dfs(nx,ny,cnt,d);
					else
						dfs(nx,ny,cnt+1,d);
				}
			}
		}
	}
}

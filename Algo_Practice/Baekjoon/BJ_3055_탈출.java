
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BJ_3055_탈출 {
	static char[][] table;
	static int R,C;
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,0,1,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] RC = br.readLine().split(" ");
		
		int ans = 0;
		R = Integer.parseInt(RC[0]);
		C = Integer.parseInt(RC[1]);
		
		table = new char[R][C];
		
		Queue<Position> water = new LinkedList<>();
		Queue<Position> gosum = new LinkedList<>();
		
		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				table[i][j] = input.charAt(j);
				if(table[i][j] == '*')
					water.add(new Position(i, j));
				else if(table[i][j] == 'S')
					gosum.add(new Position(i, j));
			}
		}
		// 입력 끝
		boolean arrive = false;
		List<Position> list = new ArrayList<>();
		
		while(!arrive) {//고슴도치가 목적지 도착하든가 하늘나라에 가면
			while(!water.isEmpty()) {
				list.add(water.poll());
			}
			
			//물 퍼짐
			for(Position p : list) {
				for (int dir = 0; dir < 4; dir++) {
					if(p.x+dx[dir] < C && p.x+dx[dir] >= 0 && p.y+dy[dir] < R && p.y+dy[dir] >= 0) {
						if(table[p.y+dy[dir]][p.x+dx[dir]] == '.' || table[p.y+dy[dir]][p.x+dx[dir]] == 'S') {
							table[p.y+dy[dir]][p.x+dx[dir]] = '*';
							water.add(new Position(p.y+dy[dir], p.x+dx[dir]));
						}
					}
				}
			}
			list.clear();
			
			//고슴도치 움직임
			while(!gosum.isEmpty()) {
				Position now = gosum.poll();
				for (int dir = 0; dir < 4; dir++) {
					if(now.x+dx[dir] < C && now.x+dx[dir] >= 0 && now.y+dy[dir] < R && now.y+dy[dir] >= 0) {
						if(table[now.y+dy[dir]][now.x+dx[dir]] == 'D') {
							ans++;
							arrive = true;
							break;
						}
					}
				}
				if(arrive) {
					break;
				}
				
				if(table[now.y][now.x] == '.' || table[now.y][now.x] == 'S')
					list.add(now);
			}
			if(arrive) {
				break;
			}
			
			if(list.size() == 0)//고슴도치 하늘나라로 가버림
				break;
			
			
			for(Position p : list) {
				for (int dir = 0; dir < 4; dir++) {
					if(p.x+dx[dir] < C && p.x+dx[dir] >= 0 && p.y+dy[dir] < R && p.y+dy[dir] >= 0) {
						if(table[p.y+dy[dir]][p.x+dx[dir]] == '.') {
							table[p.y+dy[dir]][p.x+dx[dir]] = 'S';
							gosum.add(new Position(p.y+dy[dir], p.x+dx[dir]));
						}else if(table[p.y+dy[dir]][p.x+dx[dir]] == 'D') {
							arrive = true;
						}
					}
				}
			}
			list.clear();
			ans++;
		}
		
		if(arrive) {
			System.out.println(ans);
		}else {
			System.out.println("KAKTUS");
		}
	}
	
	static class Position{
		int x,y;

		public Position(int y, int x) {
			this.x = x;
			this.y = y;
		}
	}
}
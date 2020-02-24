package D3;

import java.util.Arrays;
import java.util.Scanner;

public class SE_D3_1873_상호의배틀필드 {
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static char[] rec = {'^','v','<','>'};
	static int[] pos;
	static int H,W,N;
	static char[][] table;
	static char[] cmd;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			H = sc.nextInt();
			W = sc.nextInt();
			table = new char[H][W];
			pos = new int[2];
			
			for (int i = 0; i < H; i++) {
				char[] input = sc.next().toCharArray();
				for (int j = 0; j < input.length; j++) {
					table[i][j] = input[j];
					if(input[j] == '<' ||input[j] == '>' ||input[j] == '^' ||input[j] == 'v') {
						pos[0] = i;
						pos[1] = j;
					}
				}
			}
			
			N = sc.nextInt();
			cmd = sc.next().toCharArray();
			
			for (int i = 0; i < N; i++) {
				switch(cmd[i]) {
					case 'U':
						move(0);
						break;
					case 'D':
						move(1);
						break;
					case 'L':
						move(2);
						break;
					case 'R':
						move(3);
						break;
					case 'S':
						shot(pos[0],pos[1]);
						break;
				}
			}
			System.out.print("#"+tc+" ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(table[i][j]);
				}
				System.out.println();
			}
		}
	}

	private static void shot(int y, int x) {
		int idx = -1;
		if(table[pos[0]][pos[1]] == '>')
			idx = 3;
		else if(table[pos[0]][pos[1]] == '<')
			idx = 2;
		else if(table[pos[0]][pos[1]] == 'v')
			idx = 1;
		else if(table[pos[0]][pos[1]] == '^')
			idx = 0;
		
		if(x < 0 || x >= W || y < 0 || y >= H)
			return;
		char cur = table[y][x];
		
		switch(cur) {
			case '.':
				shot(y+dy[idx],x+dx[idx]);
				break;
			case '*':
				table[y][x] = '.';
				break;
			case '#':
				break;
			case '-':
				shot(y+dy[idx],x+dx[idx]);
				break;
			default:
				shot(y+dy[idx],x+dx[idx]);
		}
	}

	private static void move(int i) {
		int next_y = pos[0] + dy[i];
		int next_x = pos[1] + dx[i];
		
		table[pos[0]][pos[1]] = rec[i];
		
		if(next_x < 0 || next_x >= W || next_y < 0 || next_y >= H) {
			return;
		}
		
		if(table[next_y][next_x] != '.') {
			return;
		}
		char temp = table[next_y][next_x];
		table[next_y][next_x] = table[pos[0]][pos[1]];
		table[pos[0]][pos[1]] = temp;
		
		pos[0] += dy[i];
		pos[1] += dx[i];
	}
}

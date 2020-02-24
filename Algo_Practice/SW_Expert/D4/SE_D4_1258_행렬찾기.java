package D4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SE_D4_1258_행렬찾기 {
	static int[][] table;
	static List<Point> list;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int tc = 1; tc <= TC; tc++) {
			int ans = 0;
			N = sc.nextInt();
			table = new int[N][N];
			list = new ArrayList<Point>();
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					table[i][j] = sc.nextInt();
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(table[i][j]!= 0) {
						getSize(i,j);
						remove(i,j);
						ans++;
					}
				}
			}
			
			list.sort(null);
			
			System.out.print("#"+tc+" "+ans);
			for (int i = 0; i < list.size(); i++) {
				System.out.print(" "+list.get(i).y+" "+list.get(i).x);
			}
			System.out.println();
		}
	}
	
	private static void remove(int i, int j) {
		int x = list.get(list.size()-1).x+j;
		int y = list.get(list.size()-1).y+i;
		
		for (int h = i; h < y; h++) {
			for (int w = j; w < x; w++) {
				table[h][w] = 0;
			}
		}
	}

	private static void getSize(int i, int j) {
		int x=0;
		int y=0;
		while(j<N && table[i][j] != 0) {
			x++;
			j++;
		}
		j--;
		while(i<N && table[i][j] != 0) {
			y++;
			i++;
		}
		list.add(new Point(y, x));
	}

	static class Point implements Comparable<Point>{
		int y,x,size;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
			this.size = x*y;
		}

		@Override
		public int compareTo(Point o) {
			if(o.size != size)
				return size-o.size;
			else
				return o.x-x;
		}
	}
}

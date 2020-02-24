package JungOl;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ans_JO_1828_냉장고 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Point> list = new ArrayList<>();
		
		int N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			list.add(new Point(sc.nextInt(), sc.nextInt()));
		}
		
		Collections.sort(list);
		
		int ans = 1;
		int tmpMax = list.get(0).y;
		for (int i = 0; i < list.size(); i++) {
			if(tmpMax < list.get(i).x) {
				ans++;
				tmpMax = list.get(i).y;
			}
		}
		System.out.println(ans);
	}
	
	static class Point implements Comparable<Point>{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			return y - o.y;// 이거 맞나?
		}
	}
}

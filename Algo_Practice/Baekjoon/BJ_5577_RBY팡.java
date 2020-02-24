import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BJ_5577_RBY팡 {
	static ArrayList<Integer> balls = new ArrayList<>();
	static ArrayList<Integer> origin = new ArrayList<>();
	static List<Point> points = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ans = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			int element = sc.nextInt();
			balls.add(element);
			origin.add(element);
		}
		
		for (int i = 0; i < N-3; i++) {
			if(balls.get(i+1) == balls.get(i+2) && balls.get(i+2) == balls.get(i+3)) {
				points.add(new Point(i, balls.get(i+1)));
				if(i+4 < N)
					points.add(new Point(i+4, balls.get(i+3)));
			}
		}
		
		for (int i = 0; i < points.size(); i++) {
			balls.set(points.get(i).position, points.get(i).color);
			pang(points.get(i).position);
			ans = Math.min(ans, balls.size());
			balls = (ArrayList<Integer>) origin.clone();
		}
		System.out.println(ans);
	}

	private static void pang(int srt) {
		int temp = -1;
		
		for (int i = srt-3; i <= srt; i++) {
			if(i >= 0 && i+3 <balls.size()) {
				if(balls.get(i) == balls.get(i+1) && balls.get(i+2) == balls.get(i+3) && balls.get(i) == balls.get(i+3)) {
					temp = i;
					int color = balls.get(i);
					while(balls.size() > i) {
						if(balls.get(i) == color)
							balls.remove(i);
						else
							break;
					}
					break;
				}
			}
		}
		if(temp != -1)
			pang(temp);
	}
	
	static class Point{
		int position;
		int color;
		
		public Point(int position, int color) {
			this.position = position;
			this.color = color;
		}
	}
}

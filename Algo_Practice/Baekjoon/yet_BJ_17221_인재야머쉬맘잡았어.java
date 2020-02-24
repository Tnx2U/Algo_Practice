import java.util.Scanner;

public class yet_BJ_17221_인재야머쉬맘잡았어 {
	static int A,B,X,Y;
	static int ans;
	static int count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		A = sc.nextInt();
		B = sc.nextInt();
		X = sc.nextInt();
		Y = sc.nextInt();
		
		ans = Integer.MAX_VALUE;
		count = 0;
		
		doAction();
		
		System.out.println(ans);
	}
	private static void doAction() {
		if(count >= ans)
			return;
		if(A <= 0) {
			return;
		}
		if(X <= 0) {
			ans = Math.min(ans, count);
			return;
		}
		
		//공격수행
		X -= B;
		A -= Y;
		count++;
		doAction();
		//공격결과 초기화
		X += B;
		A += Y;
		count--;
		
		//반격수행
		X -= Y;
		int heal = A/10;
		A += heal;
		count++;
		doAction();
		//반격결과 초기화
		X += Y;
		A -= heal;
		count--;
		
		//버프 수행
		int buff = B/5;
		B += buff;
		A -= Y*3;
		count++;
		doAction();
		//버프결과 초기화
		B -= buff;
		A += Y*3;
		count--;
	}
}

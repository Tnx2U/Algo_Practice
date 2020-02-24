import java.util.Scanner;

public class Solution4 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		System.out.println(solution(n,k));
	}

	private static int solution(int n, int k) {
		long ans=n*n;
		
		if(n == 1)
			return 1;
		
		if(k == 0)
			return 0;
		
		for (int i = 1; i < k; i++) {
			ans *= n*n - i*(2*n-1);
			ans %= 10007;
		}
		
		return (int)ans/2;
	}
}

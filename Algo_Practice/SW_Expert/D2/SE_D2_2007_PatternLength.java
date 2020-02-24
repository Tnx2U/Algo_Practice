package D2;
import java.util.Scanner;

public class SE_D2_2007_PatternLength {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine().trim());
		
		for (int t = 1; t <= T; t++) {
			int ans = 0;
			
			char[] inputs = sc.nextLine().toCharArray();
			char fir = inputs[0];
			char sec = inputs[1];
			
			for (int i = 2; i < inputs.length; i++) {
				if(inputs[i] == fir && inputs[i+1] == sec) {
					ans = i;
					break;
				}
			}
			
			System.out.println("#"+t+" "+ans);
		}
	}
}

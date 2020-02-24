package D3;
import java.util.Scanner;

public class SE_D3_7675_DigitSum {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		
		for (int t = 1; t <= T; t++) {
			String input = scan.next();
			long temp = 0;
			
			while(Long.parseLong(input) > 10) {
				temp = 0;
				for (int i = 0; i < input.length(); i++) {
					temp += input.charAt(i) - '0'; 
				}
				input = Long.toString(temp);
			}
			
			
			System.out.println("#"+t+" "+input);
		}
	}
}

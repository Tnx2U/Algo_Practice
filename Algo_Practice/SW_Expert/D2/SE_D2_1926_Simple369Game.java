package D2;
import java.util.Scanner;

public class SE_D2_1926_Simple369Game {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int input = sc.nextInt();
		
		for (int i = 1; i<= input ; i++) {
			int clap = 0;
			String now = Integer.toString(i);
			for (int j = 0; j < now.length(); j++) {
				if(now.charAt(j)=='3' || now.charAt(j)=='6' || now.charAt(j)=='9')
					clap++;
			}
			if(clap > 0) {
				for (int j = 0; j < clap; j++) {
					System.out.print("-");
				}
			}else {
				System.out.print(i);
			}
			System.out.print(" ");
		}
	}
}

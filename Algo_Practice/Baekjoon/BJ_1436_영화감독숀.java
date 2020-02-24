import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1436_영화감독숀 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim()) - 1;
		int num = 666;
		while(N > 0) {
			num++;
			if(Integer.toString(num).contains("666"))
				N--;
			
		}
		System.out.println(num);
	}
}

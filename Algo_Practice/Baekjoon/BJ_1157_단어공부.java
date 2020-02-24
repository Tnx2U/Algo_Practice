import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1157_단어공부 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] inputs = br.readLine().toCharArray();
		int[] count = new int['Z'-'A'+1];
		char ans='a';
		
		for (int i = 0; i < inputs.length; i++) {
			char target = inputs[i];
			if(target > 96) {
				target -= 32;
				count[target-'A']++;
			}else {
				target = inputs[i];
				count[target-'A']++;
			}
		}
		
		int max=0;
		int max_idx=-1;
		for (int i = 0; i < count.length; i++) {
			if(count[i] > max) {
				max = count[i];
				max_idx = i;
			}
		}
		
		Arrays.sort(count);
		if(count[count.length-1] == count[count.length-2])
			ans = '?';
		
		if(ans == '?')
			System.out.println('?');
		else {
			ans = (char) (max_idx+'A');
			System.out.println(ans);
		}
	}
}

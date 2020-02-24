
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_9012_괄호 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int numOfInput;
		String[] inputs;
		String result;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		numOfInput = Integer.parseInt(br.readLine());
		
		inputs = new String[numOfInput];
		
		for(int i=0; i<numOfInput; i++){
			inputs[i] = br.readLine();
		}
		
		doJudge(inputs,numOfInput);
	}

	private static void doJudge(String[] inputs, int numOfInput) {
		int maintain;
		String result;
		
		for(int i=0; i<numOfInput; i++){
			result = "YES";
			maintain = 0;
			for(int j=0; j<inputs[i].length(); j++){
				if(inputs[i].charAt(j) == '(')
					maintain++;
				else
					maintain--;
				
				if(maintain < 0){
					result ="NO";
					break;
				}	
			}
			if(maintain != 0)
				result = "NO";
			System.out.println(result);
		}	
	}
}
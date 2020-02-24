
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_4948_베르트랑공준 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int input,result;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true){
			input = Integer.parseInt(br.readLine());
			if(input == 0)
				break;
			result = getNumOfPrime(input+1, input*2);
			System.out.println(result);
		}
	}
	
	private static int getNumOfPrime(int left, int right){
		int arr[] = new int[right+1];
		int limit=1;//
		int NumOfPrime=0;

		Arrays.fill(arr, 0);//배열을 모두 0으로 채움
		for(int i=2; ;i++){//종료기점 limit을 선정하기 위한 반복문
			if(Math.pow(i, 2) > right)
				break;
			else
				limit = i;
		}
		
		for(int i=2; i<=limit; i++){
			if(arr[i]==0){
				arr[i]=1;
				doErase(arr, i);
			}
		}
		arr[0] = -1;
		arr[1] = -1;
		
		for(int i=left; i<=right; i++){
			if(arr[i] != -1)
				NumOfPrime++;
		}
		
		return NumOfPrime;
		
	}

	private static void doErase(int[] arr, int i) {//소수의 배수들을 배열에서 제거하는 함수
		int j=2;
		while(i*j <= arr.length-1){
			arr[i*j] = -1;
			j++;
		}
	}
}
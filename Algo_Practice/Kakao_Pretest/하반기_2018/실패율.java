package 하반기_2018;
import java.util.Arrays;
import java.util.Comparator;

public class 실패율 {
	static double[] failure;
	public static void main(String[] args) {
		int[] input = {4,4,4,4,4};
		int[] output = solution(4, input);
		
		for(int i : output) {
			System.out.println(i);
		}
	}
	
	public static int[] solution(int N, int[] stages) {
		int[] reach = new int[N+1];
		int[] fail = new int[N+1];
		failure = new double[N+1];
        
        for(int i=0; i< stages.length; i++) {
        	for (int j = 1; j <= stages[i]; j++) {
        		if(j != N+1)
        			reach[j]++;
			}
        	if(stages[i] != N+1) {
        		fail[stages[i]]++;
        	}
        }
        
        for (int i = 1; i <= N; i++) {
			failure[i] = (double)fail[i] / (double)reach[i];
		}
        
        Integer[] temp = new Integer[N];
        for (int i = 1; i <= N; i++) {
        	temp[i-1] = i;
		}

        Arrays.sort(temp, new CustomCompareSort());
        
        int[] result = Arrays.stream(temp).mapToInt(Integer::intValue).toArray();
        
        return result;
    }
	
	static public class CustomCompareSort implements Comparator<Integer>{
		@Override
		
		public int compare(Integer a, Integer b) {
			if(failure[a] > failure[b]) {
    			return -1;
    		}else if(failure[a] < failure[b]) {
    			return 1;
    		}else {
    			if(b < a) {
    				return 1;
    			}else {
    				return -1;
    			}
    		}
		}
	}
}

package lv2;

public class Solution1 {
	public static void main(String[] args) {
		System.out.println(solution(5000));
	}
	
	public static int solution(int n) {
        int ans = 0;
        while(n!=0) {
        	if(n%2 ==0) {
        		n /= 2;
        	}else {
        		n--;
        		ans++;
        	}
        }
        
        return ans;
    }
}

package lv1;

public class Solution1 {
	public static void main(String[] args) {
		
	}
	
	  public int[] solution(int n, int m) {
	      int[] answer = new int[2];
	      
	      //�ִ�����
	      int minor = (n < m) ? n : m;
	      for (int i = minor; i >= 1; i--) {
	    	  if(m%i == 0 && n%i == 0) {
	    		  answer[0] = i;
	    		  break;
	    	  }
	      }
	      
	      //�ּҰ����
	      answer[1] = (n*m)/answer[0];
	      
	      return answer;
	  }
}

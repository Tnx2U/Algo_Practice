package 하반기_2018;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//https://programmers.co.kr/learn/courses/30/lessons/42888?language=java

public class OpenChattingRoom {
	public static void main(String[] args) {
		String[] inputs = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		String[] answer = solution(inputs);
		
		for(String s : answer) {
			System.out.println(s);
		}
		
	}
	
	public static String[] solution(String[] record) {
        String[] answer;
        Map<String, String> map = new HashMap<>();
        
        int count = 0;
        for (int i = 0; i < record.length; i++) {
        	StringTokenizer st = new StringTokenizer(record[i]);
        	String temp = st.nextToken();
        	if(temp.equals("Enter")|| temp.equals("Change")) {
        		map.put(st.nextToken(), st.nextToken());
        		count++;
        	}
		}
  
        answer = new String[count];
        int ans_cnt=0;
        
        for (int i = 0; i < record.length; i++) {
        	StringTokenizer st = new StringTokenizer(record[i]);
        	String temp = st.nextToken();
        	if(temp.equals("Enter")) {
        		answer[ans_cnt++] = map.get(st.nextElement())+"���� ���Խ��ϴ�.";
        	}else if(temp.equals("Leave")){
        		answer[ans_cnt++] = map.get(st.nextElement())+"���� �������ϴ�.";
        	}
		}
        
        return answer;
	}
}

//�ؽ���
//enter�� map.set(uid,nickname)
//change���� map.set(uid,nicname)
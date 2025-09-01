package 프로그래머스;

import java.util.*;

public class 오픈채팅방 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"})));
    }
    public static String[] solution(String[] record) {
        Map<String, String> userMap = new HashMap<>();
        List<String[]> logs = new ArrayList<>();
        for(int i = 0;i<record.length;i++){
            String[] temp = record[i].split(" ");
            String inOutChange = temp[0];
            String user = temp[1];
            if(inOutChange.equals("Enter")){
                String name = temp[2];
                userMap.put(user, name);
                logs.add(new String[]{user,"Enter"});
            }else if(inOutChange.equals("Change")){
                String name = temp[2];
                userMap.put(user,name);
            }else{
                logs.add(new String[]{user,"Leave"});
            }
        }
        String[] answer = new String[logs.size()];
        for(int i=0;i<logs.size();i++){
            String uid = logs.get(i)[0];
            String action = logs.get(i)[1];
            String name = userMap.get(uid);
            if(action.equals("Enter")){
                answer[i] = name + "님이 들어왔습니다.";
            }else{
                answer[i] = name + "님이 나갔습니다.";
            }
        }

        return answer;
    }
}

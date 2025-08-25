package 프로그래머스;

import java.util.Arrays;
import java.util.HashSet;

public class 불량사용자 {
    static boolean[] check;
    static HashSet<String> set;
    public int solution(String[] user_id, String[] banned_id) {
        check = new boolean[user_id.length];
        set = new HashSet<>();
        for( int i=0;i<banned_id.length;i++) {
            banned_id[i]=banned_id[i].replace("*",".");
        }
        back(0,"",user_id,banned_id);
        return set.size();
    }

    private void back(int depth, String res, String[] userId, String[] bannedId) {
        if(depth==bannedId.length) {
            String[] temp = res.split(" ");
            Arrays.sort(temp);

            String str = "";
            for (int i = 0; i < temp.length; i++) {
                str += temp[i];
            }
            set.add(str);
            return;
        }

        for (int i=0;i<userId.length;i++) {
            if(check[i] || !userId[i].matches(bannedId[depth])) continue;
            check[i]=true;
            back(depth+1,userId[i]+" "+res,userId,bannedId);
            check[i]=false;
        }
    }

    public static void main(String[] args) {
        불량사용자 solver = new 불량사용자();
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "abc1**"};

        String[] banned_id2 = {"*rodo", "*rodo", "******"};

        String[] banned_id3 = {"fr*d*", "*rodo", "******", "******"};

        System.out.println(solver.solution(user_id, banned_id));
        System.out.println(solver.solution(user_id, banned_id2));
        System.out.println(solver.solution(user_id, banned_id3));
    }
}

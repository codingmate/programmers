import java.util.*;

public class level1_자리수더하기 {
    
    public static void main( String[] args ) {
        Solution s = new Solution();
        System.out.println(s.solution(123));
        System.out.println(s.solution(987));
    }

    public static class Solution {
        public int solution(int n) {
            String strN = Integer.toString(n);
            int answer = 0;
            for ( String N : strN.split("") )
                answer += Integer.parseInt(N);
    
            return answer;
        }
    }
}



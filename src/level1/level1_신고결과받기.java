import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Arrays;

class level1_신고결과받기 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        s.solution(id_list, report, k);
    }
}

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        List<String> idList = Arrays.asList(id_list);
        int[][] matrix = new int[id_list.length][id_list.length];
        
        
        for ( String row : report ) {
            String[] AB = row.split(" ");
            String A = AB[0];
            String B = AB[1];
            matrix[idList.indexOf(A)][idList.indexOf(B)] = 1;
        }

        Set<Integer> stoppedIdxSet = new HashSet<>();
        for ( int col = 0; col < id_list.length; col++ ) {
            int count = 0;
            for ( int row = 0; row < id_list.length; row++ ) {
                if ( matrix[row][col] == 1 ) {
                    count++;
                }
            }
            if ( count >= k ) {
                stoppedIdxSet.add(col);
            }
        }

        for ( int row = 0 ; row < id_list.length; row++ ) {
            for ( int col = 0; col < id_list.length; col++ ) {
                if ( matrix[row][col] == 1
                  && stoppedIdxSet.contains(col) 
                   ) {
                    answer[row]++;
                }
            }
        }
        // for ( int[] row : matrix ) {
        //     for ( int col : row ) {
        //         System.out.print (col + " ");
        //     }
        //     System.out.println();
        // }
        // for (int i = 0; i < answer.length; i++ ) {
        //     System.out.println(answer[i]);
        // }
        
        return answer;
    }

}

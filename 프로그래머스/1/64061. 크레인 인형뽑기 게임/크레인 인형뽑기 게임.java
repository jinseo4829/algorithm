import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer>[] lanes = new Stack[board.length]; //여기스택배열선언하는곳 문법중요
        for(int i = 0; i<lanes.length; i++) {
            lanes[i] = new Stack<>();
        }
        
        for(int i=0; i<board.length; i++) {
            for(int j=board.length-1; j>=0; j--) {
                if(board[j][i] > 0) {
                    lanes[i].push(board[j][i]);
                }
            }
        }
         
        Stack<Integer> bucket = new Stack<>();
        int answer = 0;
        
        for(int move : moves) {
            if(!lanes[move-1].isEmpty()) {
                int doll = lanes[move-1].pop();
                if(!bucket.isEmpty() && bucket.peek() == doll) {
                    bucket.pop();
                    answer += 2;
                }else {
                    bucket.push(doll);
                }
            }
        }
        
        return answer;
    }
}
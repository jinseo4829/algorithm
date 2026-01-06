import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> answer = new ArrayDeque<>();

        int n = progresses.length;
        int[] daysLeft = new int[n];

        for (int i = 0; i < n; i++) {
            daysLeft[i] = (int) Math.ceil(
                (100.0 - progresses[i]) / speeds[i]
            );
        }

        int count = 1;
        int flag = daysLeft[0];

        for (int i = 1; i < n; i++) {
            if (daysLeft[i] <= flag) {
                count++;
            } else {
                answer.add(count);
                count = 1;
                flag = daysLeft[i];
            }
        }

        answer.add(count);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}

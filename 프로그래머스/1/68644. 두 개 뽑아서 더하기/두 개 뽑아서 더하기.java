import java.util.HashSet;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] numbers) {
        
        HashSet<Integer> set = new HashSet<>(); //중복제거를 위한 해시셋
        
        for(int i=0; i<numbers.length-1; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        int[] answer = set.stream().sorted().mapToInt(Integer::intValue).toArray();
        return answer;
        }
}
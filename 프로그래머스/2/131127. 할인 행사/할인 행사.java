import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        
        HashMap<String, Integer> wantMap = new HashMap<>();
        
        for(int i=0; i< want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        int answer = 0;
        for (int i=0; i<discount.length - 9; i++) {
            HashMap<String, Integer> dMap = new HashMap<>();
            
            for(int j=i; j<i+10; j++) {
                if(wantMap.containsKey(discount[j])) {
                    dMap.put(discount[j], dMap.getOrDefault(discount[j], 0) + 1);
                    // 그냥 이 getOrDefault 양식은 외우기
                }
            }
            
            if(wantMap.equals(dMap)) {
                answer++;
            }
        }
        
        return answer;
    }
}
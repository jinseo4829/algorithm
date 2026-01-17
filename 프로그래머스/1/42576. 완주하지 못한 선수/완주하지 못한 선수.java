import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        HashMap<String, Integer> hashMap = new HashMap<>();
        
        for(String key : completion) {
            hashMap.put(key, hashMap.getOrDefault(key, 0) + 1); 
        } // hashMap에서는 그냥 getOrDefault 외워.
        
        for(String name : participant) {
            if(hashMap.getOrDefault(name, 0) == 0) {
                return name;
            }
            hashMap.put(name, hashMap.get(name) - 1);
        }
        return null;
    }
}
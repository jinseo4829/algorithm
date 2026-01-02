import java.util.Stack; 

class Solution {
    boolean solution(String s) {
        
        Stack<Character> stack = new Stack<>();
        
        char[] a = s.toCharArray();
        
        for(char c : a) {
            if(c == '(') {
                stack.push(c);
            }else{
                if(stack.isEmpty() || stack.pop() == c) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}
import java.util.Stack;

class Solution {
    public int solution(String s) {
        
        char[] a = s.toCharArray();
        int k = 0;
        
        for(int i=0; i<a.length; i++) {
            Stack<Character> stack = new Stack<>();
            boolean valid= true;
            
            for(char c : a) {
                if (c == '[' || c == '(' || c == '{') {
                    stack.push(c);
                }else {
                    if(stack.isEmpty()) {
                        valid = false;
                        break;
                    }
                    
                    char top = stack.pop();
                    if(c == ']' && top != '[' ||
                       c == ')' && top != '(' ||
                       c == '}' && top != '{') {
                        valid = false;
                        break;
                    }
                }
            }
            
            if(valid && stack.isEmpty()) {
                k++;
            }
            
            char temp = a[0];
            for(int t=0; t<a.length-1; t++) {
                a[t] = a[t+1];
            }
            a[a.length - 1] = temp;
        }
        
        return k;
    }    
}

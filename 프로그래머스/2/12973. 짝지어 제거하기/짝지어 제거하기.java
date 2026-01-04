import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        char[] a = s.toCharArray();
        
        Stack<Character> stack = new Stack<>();
        
        for(char c : a) {
            
            if(!stack.isEmpty()){
                if(c == stack.peek()) {
                stack.pop();
                }else {
                stack.push(c);
                }
            }else {stack.push(c);
                  }
        }
        
        if(stack.isEmpty()) {
            return 1;
        }else {
            return 0;
        }
    }
}
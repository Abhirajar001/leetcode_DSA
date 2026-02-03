import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for(char c : s.toCharArray()) {

            // push opening brackets
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }

            // check closing brackets
            else if(c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } 
            else if(c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } 
            else if(c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } 
            else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}

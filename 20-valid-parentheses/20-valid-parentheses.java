class Solution {
    public boolean isValid(String s) {
        Stack<Character> validate = new Stack<>(); 
        
        for(int i = 0; i < s.length(); i++) {
            if(validate.isEmpty()) {
                validate.push(s.charAt(i));
            } else if(validate.peek() == '{' && s.charAt(i) == '}') {
                validate.pop();
            } else if(validate.peek() == '(' && s.charAt(i) == ')') {
                validate.pop();
            } else if(validate.peek() == '[' && s.charAt(i) == ']') {
                validate.pop();
            } else {
                validate.push(s.charAt(i));
            }
        }
        
        return validate.isEmpty();
        
        
    }
}
package hard;

import java.util.Stack;

public class LongestValidParantheses_32 {

	public static void main(String[] args) {
		System.out.println("Answer = "+longestValidParenthesesUsingStacks(")()())"));
		
	}
	public static int longestValidParenthesesUsingStacks(String s) {
		if(s.length()==0)
			return 0;
		int maxSoFar =0;
		Stack<Integer> brackets = new Stack<Integer>();
		brackets.push(-1);
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='('){
				brackets.push(i);
			}else {
				if(brackets.peek()!=-1 && s.charAt(brackets.peek())=='(') {
					brackets.pop();
					maxSoFar = Math.max(maxSoFar, i-brackets.peek());
				}else {
					brackets.push(i);
				}
			}
		}
		return maxSoFar;
		
	}
	public static int longestValidParentheses(String s) {

        if(s.length()==0)
            return 0;
        int openCounter =0, closeCounter=0;
        int maxSoFar=0;
        for(int i =0;i<s.length();i++) {
			if(s.charAt(i)=='(') {
				openCounter++;
			}else {
				closeCounter++;
			}
			if(openCounter==closeCounter) {
				maxSoFar = Math.max(maxSoFar, closeCounter*2);
				openCounter=0;
				closeCounter=0;
			}
			if(closeCounter>=openCounter) {
				closeCounter=0;
				openCounter=0;
			}
		}
        closeCounter=0;
		openCounter=0;
        for(int i =s.length()-1;i>=0;i--) {
			if(s.charAt(i)=='(') {
				openCounter++;
			}else {
				closeCounter++;
			}
			if(openCounter==closeCounter) {
				maxSoFar = Math.max(maxSoFar, closeCounter*2);
				openCounter=0;
				closeCounter=0;
			}
			if(openCounter>=closeCounter) {
				closeCounter=0;
				openCounter=0;
			}
		}
        return maxSoFar;
    
		
	}
}

package com.org.problemsolving.ds.first.programming.practice.dynamic;

import java.util.Stack;

public class LongestValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "()(()))))";
		
		Stack<Integer> stack = new Stack<>(); 
		
		char[] charArray = str.toCharArray();
		
		int maxlength = 0;
		int last = -1;
		
		for(int i = 0 ; i < charArray.length ; i++){
			if(charArray[i] == '('){
				stack.push(i);
			}else{
				if (stack.isEmpty()){
					last = i; 
				}else{
					stack.pop();
					if (stack.empty()){
						maxlength = Math.max(maxlength, i - last);
					}else{
						maxlength = Math.max(maxlength, i - stack.peek());
					}
						
				}
			}
		}
		System.out.println(maxlength);
		
	}

}

package ds.programming.practice.recursion;

public class AllStringParttern {

	public static void main(String[] args) {
		printAllPattern(new StringBuffer(), new char[] {'A','B','C'}, 0);
	}
	
	public static void printAllPattern(StringBuffer s , char[] array , int index){
		  
		if(index == array.length) {
			System.out.println(s);
			return;
		} 
		
		printAllPattern(s, array, index+1);
		printAllPattern(s.append(array[index]), array , index+1);	
	}
	
	
}

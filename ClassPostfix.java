import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ClassPostfix {
	
	static Queue<Character> Operants = new LinkedList<>();
	static Stack<Character> Operators = new Stack<>();

	
	public void PostfixMaker(String prefix) {
				
		char[] input = prefix.toCharArray();
		
/*		For-loop that look through every element in the CharArray
*/		
		for(int i=0; i<input.length; i++) {
			
			/*if it's a number, enqueue
			 */			
			if(Character.isDigit(input[i])) {
				Operants.add(input[i]);
			}
			
			/*if it's a operator, call CompareOrder()
			 */
			else {			
				CompareOrder(input[i]);
			}
		}
		
		/*Finally, enqueue every operator that left over in the stack
		 * */
		while (!Operators.isEmpty()) {
			Operants.add(Operators.pop());
		}
		
	}
	
	
	public static void CompareOrder(Character sign) {
		
/*		If the stack is empty, push the sign in first
*/		
		if(Operators.isEmpty()||Operators.peek().equals('(')) {
			Operators.push(sign);
			//System.out.println("Push " + sign.toString());
		}
		
		/*Else see if the top sign in the stack has 
		 * higher precedence than the one passed in
		 * */
		
		else {
			System.out.println(Operators);
			Character temp = Operators.peek();

			if (sign.equals('(')||sign.equals(')')) {

				if (sign.equals('(')) 
					Operators.push(sign);
				if (sign.equals(')')) 
					Paranthesis();
				
			} else {
				/*If it does
				 * pop it form the stack and enqueue.
				 * Then push the current sign in stack.
				 * */
				if (Precedence(temp)>=Precedence(sign)) {
					
					Operants.add(temp);
					Operators.pop();
					Operators.push(sign);	
				}
				/*If it does not
				 * keep it in the stack
				 * Then also push the current sign in stack.
				 * */
				if (Precedence(temp)<Precedence(sign)) {
					Operators.push(sign);
				}
			}
		}	
	}
	
	public static void Paranthesis() {
		while (!Operators.peek().equals('(')) {
			Operants.add(Operators.pop());
		}
		Operators.pop();
	}
	
/*	Assign order of precedence to the sign
*/	
	@SuppressWarnings( "null" )
	public static int Precedence(Character sign) {
		String stringSign = sign.toString();
		if (stringSign.equals(")")) 
			return 0;
		if (stringSign.equals("+")||stringSign.equals("-"))
			return 1;
		if (stringSign.equals("*")||stringSign.equals("/"))
			return 2;
		if (stringSign.equals("^"))
			return 3;
		else {
			System.out.println("Invalid operator.");
			return (Integer) null;
		}
	}
	
	
	public static void print(Queue<Character> Operants) {
		for (Character c : Operants) {
			String temp = c.toString();
			System.out.print(temp + " ");
		}
		System.out.println();
	}
}

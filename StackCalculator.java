import java.util.*;

public class StackCalculator {
	 
   public static Stack<Double> numberStack = new Stack<>();
   
   
   static void Calculator(Queue<Character> input) {
	   
	   char[] operants = new char[input.size()];
	   while (!input.isEmpty())
		   for(int i =0; i<operants.length; i++) {
			   operants[i] = input.remove();
		   }
	   
	  for(int i =0; i<operants.length; i++) {
		  if(Character.isDigit(operants[i])) {
			  numberStack.push((double) (operants[i]-'0')); 
		  }
		  else
			  operator(operants[i]);
	  }
      
   	} 

   
   static void operator (Character sign) {
		System.out.println(numberStack);

	   double result =0;
	  
	   if(sign.toString().equals("+")) {
		   
		   double d1 = (double) numberStack.pop();
		   double d2 = (double) numberStack.pop();
		   result = d1 + d2;
		   numberStack.push(result);
	   }
	   
	   if(sign.toString().equals("-")) {
		   
		   double d1 = (double) numberStack.pop();
		   double d2 = (double) numberStack.pop();
		   result = d2 - d1;
		   numberStack.push(result);
	   }
	   
	   if(sign.toString().equals("*")) {
		   
		   double d1 = (double) numberStack.pop();
		   double d2 = (double) numberStack.pop();
		   result = d1 * d2;
		   numberStack.push(result);	   
	   }
	   
	   if(sign.toString().equals("/")) {
		   
		   double d1 = (double) numberStack.pop();
		   double d2 = (double) numberStack.pop();
		   result = d2 / d1;
		   numberStack.push(result);	   
	   }
	   
	   if(sign.toString().equals("^")) {
		   
		   double d1 = (double) numberStack.pop();
		   double d2 = (double) numberStack.pop();
		   result = Math.pow(d1, d2);
		   numberStack.push(result);	   
	   }
   }   
   
   
	public static void main (String[] args) {
		
		System.out.println("Please enter a valid equation: ");	
		Scanner sc = new Scanner(System.in);	
		
		String PrefixEq = sc.nextLine();;
		System.out.println("You've entered: " +PrefixEq);
		
		
		System.out.println();
		System.out.println("Transfering....");
		ClassPostfix PM = new ClassPostfix();	
		PM.PostfixMaker(PrefixEq);
		System.out.println("Postfix representation: ");
		ClassPostfix.print(ClassPostfix.Operants);
		
		
		System.out.println();
		System.out.println("Calculating....");
		Calculator(ClassPostfix.Operants);
		
		System.out.println();
		System.out.println("Result: ");
		System.out.println(numberStack);
	}
    
}
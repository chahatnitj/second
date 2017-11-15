import java.util.Scanner;
import java.util.Stack;


public class bool {
	public static void main(String [] args)
	{
Scanner s=new Scanner(System.in);
evaluate e=new evaluate();
String str=s.nextLine();
boolean b=e.EvaluateExpression(str);
String r="";
if(b==true)
	r="true";
else
	r="false";
System.out.println("the evaluated expression is "+r);	
}
}

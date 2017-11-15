package permutation;
import java.util.Scanner;
import java.util.Stack;

public class perm {
	
	public static void per(String str,int l,int r)
	{
	        if (l == r)
	            System.out.println(str);
	        else
	        {
	            for (int i = l; i <= r; i++)
	            {
	                str = swap(str,l,i);
	                per(str, l+1, r);
	                str = swap(str,l,i);
	            }
	        }  
	}
	 public static String swap(String a, int i, int j)
	    {
	        char temp;
	        char[] charArray = a.toCharArray();
	        temp = charArray[i] ;
	        charArray[i] = charArray[j];
	        charArray[j] = temp;
	        return String.valueOf(charArray);
}
	
	public static void main(String [] args) {
		Scanner s=new Scanner(System.in);
		String str=s.nextLine();
		per(str,0,str.length()-1);
		
	}

}

package allwords;

import java.util.*;

public class words {
	
	public static int per(ArrayList<String> a,String str,int l,int r)
	{
		if(l>r)
			return 0;
	        if (l == r)
	            a.add(str);
	        else
	        {
	            for (int i = l; i <= r; i++)
	            {
	                str = swap(str,l,i);
	                per(a,str, l+1, r);
	                str = swap(str,l,i);
	            }
	        }  
	        return 0;
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
		int n=str.length();
		int i,j;
		char[] c=str.toCharArray();
		 ArrayList<String> a=new ArrayList<String>();
		for(i=0;i<(1<<n);i++)
		{
			String r="";
			for(j=0;j<n;j++)
			{
				if((i&(1<<j))>0)
				{
					r=r+Character.toString(c[j]);
				}
			}
			per(a,r,0,r.length()-1);
		}
		
		 Collections.sort(a);
	      String t="\0";
	      for(String y:a)
	      {
	    	  if(t.compareTo(y)!=0)
	    	  System.out.println(y);
	    	  t=y;
	      }
		
	}

}

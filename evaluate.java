import java.util.Stack;
public class evaluate implements booleanExpression {
	
	public int prec(char c)
	{
		
		if(c=='A')
			return 2;
		else if(c=='O')
			return 1;
		else 
			return 0;
	}
	public boolean val(char c)
	{
		if(c=='T')
			return true;
		else 
			return false;
	}
	public boolean EvaluateExpression(String s)
	{
		Stack < Character > p=new Stack<>();
		String ans=new String("");
		int n=s.length();
		for(int i=0;i<n;i++)
		{
			char c=s.charAt(i);
			if(c=='T'||c=='F')
				ans=ans+c;
			else if(c=='O'||c=='A')
			{
				while(!p.isEmpty()&&prec(c)<=prec(p.peek()))
				{
					ans=ans+p.pop();
				}
				p.push(c);
			}
			else if(c=='(')
			{
				p.push(c);
			}
			else if(c==')')
			{
				while(!p.isEmpty()&&p.peek()!='(')
					ans=ans+p.pop();
				if(!p.isEmpty()&&p.peek()!='(')
				{
					System.out.println("Invalid Expression");
					return false;
				}
				else
				{
					p.pop();
				}
			}
		}
		while(!p.isEmpty())
			ans=ans+p.pop();
		p.clear();
		n=ans.length();
		for(int i=0;i<n;i++)
		{
			char c=ans.charAt(i);
			if(c=='T'||c=='F')
				p.push(c);
			else if(c=='O'||c=='A')
			{
				char c2=p.pop();
				char c1=p.pop();
				boolean a1=val(c1);
				boolean a2=val(c2);
				boolean ans1;
				if(c=='O')
				{
					ans1=a1||a2;
					if(ans1==true)
						p.push('T');
					else
						p.push('F');
				}
				else
				{
					ans1=a1&&a2;
					if(ans1==true)
						p.push('T');
					else
						p.push('F');
				}
			}
		}
		char res=p.pop();
		if(res=='T')
		   return true;
		else
			return false;

}
}

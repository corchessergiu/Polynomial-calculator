package PrelucrarePolinom;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Verificare {
public Verificare()
{
	
}
public boolean validare1(String s)
{
	  boolean ok=true;
	  if (s.charAt(0)=='^')
	  {
		  ok=false;
	      return ok;
	  }
	   for (int i=0;i<s.length()-1;i++)
	   {
		  if (((s.charAt(i)>='0') && (s.charAt(i)<='9')) && (s.charAt(i+1)=='^'))  //testez cand este de forma 9^
		   {
			   ok=false; 
			   return ok;
		   }
		  if ((s.charAt(i)=='+' && s.charAt(i+1)=='-') || (s.charAt(i)=='-' && s.charAt(i+1)=='+') )
		  {
			  ok=false; 
			   return ok; 
		  }
		  if (s.charAt(i)!='x' && s.charAt(i+1)=='^')
		   {
			   ok=false;
			   return ok;
		   }
		    if (((s.charAt(i)=='x') || (s.charAt(i)=='X'))  && ((s.charAt(i+1)>='0') && (s.charAt(i+1)<='9'))) 
		    	//testez cand este de forma x9
		    {
				   ok=false;  
				   return ok;
			   }
	   }
	   for(int i=0;i<s.length();i++)
	      {
	      if (((s.charAt(i)>='0') && (s.charAt(i)<='9')) || ((s.charAt(i)=='x') || (s.charAt(i)=='X')) || (s.charAt(i)=='^') || (s.charAt(i)=='+') || (s.charAt(i)=='-') || (s.charAt(i)==' '))
	    	  //testez sa nu contina caractere speciale
	    		 ok=true;
           else
           {
         	  ok=false;
         	 return ok;
           }
	      }
	   return ok;  
}
public boolean validare2(String s)
{
	  boolean ok=true;
	  int nrplusminus=0;
	  int nrx=0;
	  Pattern pattern = Pattern.compile("([+-]?[^-+]+)"); 
	   Matcher matcher = pattern.matcher(s); 
	   int x=0;
	   while (matcher.find()) 
	       x=x+1;
	   for (int k=0;k<s.length();k++)
		   if (s.charAt(k)=='x')
			   nrx++;
	     if (nrx>x)
	     {
	    	 ok=false;
	    	 return ok;
	     }
	   for (int i=0;i<s.length();i++)
	     {
	    	 if (s.charAt(i)=='+' || (s.charAt(i)=='-'))
		    	 nrplusminus++;	
	     }
	     if (((s.charAt(0)=='-') || (s.charAt(0)=='+')) && (nrplusminus!=x) && (s.charAt(1)!='x'))  
	    	 //daca am plus sau minus primul semn numarul de monoame trebuie sa fie egal nu numarul de semne din polinom
	      {
	    	  ok=false;
	    	  return ok;
	      }
	      if (x==1 && nrplusminus!=0 && (s.charAt(0)!='+' && (s.charAt(0)!='-')))
	    	  //daca am de exemplu +x sau -x 
	      {
	    	  ok=false;
	    	  return ok;
	      }
	  return ok;
}

public boolean validare3(String s)
{
	 boolean ok=true;
	   for (int i=0;i<s.length()-2;i++) {
		   if (((s.charAt(i)=='x') || (s.charAt(i)=='X')) && ((s.charAt(i+1)=='^')) && ((s.charAt(i+2)=='+') || (s.charAt(i+2)=='-') || (s.charAt(i+2)=='^')))
		   {
		    ok=false;
		    return ok;
		   }
	   }
	   for (int i=0;i<s.length()-3;i++)
	    {
	    	if ((s.charAt(i)>='0') &&(s.charAt(i)<='9') && ((s.charAt(i+1)=='x')|| s.charAt(i+1)=='X') &&(s.charAt(i+2)=='^') && ((s.charAt(i+3)=='+')||(s.charAt(i+3)=='-')))
	    		//testez sa nu fie de forma 3x^+ sau 4x^-
	    	{
	    		ok=false;
	    		return ok;
	    	}
	    }
	   if ((s.charAt(s.length()-1)=='^')|| (s.charAt(s.length()-1)=='+') || (s.charAt(s.length()-1)=='-'))
	   {
		   //testez sa nu am de forma ^+ sau ^-
		   ok=false;
		   return ok;
	   }
	   return ok;
}
public boolean validare(String s) {
	  boolean ok=false;
	   if ( validare1(s) && validare2(s) && validare3(s))
		   ok=true;
	   else
		   ok=false;
	   return ok;
}
}

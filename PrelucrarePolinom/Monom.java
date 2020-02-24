
package PrelucrarePolinom;

import java.awt.geom.Arc2D.Double;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Monom {
private int putere;
private int coeficient;
private char semn;
public Monom()
{
	
}
  public Monom(char semn,int coeficient,int putere)
  {
	  this.putere=putere;
	  this.coeficient=coeficient;
	  this.semn=semn;
  }

  public char getSemn()
  {
	  return this.semn;
  }
  public int getPutere()
  {
	  return this.putere;
  }
  public int getCoeficient()
  {
	  return this.coeficient;
  }
  public String toString()
  {
	  return this.semn+"" +this.coeficient+"x^"+this.putere;
  }
 public ArrayList<Monom> verificareDuplicate(ArrayList<Monom> mon){
		 int i=0;
		 Monom monom1,monom2;
		 int n=mon.size();
		  while (i<n-1) {
			  if (mon.get(i).getPutere()==mon.get(i+1).getPutere()) {
				  monom1=mon.get(i);
				  monom2=mon.get(i+1);
				  mon.remove(monom1);
				  mon.remove(monom2);
				  if (monom1.getSemn()==monom2.getSemn())
				  mon.add(new Monom(monom1.getSemn(),monom1.getCoeficient()+monom2.getCoeficient(),monom1.getPutere()));
				  else
				  {
					  if (monom1.getCoeficient()>monom2.getCoeficient())
						  mon.add(new Monom(monom1.getSemn(),monom1.getCoeficient()-monom2.getCoeficient(),monom1.getPutere()));
					  else
						  mon.add(new Monom(monom2.getSemn(),monom2.getCoeficient()-monom1.getCoeficient(),monom1.getPutere()));
				  }
				  n--;
			  }
			  else
				  i++;
		  }
		  return mon;
	 }
  public void ordonarePolinomCoeficient(ArrayList<Monom> lista)  {
		 lista.sort(new Comparator<Monom>() {
			public int compare(Monom o1, Monom o2) {
				return o2.getCoeficient()-o1.getCoeficient();
			}	 
		 });
	 }
  public void ordonarePolinomPutere(ArrayList<Monom> lista) {
		 lista.sort(new Comparator<Monom>() {
			public int compare(Monom o1, Monom o2) {
				return o2.getPutere()-o1.getPutere();
			}	 
		 });
	 }
  public String getLista(ArrayList<Monom> lista)
  {
 	 String s="";
 	 for (Monom mon:lista)
 		s+=mon.toString();
 	 return s;
  }
  public  ArrayList<Monom> returnareLista(String s)
  {
	  ArrayList<Monom> monoame=new ArrayList<Monom>();
	 String mon;
	 int pozx=0,coef,putere,pozsemn;
	 char semn;
	  Pattern pattern = Pattern.compile("([+-]?[^-+]+)"); 
	   Matcher matcher = pattern.matcher(s); 
	   while (matcher.find()) {	 
		   pozx=-1;
		   pozsemn=-1;
		   coef=0;
		   putere=0;
		   semn='+';
		   mon=matcher.group(1);
		     if (mon.charAt(0)=='+' || mon.charAt(0)=='-')
		    	 semn=mon.charAt(0);
		     for (int i=0;i<mon.length();i++)
		    	 if (mon.charAt(i)=='x')
		    		 pozx=i;
		     for (int i=0;i<mon.length();i++)
		    	  if (mon.charAt(i)=='^')
		    		  pozsemn=i;
		   if (pozx==0) //daca x este pe prima pozitie
					 coef=1;   //=> coeficientul este 1
			   else 
			   {
				   if (pozx==-1)  //daca nu gasesc x in monom 
				   {
					   if ((mon.charAt(0)=='+' || mon.charAt(0)=='-'))  //daca primul caracter este plus sau minus 
						   coef=Integer.parseInt(mon.substring(1,mon.length()));  //copiez in coeficient de pe pozitia 1 pana la finalul monomului
						   else
							 coef=Integer.parseInt(mon.substring(0,mon.length())); //altfel de pe pozitia 0 pana la final
				   }
				   else  //daca x este in monom si nu este pe prima pozitie 
				   {
					   if ((mon.charAt(0)=='+' || mon.charAt(0)=='-') && mon.charAt(1)=='x') //daca avem semn pe prima pozitie 
						   coef=1;
					   else
					   {
						   if ((mon.charAt(0)=='+' || mon.charAt(0)=='-'))
							 coef=Integer.parseInt(mon.substring(1,pozx));
						   else
							   coef=Integer.parseInt(mon.substring(0,pozx));
					   }
				   }
			   }
		     if (pozsemn!=-1)	    	 
		    		 putere=Integer.parseInt(mon.substring(pozx+2,mon.length()));
		    	 else
		    		 putere=1;
		     if (pozx==-1)
		     putere=0;
		  monoame.add(new Monom(semn,coef,putere));	  		
  }
	   ordonarePolinomPutere(monoame);
	   verificareDuplicate(monoame);
	   return monoame;
  }

}


package PrelucrarePolinom;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Interfata.Controler;
import Interfata.View;

public class Polinom {
private Monom mon;
private ArrayList<Monom> polinom;
 public Polinom(Monom mon){
	 this.mon=mon;
 } 
 public Polinom()
 {}
public Polinom(ArrayList<Monom> polinom)
{
	this.polinom=polinom;
}
public ArrayList<Monom> getListaMonoame()
{
	return this.polinom;
}
 public Polinom derivare(Polinom polinom){
	 ArrayList<Monom> monom=polinom.getListaMonoame();
	  ArrayList<Monom> rezultat=new ArrayList<Monom>();
	   for (Monom mon:monom){
		   if (mon.getPutere()!=0)
			   rezultat.add(new Monom(mon.getSemn(),mon.getCoeficient()*mon.getPutere(),mon.getPutere()-1));
		   else
			  rezultat.add(new Monom(mon.getSemn(),0,0));  
	   }   
	   Polinom rez=new Polinom(rezultat);
	   return rez;	 
 }
 public String integrare(Polinom polinom) {
	 ArrayList<Monom> monom=polinom.getListaMonoame();
	 String rezultat="";
	  double fractie;
	   for (Monom mon:monom){
		   if (mon.getPutere()!=0) {			 
			   fractie=(double)mon.getCoeficient()/(mon.getPutere()+1);
			   rezultat+=mon.getSemn()+String.valueOf(fractie)+"x^"+String.valueOf(mon.getPutere()+1);
		   }
		   else
			  rezultat+=mon.getSemn()+String.valueOf(mon.getCoeficient()+"x^1");
	   }       
	    return rezultat;
 }

 public Polinom adunarePolinoame(Polinom p1,Polinom p2) {  
	 ArrayList<Monom> polinom3=new ArrayList<Monom>();
	 ArrayList<Monom> polinom1=p1.getListaMonoame();
	 ArrayList<Monom> polinom2=p2.getListaMonoame();
	 int contine=0,i=0,j=0;
	      while (i<polinom1.size() && j<polinom2.size()) {
	    	  			if ( polinom1.get(i).getPutere()==polinom2.get(j).getPutere() && polinom1.get(i).getCoeficient()==polinom2.get(j).getCoeficient() && polinom1.get(i).getSemn()==polinom2.get(j).getSemn()){
	    	  					polinom3.add(new Monom(polinom1.get(i).getSemn(),polinom1.get(i).getCoeficient()+polinom2.get(j).getCoeficient(),polinom1.get(i).getPutere()));
	    	  					i++;
	    	  					j++;
	    	  			}
	    	  			else
	    	  			 if ( polinom1.get(i).getPutere()==polinom2.get(j).getPutere() && polinom1.get(i).getCoeficient()==polinom2.get(j).getCoeficient() && polinom1.get(i).getSemn()!=polinom2.get(j).getSemn()){
  							 polinom3.add(new Monom('+',0,0));
   	  						i++;
   	  						j++;
  						 } 
	    	  			 else
	    	  				 if ( polinom1.get(i).getPutere()==polinom2.get(j).getPutere() && polinom1.get(i).getCoeficient()>polinom2.get(j).getCoeficient() && polinom1.get(i).getSemn()=='+' && polinom2.get(j).getSemn()=='-') {
	  							 polinom3.add(new Monom(polinom1.get(i).getSemn(),polinom1.get(i).getCoeficient()-polinom2.get(j).getCoeficient(),polinom1.get(i).getPutere()));
	   	  						i++;
	   	  						j++;
	  						 } 
	    	  				 else
	    	  					 if (polinom1.get(i).getPutere()==polinom2.get(j).getPutere() &&  polinom1.get(i).getCoeficient()>polinom2.get(j).getCoeficient() && polinom1.get(i).getSemn()=='-' && polinom2.get(j).getSemn()=='+'){
		  							 polinom3.add(new Monom(polinom1.get(i).getSemn(),polinom1.get(i).getCoeficient()-polinom2.get(j).getCoeficient(),polinom1.get(i).getPutere()));
		   	  						i++;
		   	  						j++;
		  						 } 
	    	  					 else	  						 
	    	  						 if (polinom1.get(i).getPutere()==polinom2.get(j).getPutere() &&  polinom1.get(i).getCoeficient()<polinom2.get(j).getCoeficient() && polinom1.get(i).getSemn()=='-' && polinom2.get(j).getSemn()=='+'){
			  							 polinom3.add(new Monom(polinom2.get(j).getSemn(),polinom2.get(j).getCoeficient()-polinom1.get(i).getCoeficient(),polinom1.get(i).getPutere()));
			   	  						i++;
			   	  						j++;
			  						 } 	
	    	  						 else
	    	  							 if (polinom1.get(i).getPutere()==polinom2.get(j).getPutere() &&  polinom1.get(i).getCoeficient()<polinom2.get(j).getCoeficient() && polinom1.get(i).getSemn()=='+' && polinom2.get(j).getSemn()=='-'){
				  							 polinom3.add(new Monom(polinom2.get(j).getSemn(),polinom2.get(j).getCoeficient()-polinom1.get(i).getCoeficient(),polinom1.get(i).getPutere()));
				   	  						i++;
				   	  						j++;
				  						 } 
	    	  							 else
	    	  							 if (polinom1.get(i).getPutere()==polinom2.get(j).getPutere() &&  polinom1.get(i).getCoeficient()!=polinom2.get(j).getCoeficient() && polinom1.get(i).getSemn()==polinom2.get(j).getSemn()){
				  							 polinom3.add(new Monom(polinom2.get(j).getSemn(),polinom2.get(j).getCoeficient()+polinom1.get(i).getCoeficient(),polinom1.get(i).getPutere()));
				   	  						i++;
				   	  						j++;
				  						 }
	    	  							 else {
	    	  		  	if (polinom1.get(i).getPutere()!=polinom2.get(j).getPutere()){
	    	       	        if (polinom1.get(i).getPutere()>polinom2.get(j).getPutere()){
	    	  		        polinom3.add(new Monom(polinom1.get(i).getSemn(),polinom1.get(i).getCoeficient(),polinom1.get(i).getPutere()));
							i++;
	    	       	        }
	    	       	        else {
	    	       	         if (polinom1.get(i).getPutere()<polinom2.get(j).getPutere())
	    	       	         {
	    	       	         polinom3.add(new Monom(polinom2.get(j).getSemn(),polinom2.get(j).getCoeficient(),polinom2.get(j).getPutere()));
								j++;
	    	       	         }
	    	       	        }
	    	  		  	}    
	    	  		}
	      }
	      while (j<polinom2.size()){
	    	  polinom3.add(new Monom(polinom2.get(j).getSemn(),polinom2.get(j).getCoeficient(),polinom2.get(j).getPutere()));
			  j++;
	      }
	     while(i<polinom1.size()) {
	    	  polinom3.add(new Monom(polinom1.get(i).getSemn(),polinom1.get(i).getCoeficient(),polinom1.get(i).getPutere()));
	    	  i++;
	      }
	   	Polinom polinom=new Polinom(polinom3);
	   	return polinom;
	 }
public Polinom scaderePolinoame(Polinom p1,Polinom p2) {
	 ArrayList<Monom> polinom1=p1.getListaMonoame();
	 ArrayList<Monom> polinom2=p2.getListaMonoame();
	   String s2="",s3="",monn="",pol="";
	   for (Monom monnn:polinom2)
		   s2+=monnn.toString();
	   ArrayList<Monom> polinominversat=new ArrayList<Monom>();
	   Pattern pattern = Pattern.compile("([+-]?[^-+]+)"); 
	   Matcher matcher = pattern.matcher(s2); 
	   while (matcher.find())  {
		   monn=matcher.group(1);
		    if (monn.charAt(0)=='+')
		    	s3+='-'+monn.substring(1,monn.length());
		    if (monn.charAt(0)=='-')
		    	s3+='+'+monn.substring(1,monn.length());
		    if (monn.charAt(0)=='x')
		    	s3+="-x"+monn.substring(1,monn.length());
		    if ((monn.charAt(0)>'0') && (monn.charAt(0)<'9'))
		    	s3+='-'+monn.substring(0,monn.length());
	   }

	   polinominversat=mon.returnareLista(s3);
	   Polinom pol1=new Polinom(polinom1);
	   Polinom pol2=new Polinom(polinominversat);
	   Polinom rezultat=adunarePolinoame(pol1,pol2);
	   ArrayList<Monom> polinom3=rezultat.getListaMonoame();
	   Polinom rez=new Polinom(polinom3);
	   return rez;
   }

   public Polinom inmultire(Polinom p1, Polinom p2)
   {
	   ArrayList<Monom> rezultat=new ArrayList<Monom>();
		 ArrayList<Monom> polinom1=p1.getListaMonoame();
		 ArrayList<Monom> polinom2=p2.getListaMonoame();
	   for (Monom pol:polinom1) {
		   for (Monom pol2:polinom2){
			   if (pol.getSemn()!=pol2.getSemn()) //deci unul + unul - inmultite =>-
			   rezultat.add(new Monom('-',pol.getCoeficient()*pol2.getCoeficient(),pol.getPutere()+pol2.getPutere()));
			   else
			   rezultat.add(new Monom('+',pol.getCoeficient()*pol2.getCoeficient(),pol.getPutere()+pol2.getPutere())) ;
		   }
	   }
	   Polinom rez=new Polinom(rezultat);
	   return rez;
   }
public String impartire(Polinom p1,Polinom p2)
   {
	   ArrayList<Monom> polinom1=p1.getListaMonoame();
	   ArrayList<Monom> polinom2=p2.getListaMonoame();
	   ArrayList<Monom> faraduplicate1=mon.verificareDuplicate(polinom1);
	   ArrayList<Monom> faraduplicate2=mon.verificareDuplicate(polinom2);
	   String rezimpartire="",sirdoi="",rezinmultire="",rezultatanterior="",cat="",rest="",rezultatt="";
	   ArrayList<Monom> rezultatinmultire=new ArrayList<Monom>();
	   ArrayList<Monom> rezultatscadere=faraduplicate1;
	   ArrayList<Monom> aldoilea=faraduplicate2;
	   mon.ordonarePolinomPutere(faraduplicate1);
	   mon.ordonarePolinomPutere(faraduplicate2);
	   for (Monom doi:aldoilea)
		   sirdoi+=doi.getSemn()+String.valueOf(doi.getCoeficient())+"x^"+String.valueOf(doi.getPutere());
	   for (Monom duplicate:faraduplicate1)
		   rezultatanterior+=duplicate.getSemn()+String.valueOf(duplicate.getCoeficient())+"x^"+String.valueOf(duplicate.getPutere());
	   if (rezultatscadere.get(0).getPutere()>=aldoilea.get(0).getPutere() && rezultatscadere.get(0).getCoeficient()%aldoilea.get(0).getCoeficient()==0 && rezultatscadere.get(0).getPutere()!=0 && aldoilea.get(0).getPutere()!=0) {
	    while (rezultatscadere.get(0).getPutere()>=aldoilea.get(0).getPutere() &&  rezultatscadere.get(0).getCoeficient()%aldoilea.get(0).getCoeficient()==0){
	    	rezimpartire="";
	    	rest="";
	    	int catesereduc=0;
	    	if (rezultatscadere.get(0).getCoeficient()>aldoilea.get(0).getCoeficient() && aldoilea.get(0).getPutere()!=0)
	    	{
	    		if (rezultatscadere.get(0).getSemn()=='+' && aldoilea.get(0).getSemn()=='-')
	    			rezimpartire+=rezultatscadere.get(0).getSemn()+String.valueOf(rezultatscadere.get(0).getCoeficient()/aldoilea.get(0).getCoeficient())+"x^"+String.valueOf(rezultatscadere.get(0).getPutere()-aldoilea.get(0).getPutere());
	    		if (rezultatscadere.get(0).getSemn()=='-' && aldoilea.get(0).getSemn()=='+')
	    			rezimpartire+=rezultatscadere.get(0).getSemn()+String.valueOf(rezultatscadere.get(0).getCoeficient()/aldoilea.get(0).getCoeficient())+"x^"+String.valueOf(rezultatscadere.get(0).getPutere()-aldoilea.get(0).getPutere());
	    		if (rezultatscadere.get(0).getSemn()==aldoilea.get(0).getSemn())
    			rezimpartire+=rezultatscadere.get(0).getSemn()+String.valueOf(rezultatscadere.get(0).getCoeficient()/aldoilea.get(0).getCoeficient())+"x^"+String.valueOf(rezultatscadere.get(0).getPutere()-aldoilea.get(0).getPutere());
	     }
	    	else
	    	{
	    		if (rezultatscadere.get(0).getCoeficient()<aldoilea.get(0).getCoeficient())
	    		{
	    		if (rezultatscadere.get(0).getSemn()=='+' && aldoilea.get(0).getSemn()=='-')
	    			rezimpartire+=aldoilea.get(0).getSemn()+String.valueOf(rezultatscadere.get(0).getCoeficient()/aldoilea.get(0).getCoeficient())+"x^"+String.valueOf(rezultatscadere.get(0).getPutere()-aldoilea.get(0).getPutere());
	    		if (rezultatscadere.get(0).getSemn()=='-' && aldoilea.get(0).getSemn()=='+')
	    			rezimpartire+=aldoilea.get(0).getSemn()+String.valueOf(rezultatscadere.get(0).getCoeficient()/aldoilea.get(0).getCoeficient())+"x^"+String.valueOf(rezultatscadere.get(0).getPutere()-aldoilea.get(0).getPutere());
	    		if (rezultatscadere.get(0).getSemn()==aldoilea.get(0).getSemn())
	    			rezimpartire+=aldoilea.get(0).getSemn()+String.valueOf(rezultatscadere.get(0).getCoeficient()/aldoilea.get(0).getCoeficient())+"x^"+String.valueOf(rezultatscadere.get(0).getPutere()-aldoilea.get(0).getPutere());
	    		}
	    		else
	    		{
	    			if (rezultatscadere.get(0).getCoeficient()==aldoilea.get(0).getCoeficient() && rezultatscadere.get(0).getSemn()==aldoilea.get(0).getSemn())
	    			{
                         rezimpartire+="+"+String.valueOf(rezultatscadere.get(0).getCoeficient()/aldoilea.get(0).getCoeficient())+"x^"+String.valueOf(rezultatscadere.get(0).getPutere()-aldoilea.get(0).getPutere());
	    			}
	    			if (rezultatscadere.get(0).getCoeficient()==aldoilea.get(0).getCoeficient() && rezultatscadere.get(0).getSemn()!=aldoilea.get(0).getSemn())
	    			{
	    				 rezimpartire+="-"+String.valueOf(rezultatscadere.get(0).getCoeficient()/aldoilea.get(0).getCoeficient())+"x^"+String.valueOf(rezultatscadere.get(0).getPutere()-aldoilea.get(0).getPutere());
	    			}
	    		}
	    	}	  
	      ArrayList<Monom> rezultatimpartiree=mon.returnareLista(rezimpartire);
	   	  ArrayList<Monom> sirdoii=mon.returnareLista(sirdoi);
	   	  Polinom pol1=new Polinom(rezultatimpartiree);
		  Polinom pol2=new Polinom(sirdoii);
		  Polinom rezz=inmultire(pol1,pol2);
	      rezultatinmultire=rezz.getListaMonoame();
	    	rezinmultire="";
	 	   for (Monom rez:rezultatinmultire)
			   rezinmultire+=rez.getSemn()+String.valueOf(rez.getCoeficient())+"x^"+String.valueOf(rez.getPutere());
	 	 ArrayList<Monom> rezant=mon.returnareLista(rezultatanterior);
	 	 ArrayList<Monom> rezinmul=mon.returnareLista(rezinmultire);
	 	 Polinom pol11=new Polinom(rezant);
		 Polinom pol22=new Polinom(rezinmul);
		 Polinom scadere=scaderePolinoame(pol11,pol22);
	 	 rezultatscadere=scadere.getListaMonoame();
	 	   rezultatanterior="";
	 	   mon.ordonarePolinomCoeficient(rezultatscadere);//in cazul in care o sa am ca rest elementul liber
	 	   for (int i=rezultatscadere.size()-1;i>0;i--)
	 	   {
	 		   if (rezultatscadere.get(i).getCoeficient()==0)
	 			   catesereduc++;
	 		   else
	 			   break;
	 	   }
		   for (int j=0;j<rezultatscadere.size()-catesereduc;j++) //pe ultima pozitie voi avea 0x^0
			   rezultatanterior+=rezultatscadere.get(j).getSemn()+String.valueOf(rezultatscadere.get(j).getCoeficient())+"x^"+String.valueOf(rezultatscadere.get(j).getPutere());
			mon.ordonarePolinomPutere(rezultatscadere);
	 		cat+=rezimpartire;
	 		if (rezultatanterior!="")
	 		rest+=rezultatanterior;
	     }
	   }
	    else
	    	if (rezultatscadere.get(0).getPutere()<aldoilea.get(0).getPutere() || rezultatscadere.get(0).getPutere()==0 || aldoilea.get(0).getPutere()==0)
	    return "Impartire imposibila ";
	    	else
	    		return "Coeficientii nu se impart exact!";
	   return "Cat: "+cat+" rest "+rest;
   }
}
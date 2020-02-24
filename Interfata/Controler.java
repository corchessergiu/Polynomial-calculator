package Interfata;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import PrelucrarePolinom.Monom;
import PrelucrarePolinom.Polinom;
import PrelucrarePolinom.Verificare;

public class Controler {
private View view;
private Polinom polinom;
private Verificare verificare;
private Monom mon;
public Controler()
{}
  public Controler(View view,Polinom polinom,Monom mon,Verificare verificare)
  {
	   this.polinom=polinom;
	   this.mon=mon;
	   this.view=view;
	   this.verificare=verificare;
	   this.view.addListenerValidare(new ListenerValidare());
	   this.view.addListenerSuma(new ListenerSuma());
	   this.view.addListenerDiferenta(new ListenerDiferenta());
	   this.view.addListenerDerivare(new ListenerDerivare());
	   this.view.addListenerIntegrare(new ListenerIntegrare());
	   this.view.addListenerInmultire(new ListenerInmultire());
	   this.view.addListenrImpartire(new ListenerImpartire());
  }
	class ListenerValidare implements ActionListener {
	public void actionPerformed(ActionEvent e)  {
			if (verificare.validare(view.getPolinomOne()))
			  view.pol1mesaj.setText("Polinom valid");	
			  	else
			  view.pol1mesaj.setText("Polinom invalid");
			if (verificare.validare(view.getPolinomTwo()))
				view.pol2mesaj.setText("Polinom valid");	
		  	else
		  view.pol2mesaj.setText("Polinom invalid");
 
}
}
	class ListenerSuma implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if (verificare.validare(view.getPolinomOne()) && verificare.validare(view.getPolinomTwo()))
			{
			String s="";
			ArrayList<Monom> suma=new ArrayList<Monom>();
			Polinom pol1=new Polinom(mon.returnareLista(view.getPolinomOne()));
			Polinom pol2=new Polinom(mon.returnareLista(view.getPolinomTwo()));
			Polinom rezultat=polinom.adunarePolinoame(pol1,pol2);
			suma=rezultat.getListaMonoame();
		     for (Monom mo:suma)
		    	 s+=mo.toString();
		   view.atasarerez.setText(s);
		   view.operatie.setText("adunare");
			}
			else
				view.atasarerez.setText("Unul sau ambele polinoame incorecte!");
		}
	}
	    class ListenerDiferenta implements ActionListener{

			public void actionPerformed(ActionEvent e) {
			  if (verificare.validare(view.getPolinomOne()) && verificare.validare(view.getPolinomTwo()))
			  {
				  String s="";
					ArrayList<Monom> diferenta=new ArrayList<Monom>();
					Polinom pol1=new Polinom(mon.returnareLista(view.getPolinomOne()));
					Polinom pol2=new Polinom(mon.returnareLista(view.getPolinomTwo()));
					Polinom rezultat=polinom.scaderePolinoame(pol1,pol2);
				  diferenta=rezultat.getListaMonoame();
					mon.ordonarePolinomPutere(diferenta);
					mon.verificareDuplicate(diferenta);
				  for (Monom monom:diferenta)
					  s+=monom.toString();
				  view.atasarerez.setText(s);
				  view.operatie.setText("scadere");
			  }
			  else
				  view.atasarerez.setText("Unul sau ambele polinoame incorecte");	
			}
	    }
	class ListenerDerivare implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			  if (verificare.validare(view.getPolinomOne()) && verificare.validare(view.getPolinomTwo()))
			  {
				  String s="";
				  Polinom pol=new Polinom(mon.returnareLista(view.getPolinomOne()));
				  Polinom rezultat=polinom.derivare(pol);
				  ArrayList<Monom> rez=rezultat.getListaMonoame();
				  for (Monom r:rez)
					  s+=r.toString();
				  view.atasarerez.setText(s);
				  view.operatie.setText("derivare");
			  }
			  else
				  view.atasarerez.setText("Primul polinom este incorect!");	
			
		}	
	}
	class ListenerIntegrare implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if (verificare.validare(view.getPolinomOne()) && verificare.validare(view.getPolinomTwo()))
			  {
				  Polinom pol=new Polinom(mon.returnareLista(view.getPolinomOne()));
				  String s="";
				  s=polinom.integrare(pol);
				  view.atasarerez.setText(s);
				  view.operatie.setText("integrare");
			  }
			  else
				  view.atasarerez.setText("Primul polinom este incorect!");	
			
		}
		}

    	class ListenerInmultire implements ActionListener{

				public void actionPerformed(ActionEvent e) {
					if (verificare.validare(view.getPolinomOne()) && verificare.validare(view.getPolinomTwo()))
					  {
						  String s="";
						  ArrayList<Monom> inmultire=new ArrayList<Monom>();
							Polinom pol1=new Polinom(mon.returnareLista(view.getPolinomOne()));
							Polinom pol2=new Polinom(mon.returnareLista(view.getPolinomTwo()));
							Polinom rezultat=polinom.inmultire(pol1,pol2);
							inmultire=rezultat.getListaMonoame();
							mon.ordonarePolinomPutere(inmultire);
							mon.verificareDuplicate(inmultire);
						  for (Monom monom:inmultire)
							  s+=monom.toString();
						  view.atasarerez.setText(s);
						  view.operatie.setText("inmultire");
					  }
					  else
						  view.atasarerez.setText("Unul sau ambele polinoame incorecte");	
					
				}
			}
    	class ListenerImpartire implements ActionListener{

			public void actionPerformed(ActionEvent e) {
				if (verificare.validare(view.getPolinomOne()) && verificare.validare(view.getPolinomTwo()))
				  {
					  String impartire;
						Polinom pol1=new Polinom(mon.returnareLista(view.getPolinomOne()));
						Polinom pol2=new Polinom(mon.returnareLista(view.getPolinomTwo()));
					  impartire=polinom.impartire(pol1,pol2);
					view.atasarerez.setText(impartire);
				    view.operatie.setText("impartire");
				  }
				else
					  view.atasarerez.setText("Unul dintre polinoame este incorect!");
			}
    		
    	}	
    }


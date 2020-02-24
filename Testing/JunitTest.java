package Testing;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import PrelucrarePolinom.Monom;
import PrelucrarePolinom.Polinom;
import PrelucrarePolinom.Verificare;
import static org.junit.Assert.assertArrayEquals;
public class JunitTest {
 Verificare verificare=new Verificare();
 Polinom polinom=new Polinom();
 Monom monom=new Monom();
private	String polinom1="+x^7+1x";
private	String polinom2="x";
private String polinom3="2+1x^+1";
  @Test
  public void testareValidareCorecta() {
	  boolean ok=verificare.validare(polinom1);
		  assertTrue(ok);
  }
  @Test
  public void testareValidareIncorecta() {
	  boolean ok=verificare.validare(polinom3);
		  assertTrue(ok);
  }
  @Test
  public void testAdunare()
  {
	  ArrayList<Monom> pol1=monom.returnareLista(polinom1);
	  ArrayList<Monom> pol2=monom.returnareLista(polinom2);
	  Polinom p1=new Polinom(pol1);
	  Polinom p2=new Polinom(pol2);
	  String s1="+1x^7+2x^1";
	  Polinom pol=polinom.adunarePolinoame(p1, p2);
	  ArrayList<Monom> lista=pol.getListaMonoame();
	  String s=monom.getLista(lista);
	  assertEquals(s1,s);
  } 
   @Test
   public void testDerivare()
   {
 	  ArrayList<Monom> pol1=monom.returnareLista(polinom1);
 	  Polinom p1=new Polinom(pol1);
 	  String s1="+7x^6+1x^0";
 	   Polinom pol=polinom.derivare(p1);
	  ArrayList<Monom> lista=pol.getListaMonoame();
 	  String s=monom.getLista(lista);
 	  assertEquals(s1,s);
   } 
   @Test
   public void testIntegrare()
   {
 	  ArrayList<Monom> pol1=monom.returnareLista(polinom1);
 	  Polinom p1=new Polinom(pol1);
 	  String s1="+0.125x^8+0.5x^2";
 	  String s=polinom.integrare(p1);
 	  assertEquals(s1,s);
   } 
   @Test
   public void testInmultire()
   {
 	  ArrayList<Monom> pol1=monom.returnareLista(polinom1);
	  ArrayList<Monom> pol2=monom.returnareLista(polinom2);
	  Polinom p1=new Polinom(pol1);
	  Polinom p2=new Polinom(pol2);
	  Polinom pol=polinom.inmultire(p1, p2);
	  ArrayList<Monom> lista=pol.getListaMonoame();
 	  String s1="+1x^8+1x^2";
 	  String s=monom.getLista(lista);
	  assertEquals(s1,s);
   } 
}
  /* @Test
   public void testImpartire()
   {
 	  ArrayList<Monom> pol1=monom.returnareLista(polinom1);
	  ArrayList<Monom> pol2=monom.returnareLista(polinom2);
	  Polinom p1=new Polinom(pol1);
	  Polinom p2=new Polinom(pol2);
 	  String s1="Cat: +1x^6+1x^0 rest +0x^0";
 	  String s=polinom.impartire(p1, p2);
 	  System.out.println(s);
	  assertEquals(s1,s);
   }
   @Test
   public void testScadere()
   {
 	  ArrayList<Monom> pol1=monom.returnareLista(polinom1);
 	  ArrayList<Monom> pol2=monom.returnareLista(polinom2);
 	  Polinom p1=new Polinom(pol1);
 	  Polinom p2=new Polinom(pol2);
 	 Polinom pol=polinom.scaderePolinoame(p1, p2);
	  ArrayList<Monom> lista=pol.getListaMonoame();
 	  String s1="+1x^7+0x^0";
       String s=monom.getLista(lista);
 	  System.out.print(s1+" "+s);
 	  assertEquals(s1,s);
   }*/

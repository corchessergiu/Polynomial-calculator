package Interfata;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class View {
private JFrame frame=new JFrame("Tema1");
private JTextArea pol1=new JTextArea();
private  JTextArea pol2=new JTextArea();
public JTextArea operatie=new JTextArea();
private JButton validarepol=new JButton("Verificati daca ati introdus corect polinoamele!");
private JButton adunare=new JButton("Adunare");
private JButton diferenta=new JButton("Scadere");
private JButton inmultire=new JButton("Inmultire");
private JButton impartire=new JButton("Impartire");
private JButton derivare=new JButton("Derivare");
private JButton integrare=new JButton("Integrare");
private  JLabel polinom1=new JLabel("Introduceti primul polinom:");
private  JLabel polinom2=new JLabel("Introduceti al doilea polinom:");
private  JLabel mesaj=new JLabel("Alegeti operatia pe care doriti sa o efectuati!");
private  JLabel mesaj1=new JLabel("Primul polinom este: ");
public  JTextArea pol1mesaj=new JTextArea();
public  JTextArea pol2mesaj=new JTextArea();
private  JLabel mesaj2=new JLabel("Al doilea polinom este: ");
private  JLabel mesajrezultat=new JLabel("Rezultatul operatiei de ");
private JLabel este=new JLabel("este: ");
public JTextArea atasarerez=new JTextArea();
   public View()
   {
	   frame.setSize(720,440);
	   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   frame.setVisible(true);
	   Initializare();
   }
   public void Initializare()
   {
	   JPanel panel=new JPanel();
	   panel.setLayout(null);
	   polinom1.setBounds(35, 10,190,20);
	   polinom2.setBounds(35, 40,190,20);
	   pol1.setBounds(210, 10,180,20);
	   pol2.setBounds(210, 40,180,20);
	   validarepol.setBounds(30,75,300,20);
	   mesaj.setBounds(230,220,300,20);
	   mesaj1.setBounds(35,110,200,20);
	   mesaj2.setBounds(35,140,200,20);
	   pol1mesaj.setBounds(180, 110,100,20);
	   pol2mesaj.setBounds(180, 140,100,20);
	   adunare.setBounds(30, 250,90,40);
	   diferenta.setBounds(140,250,90,40);
	   inmultire.setBounds(250,250,90,40);
	   impartire.setBounds(365,250,90,40);
	   derivare.setBounds(475,250,90,40);
	   integrare.setBounds(590,250,90,40);
	   mesajrezultat.setBounds(30, 310,140,20);
	   operatie.setBounds(164,310,70,20);
	   este.setBounds(240,310,50,20);
	   atasarerez.setBounds(280,310,320,20);
	   panel.add(operatie);
	   panel.add(este);
	   panel.add(mesaj1);
	   panel.add(mesaj2);
	   panel.add(pol1mesaj);
	   panel.add(pol2mesaj);
	   panel.add(validarepol);
	   panel.add(atasarerez);
	   panel.add(mesajrezultat);
	   panel.add(integrare);
	   panel.add(derivare);
	   panel.add(impartire);
	   panel.add(inmultire);
	   panel.add(diferenta);
	   panel.add(mesaj);
	   panel.add(pol2);
	   panel.add(polinom2);
	   panel.add(adunare);
	   panel.add(polinom1);
	   panel.add(pol1);
	   frame.add(panel);
   }
   public String getPolinomOne()
   {
	   return pol1.getText();
   }
   public String getPolinomTwo()
   {
	   return pol2.getText();
   }
   public void addListenerValidare(ActionListener valid)
   {
	   validarepol.addActionListener(valid);
   }
   public void addListenerSuma(ActionListener suma)
   {
	   adunare.addActionListener(suma);
   }
   public void addListenerDiferenta(ActionListener dif)
   {
	   diferenta.addActionListener(dif);
   }
   public void addListenerDerivare(ActionListener deriv)
   {
	   derivare.addActionListener(deriv);
   }
   public void addListenerIntegrare(ActionListener integ)
   {
	   integrare.addActionListener(integ);
   }
   public void addListenerInmultire(ActionListener inmul)
   {
	   inmultire.addActionListener(inmul);
   }
   public void addListenrImpartire(ActionListener impar)
   {
	   impartire.addActionListener(impar);
   }
}

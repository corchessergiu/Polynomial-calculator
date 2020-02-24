package PrelucrarePolinom;
import Interfata.Controler;
import Interfata.View;
public class Main {

	public static void main(String[] args) {
		View view=new View();
		Monom monom=new Monom();
		Controler contt=new Controler();
		Polinom pol=new Polinom(monom);
		Verificare verificare=new Verificare();
		Controler cont=new Controler(view,pol,monom,verificare);
	}

}


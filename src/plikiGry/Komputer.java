package plikiGry;
class Komputer extends Gracz
{
	private java.util.Random rand;
	Komputer(byte znak, Plansza plansza)
	{
		super(znak, plansza,"komputer");
		rand=new java.util.Random();
	}
	void ruch(){
		byte[] dost�pneRuchy=p.pustePola();
		super.ruch(dost�pneRuchy[rand.nextInt(dost�pneRuchy.length)]);
	}
}
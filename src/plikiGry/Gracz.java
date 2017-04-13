package plikiGry;
class Gracz
{
	java.io.PrintStream out=System.out;
	Plansza p;
	private final byte znak;
	final String name;
	
	Gracz(byte znak,Plansza plansza,String name)
	{
		this.name=name;
		this.znak=znak;
		this.p=plansza;
	}

	void ruch(byte poleNaKtóreUstawiamySwójZnak){		
		while(!p.ustaw(poleNaKtóreUstawiamySwójZnak, znak)){}
	}
	void ruch(){
		do{
			out.println("Wybierz pole.");
		}while(!p.ustaw((byte) (Byte.valueOf(Gra.input.next())-1), znak));
	}
	boolean czyWygrana(){
		return p.czyWygrana(this.znak);
	}
}

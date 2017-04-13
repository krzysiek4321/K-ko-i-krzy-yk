package plikiGry;
/**
 * @author U�ytkownik
 * 
 */
public class Gra
{
	protected static java.util.Scanner input=new java.util.Scanner(System.in);
	protected static java.util.Random rand=new java.util.Random();
	private Plansza plansza;
	private Gracz[] gracze;
	private int czyjaRunda;
	public Gra()
	{
		plansza=new Plansza();
		gracze=new Gracz[2];
	}
	
	private void ustawienieGraczy(){
		wyb�rTrybuGry:while(true){
			String wejscie=input.next();
			try
			{
				int wyb�r=Integer.valueOf(wejscie);
				if(wyb�r==1){
					gracze[0]=new Gracz((byte)1, plansza,"gracz");
					gracze[1]=new Komputer((byte) -1, plansza);
					czyjaRunda=rand.nextInt(2);
					break wyb�rTrybuGry;
				}
				else if(wyb�r==2){
					gracze[0]=new Gracz((byte)1, plansza, "gracz 1");
					gracze[1]=new Gracz((byte) -1, plansza,"gracz 2");
					czyjaRunda=rand.nextInt(2);
					break wyb�rTrybuGry;
				}
				else{
					System.out.println("Z�y numer (wpisz '1' lub '2')");
				}
			} catch (NumberFormatException e)
			{
				System.out.println("Z�y typ danych. (wpisz '1' lub '2')");
			}
		}
	}
	public void start(){
		//Wyb�r trybu gry
		System.out.println("Witaj w \"K�ko i krzy�yk\"");
		System.out.println("Wybierz tryb gry.");
		System.out.println("1. Gracz kontra komputer.");
		System.out.println("2. Gracz kontra gracz.");
		// Ustawianie graczy
		ustawienieGraczy();
		//rozgrywka
		while(true){
			System.out.format("Teraz ruch wykonuje %s%n",gracze[czyjaRunda].name.toUpperCase());
			//prezentacja planszy
			System.out.println(plansza);
			//wyonanie ruchu
			gracze[czyjaRunda].ruch();
			//sprawdzenie wygranej
			if(gracze[czyjaRunda].czyWygrana()){
				System.out.println("Mamy zwyci�zc�!");
				System.out.format("Wygra� %s%n",gracze[czyjaRunda].name.toUpperCase());
				System.out.println(plansza);
				break;
			}
			else{
				czyjaRunda=++czyjaRunda%2;
			}
		}
		
	}

}

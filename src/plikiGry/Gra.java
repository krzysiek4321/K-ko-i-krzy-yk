package plikiGry;
/**
 * @author U¿ytkownik
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
		wybórTrybuGry:while(true){
			String wejscie=input.next();
			try
			{
				int wybór=Integer.valueOf(wejscie);
				if(wybór==1){
					gracze[0]=new Gracz((byte)1, plansza,"gracz");
					gracze[1]=new Komputer((byte) -1, plansza);
					czyjaRunda=rand.nextInt(2);
					break wybórTrybuGry;
				}
				else if(wybór==2){
					gracze[0]=new Gracz((byte)1, plansza, "gracz 1");
					gracze[1]=new Gracz((byte) -1, plansza,"gracz 2");
					czyjaRunda=rand.nextInt(2);
					break wybórTrybuGry;
				}
				else{
					System.out.println("Z³y numer (wpisz '1' lub '2')");
				}
			} catch (NumberFormatException e)
			{
				System.out.println("Z³y typ danych. (wpisz '1' lub '2')");
			}
		}
	}
	public void start(){
		//Wybór trybu gry
		System.out.println("Witaj w \"Kó³ko i krzy¿yk\"");
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
				System.out.println("Mamy zwyciêzcê!");
				System.out.format("Wygra³ %s%n",gracze[czyjaRunda].name.toUpperCase());
				System.out.println(plansza);
				break;
			}
			else{
				czyjaRunda=++czyjaRunda%2;
			}
		}
		
	}

}

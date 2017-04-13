package plikiGry;
import java.util.Arrays;
import java.util.HashMap;

class Plansza
{
	private static HashMap<Byte, Character> notacja;
	private byte[] plansza;
	Plansza()
	{	
		HashMap<Byte, Character> map=new HashMap<Byte,Character>();
		map.put((byte) -1, 'O');
		map.put((byte) 1, 'X');
		map.put((byte) 0, '~');
		notacja=map;
		plansza=new byte[9];
		Arrays.fill(plansza, (byte)0);
	}
	byte[] pustePola(){
		int ile=0;
		for(byte b:plansza){
			if(Byte.compare(b, (byte) 0)==0){
				ile++;
			}
		}
		byte[] wynik=new byte[ile];
		for(int i=0,pom=0;i<plansza.length;i++){
			if(Byte.compare(plansza[i], (byte) 0)==0){
				wynik[pom++]=(byte) i;
			}
		}
		return wynik;
	}

	boolean ustaw(byte pole,byte war){
		boolean udałoSię=false;
		try
		{
			if(Byte.compare(plansza[pole], (byte) 0)==0){
				plansza[pole]=war;
				udałoSię=true;
			}
			else{
				System.out.println("Podałeś zajęte pole, spróbuj ponownie.");
			}
		} catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Podałeś żły numer pola");
		}
		return udałoSię;
	}

	boolean czyWygrana(byte znak){
		boolean czy=false;
		for(int i: new int[]{0,1,2}){
			//Sprawdzanie po wierszach
			if(Byte.compare(znak, plansza[i])==0 
					&& Byte.compare(znak, plansza[i+1])==0
					&& Byte.compare(znak, plansza[i+2])==0)
				czy=true;
			//Sprawdzanie po kolumnach
			else if(Byte.compare(znak, plansza[i])==0 
					&& Byte.compare(znak, plansza[i+3])==0
					&& Byte.compare(znak, plansza[i+6])==0)
				czy=true;
		}
		if(Byte.compare(znak, plansza[0])==0 
					&& Byte.compare(znak, plansza[4])==0
					&& Byte.compare(znak, plansza[8])==0)
			czy=true;
		else if(Byte.compare(znak, plansza[2])==0 
					&& Byte.compare(znak, plansza[4])==0
					&& Byte.compare(znak, plansza[6])==0)
			czy=true;
		return czy;
	}
	
	public String toString(){
		String wynik="";
		wynik+=String.format("%s%s%s\n", notacja.get(plansza[0]),notacja.get(plansza[1]),notacja.get(plansza[2]));
		wynik+=String.format("%s%s%s\n", notacja.get(plansza[3]),notacja.get(plansza[4]),notacja.get(plansza[5]));
		wynik+=String.format("%s%s%s\n", notacja.get(plansza[6]),notacja.get(plansza[7]),notacja.get(plansza[8]));
		
		return wynik;
	}
}
package domain;

public class Emp {

	private int id_pracownik;
	private String imie;
	private String nazwisko;
	private String stanowisko;
	private int pesel;
	private int pensja;	
	
	public Emp() {
	}
	
	public Emp(String imie, 
			String nazwisko,
			String stanowisko, 
			int pesel,
			int pensja) {
		super();
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.stanowisko = stanowisko;
		this.pesel = pesel;
		this.pensja = pensja;
	}

	public int getId_pracownik() {
		return id_pracownik;
	}

	public void setId_pracownik(int id_pracownik) {
		this.id_pracownik = id_pracownik;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getStanowisko() {
		return stanowisko;
	}

	public void setStanowisko(String stanowisko) {
		this.stanowisko = stanowisko;
	}

	public int getPesel() {
		return pesel;
	}

	public void setPesel(int pesel) {
		this.pesel = pesel;
	}

	public int getPensja() {
		return pensja;
	}

	public void setPensja(int pensja) {
		this.pensja = pensja;
	}
}

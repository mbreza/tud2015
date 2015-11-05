package domain;


public class Rent {

	private int id_wypozyczenie;
	private int idreff_samochod;
	private int idreff_pracownik;
	private String data_wypozyczenia;
	private int ilosc_dni;
	private int oplata;

	
	public Rent() {
	}
	
	public Rent(
	 int id_samochod,
	int id_pracownik,
	String data_wypozyczenia,
	int ilosc_dni,
	int oplata) {
		super();
		this.idreff_samochod = id_samochod;
		this.idreff_pracownik = id_pracownik;
		this.data_wypozyczenia = data_wypozyczenia;
		this.ilosc_dni = ilosc_dni;
		this.oplata = oplata;
	}

	public int getId_wypozyczenie() {
		return id_wypozyczenie;
	}

	public void setId_wypozyczenie(int id_wypozyczenie) {
		this.id_wypozyczenie = id_wypozyczenie;
	}

	

	public int getIdreff_samochod() {
		return idreff_samochod;
	}

	public void setIdreff_samochod(int idreff_samochod) {
		this.idreff_samochod = idreff_samochod;
	}

	public int getIdreff_pracownik() {
		return idreff_pracownik;
	}

	public void setIdreff_pracownik(int idreff_pracownik) {
		this.idreff_pracownik = idreff_pracownik;
	}

	public String getData_wypozyczenia() {
		return data_wypozyczenia;
	}

	public void setData_wypozyczenia(String data_wypozyczenia) {
		this.data_wypozyczenia = data_wypozyczenia;
	}

	public int getIlosc_dni() {
		return ilosc_dni;
	}

	public void setIlosc_dni(int ilosc_dni) {
		this.ilosc_dni = ilosc_dni;
	}

	public int getOplata() {
		return oplata;
	}

	public void setOplata(int oplata) {
		this.oplata = oplata;
	}
	
}

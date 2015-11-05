package domain;

import java.util.Date;

public class Rent {

	private int id_wypozyczenie;
	private int id_samochod;
	private int id_pracownik;
	private Date data_wypozyczenia;
	private int ilosc_dni;
	private int oplata;

	
	public Rent() {
	}
	
	public Rent(int id_wypozyczenie,
	 int id_samochod,
	int id_pracownik,
	Date data_wypozyczenia,
	int ilosc_dni,
	int oplata) {
		super();
		this.id_wypozyczenie = id_wypozyczenie;
		this.id_samochod = id_samochod;
		this.id_pracownik = id_pracownik;
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

	public int getId_samochod() {
		return id_samochod;
	}

	public void setId_samochod(int id_samochod) {
		this.id_samochod = id_samochod;
	}

	public int getId_pracownik() {
		return id_pracownik;
	}

	public void setId_pracownik(int id_pracownik) {
		this.id_pracownik = id_pracownik;
	}

	public Date getData_wypozyczenia() {
		return data_wypozyczenia;
	}

	public void setData_wypozyczenia(Date data_wypozyczenia) {
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

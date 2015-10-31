package domain;

import java.sql.Date;

public class Car {

	private int id_samochod;
	private String Marka;
	private String Model;
	private String Kolor;
	private Date Rok_produkcji;
	private String Opis;
	
	public Car() {
	}
	
	public Car(String Marka, 
			String Model,
			String Kolor, 
			Date Rok_produkcji,
			String Opis) {
		super();
		this.Marka = Marka;
		this.Model = Model;
		this.Kolor = Kolor;
		this.Rok_produkcji = Rok_produkcji;
		this.Opis = Opis;
	}

	public int getId_samochod() {
		return id_samochod;
	}

	public void setId_samochod(int id_samochod) {
		this.id_samochod = id_samochod;
	}

	public String getMarka() {
		return Marka;
	}

	public void setMarka(String marka) {
		Marka = marka;
	}

	public String getModel() {
		return Model;
	}

	public void setModel(String model) {
		Model = model;
	}

	public String getKolor() {
		return Kolor;
	}

	public void setKolor(String kolor) {
		Kolor = kolor;
	}

	public Date getRok_produkcji() {
		return Rok_produkcji;
	}

	public void setRok_produkcji(Date rok_produkcji) {
		Rok_produkcji = rok_produkcji;
	}

	public String getOpis() {
		return Opis;
	}

	public void setOpis(String opis) {
		Opis = opis;
	}

}

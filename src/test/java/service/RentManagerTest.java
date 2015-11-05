package service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import domain.Rent;
import domain.Emp;
import domain.Car;
import service.RentManager;
import service.EmpManager;
import service.CarManager;


public class RentManagerTest {

	RentManager rentManager = new RentManager();
	CarManager carManager = new CarManager();
	EmpManager empManager = new EmpManager();
	
	Rent rent;
	List<Rent> rents;
	
    @Test
    public void checkConnection(){
        assertNotNull(rentManager.getConnection());
    }
	
    @Test
    public void checkClearingRent()
    {
        rentManager.clearRent();
        assertEquals(rentManager.getAllRent().size(), 0);
    }
    
    @Test
    public void checkAdding()
    {
        rentManager.clearRent();

        carManager.clearSamochod();
        Car car = new Car("a", "b", "c",1, "d");
        carManager.addSamochod(car);

        empManager.clearEmp();
        Emp emp = new Emp("a", "aa", "aa", 3,2);
        empManager.addEmp(emp);

        Rent rent = new Rent(carManager.getAllSamochod().get(0).getId_samochod(), empManager.getAllEmp().get(0).getId_pracownik(), "a", 1, 2);

        rentManager.addRent(rent);

        assertEquals(carManager.getAllSamochod().get(0).getId_samochod(), rent.getIdreff_samochod());
        assertEquals(empManager.getAllEmp().get(0).getId_pracownik(), rent.getIdreff_pracownik());
        assertEquals("a", rent.getData_wypozyczenia());
        assertEquals(1, rent.getIlosc_dni());
        assertEquals(2, rent.getOplata());
    }
    
    @Test
    public void checkDeletingId_w()
    {
        rentManager.clearRent();

        carManager.clearSamochod();
        Car car = new Car("a", "b", "c",1, "d");
        carManager.addSamochod(car);


        empManager.clearEmp();
        Emp emp = new Emp("a", "aa", "aa", 3,2);
        empManager.addEmp(emp);

        Rent rent = new Rent(carManager.getAllSamochod().get(0).getId_samochod(), empManager.getAllEmp().get(0).getId_pracownik(), "a", 1, 2);

        rentManager.addRent(rent);

        rentManager.deleteRentIdw(rentManager.getAllRent().get(0));

        assertEquals(rentManager.getAllRent().size(), 0);

    }
    
    @Test
    public void checkUpdatingOrder()
    {
        rentManager.clearRent();

        carManager.clearSamochod();
        Car car = new Car("a", "b", "c",1, "d");
        carManager.addSamochod(car);


        empManager.clearEmp();
        Emp emp = new Emp("a", "aa", "aa", 3,2);
        empManager.addEmp(emp);

        Rent rent = new Rent(carManager.getAllSamochod().get(0).getId_samochod(), empManager.getAllEmp().get(0).getId_pracownik(), "a", 1, 2);

        rentManager.addRent(rent);

        Rent r = rentManager.getAllRent().get(0);
        r.setOplata(99);
        rentManager.updateRent(r);

        assertEquals(rentManager.getAllRent().get(0).getOplata(), 99);
    }
    
    @Test
    public void checkGettingRentByIDw()
    {
        Rent rentRetrieved = null;

        rentManager.clearRent();

        carManager.clearSamochod();
        Car car = new Car("a", "b", "c",1, "d");
        carManager.addSamochod(car);


        empManager.clearEmp();
        Emp emp = new Emp("a", "aa", "aa", 3,2);
        empManager.addEmp(emp);

        Rent rent = new Rent(carManager.getAllSamochod().get(0).getId_samochod(), empManager.getAllEmp().get(0).getId_pracownik(), "a", 1, 2);

        rentManager.addRent(rent);

        Rent r = rentManager.getAllRent().get(0);

        rentRetrieved = rentManager.getRentIdw(r);

        //order i orderRetrieved powinny byc tymi samymi zamowieniami
        assertEquals(r.getId_wypozyczenie(), rentRetrieved.getId_wypozyczenie());
        assertEquals(r.getIdreff_samochod(), rentRetrieved.getIdreff_samochod());
        assertEquals(r.getIdreff_pracownik(), rentRetrieved.getIdreff_pracownik());
        assertEquals(r.getData_wypozyczenia(), rentRetrieved.getData_wypozyczenia());
        assertEquals(r.getIlosc_dni(), rentRetrieved.getIlosc_dni());
    
    }

    @Test
    public void checkGettingRentByIDs()
    {
    	 rentManager.clearRent();

         carManager.clearSamochod();
         Car car = new Car("a", "b", "c",1, "d");
         carManager.addSamochod(car);


         empManager.clearEmp();
         Emp emp = new Emp("a", "aa", "aa", 3,2);
         empManager.addEmp(emp);

         Rent rent = new Rent(carManager.getAllSamochod().get(0).getId_samochod(), empManager.getAllEmp().get(0).getId_pracownik(), "a", 1, 2);

         rentManager.addRent(rent);
        //zamowienia, w ktorych bral udzial wskazany klient
        rents = rentManager.getRentbyIds(carManager.getAllSamochod().get(0));

        //cm.getAllCustomers().get(0) i orders.getCustomerID(0) powinny byc tymi samymi klientami
        assertEquals(carManager.getAllSamochod().get(0).getId_samochod(), rents.get(0).getIdreff_samochod());
    }
    
    @Test
    public void checkGettingRentByIDp()
    {
    	 rentManager.clearRent();

         carManager.clearSamochod();
         Car car = new Car("a", "b", "c",1, "d");
         carManager.addSamochod(car);


         empManager.clearEmp();
         Emp emp = new Emp("a", "aa", "aa", 3,2);
         empManager.addEmp(emp);

         Rent rent = new Rent(carManager.getAllSamochod().get(0).getId_samochod(), empManager.getAllEmp().get(0).getId_pracownik(), "a", 1, 2);

         rentManager.addRent(rent);
        //zamowienia, w ktorych bral udzial wskazany klient
        rents = rentManager.getRentbyIdp(empManager.getAllEmp().get(0));

        //cm.getAllCustomers().get(0) i orders.getCustomerID(0) powinny byc tymi samymi klientami
        assertEquals(empManager.getAllEmp().get(0).getId_pracownik(), rents.get(0).getIdreff_pracownik());
    }
    
    @Test
    public void checkDeletingRentById_s()
    {
    	rentManager.clearRent();

        carManager.clearSamochod();
        Car car = new Car("a", "b", "c",1, "d");
        carManager.addSamochod(car);


        empManager.clearEmp();
        Emp emp = new Emp("a", "aa", "aa", 3,2);
        empManager.addEmp(emp);

        Rent rent = new Rent(carManager.getAllSamochod().get(0).getId_samochod(), empManager.getAllEmp().get(0).getId_pracownik(), "a", 1, 2);

        rentManager.addRent(rent);

        rentManager.deleteRentIds(carManager.getAllSamochod().get(0));

        //Nie powinno byc zadnych zamowien
        assertEquals(rentManager.getAllRent().size(), 0);
    }
    
    @Test
    public void checkDeletingRentById_p()
    {
    	rentManager.clearRent();

        carManager.clearSamochod();
        Car car = new Car("a", "b", "c",1, "d");
        carManager.addSamochod(car);


        empManager.clearEmp();
        Emp emp = new Emp("a", "aa", "aa", 3,2);
        empManager.addEmp(emp);

        Rent rent = new Rent(carManager.getAllSamochod().get(0).getId_samochod(), empManager.getAllEmp().get(0).getId_pracownik(), "a", 1, 2);

        rentManager.addRent(rent);

        rentManager.deleteRentIdp(empManager.getAllEmp().get(0));

        //Nie powinno byc zadnych zamowien
        assertEquals(rentManager.getAllRent().size(), 0);
    }
    
    
   
}

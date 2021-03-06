package service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import domain.Car;
import domain.Emp;
import service.CarManager;

public class CarManagerTest {

	CarManager carManager = new CarManager();
	RentManager rentManager = new RentManager();
	
	Car car;
	List<Car> cars;
	
	private final static String MODEL_1 = "a";
	private final static String MARKA_1 = "b";
	private final static String KOLOR_1 = "c";
	private final static int ROK_1 = 2010;
	private final static String OPIS_1 = "d";
	

	@Test
	public void checkConnection(){
		rentManager.clearRent();
		assertNotNull(carManager.getConnection());
	}
	
	@Test
	public void checkAdding(){
		rentManager.clearRent();
		Car car = new Car(MODEL_1, MARKA_1, KOLOR_1, ROK_1, OPIS_1);
		
		carManager.clearSamochod();
		assertEquals(1,carManager.addSamochod(car));
		
		List<Car> cars = carManager.getAllSamochod();
		Car carRetrieved = cars.get(0);
		
		assertEquals(MODEL_1, carRetrieved.getModel());
		assertEquals(MARKA_1, carRetrieved.getMarka());
		assertEquals(KOLOR_1, carRetrieved.getKolor());
		assertEquals(ROK_1, carRetrieved.getRok_produkcji());
		assertEquals(OPIS_1, carRetrieved.getOpis());
		
	}
	
    @Test
    public void checkClearingSamochod()
    {
    	rentManager.clearRent();
        carManager.clearSamochod();
        assertEquals(carManager.getAllSamochod().size(), 0);
    }
	
    @Test
    public void checkDeleting()
    {
    	rentManager.clearRent();
        assertEquals(carManager.addSamochod(new Car("as", "df", "asdf", 1111,"g")), 1);
        car = carManager.getAllSamochod().get(0);
        assertEquals(carManager.deleteSamochod(car) , 1);
    }
   
    
    @Test
    public void checkUpdatingSamochod()
    {
    	rentManager.clearRent();
        carManager.clearSamochod();

        carManager.addSamochod(new Car("a", "b", "852852852", 2222,"asfs"));
        car = carManager.getAllSamochod().get(0);

        car.setMarka("b");
        car.setModel("a");
        car.setKolor("222333444");
        car.setRok_produkcji(4312);
        car.setOpis("Opis");

        assertEquals(carManager.updateCar(car), 1);

        assertEquals(carManager.getAllSamochod().get(0).getMarka(), "b");
        assertEquals(carManager.getAllSamochod().get(0).getModel(), "a");
        assertEquals(carManager.getAllSamochod().get(0).getKolor(), "222333444");
        assertEquals(carManager.getAllSamochod().get(0).getRok_produkcji(), 4312);
        assertEquals(carManager.getAllSamochod().get(0).getOpis(), "Opis");
    }
   
    @Test
    public void checkGettingSamochod()
    {
    	rentManager.clearRent();
        carManager.clearSamochod();

        Car carRetrieved = null;

        carManager.addSamochod(new Car("a", "b", "c", 1,"d"));
        car = carManager.getAllSamochod().get(0);
        carRetrieved = carManager.getSamochod(car);

        assertEquals(car.getId_samochod(), carRetrieved.getId_samochod());
        assertEquals(car.getModel(), carRetrieved.getModel());
        assertEquals(car.getMarka(), carRetrieved.getMarka());
        assertEquals(car.getKolor(), carRetrieved.getKolor());
        assertEquals(car.getRok_produkcji(), carRetrieved.getRok_produkcji());
        assertEquals(car.getOpis(), carRetrieved.getOpis());
    
    }
    
    @Test
    public void checkGetSamochodByMarka()
    {
    carManager.clearSamochod();
    car = new Car("a", "b", "c", 2,"d");
    carManager.addSamochod(car);
    cars = carManager.getSamochodByMarka(car);
    //assertEquals(customers.size(), 1);
    for(int i = 0; i < cars.size(); i++)
    {
    assertEquals(cars.get(i).getMarka(), "b");
    }
    }
    
    @Test
    public void checkGetSamochodByModel()
    {
    carManager.clearSamochod();
    car = new Car("a", "b", "c", 2,"d");
    carManager.addSamochod(car);
    cars = carManager.getSamochodByModel(car);
    //assertEquals(customers.size(), 1);
    for(int i = 0; i < cars.size(); i++)
    {
    assertEquals(cars.get(i).getModel(), "a");
    }
    }
    
}

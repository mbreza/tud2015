package service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import domain.Car;

import service.CarManager;

public class CarManagerTest {

	CarManager carManager = new CarManager();
	
	@Test
	public void checkConnection(){
		assertNotNull(carManager.getConnection());
	}
	
}

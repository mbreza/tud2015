package service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import domain.Emp;

import service.RentManager;
import service.EmpManager;


public class EmpManagerTest {

	EmpManager empManager = new EmpManager();
	RentManager rentManager = new RentManager();
	
	Emp emp;
	List<Emp> emps;
	
	private final static String IMIE_1 = "a";
	private final static String NAZWISKO_1 = "b";
	private final static String STANOWISKO_1 = "c";
	private final static int PESEL_1 = 2;
	private final static int PENSJA_1 = 2;
	
	@Test
	public void checkConnection(){
		
		assertNotNull(empManager.getConnection());
	}
	
	@Test
	public void checkAdding(){
		
		Emp emp = new Emp(IMIE_1, NAZWISKO_1, STANOWISKO_1, PESEL_1, PENSJA_1);
		rentManager.clearRent();
		empManager.clearEmp();
		assertEquals(1,empManager.addEmp(emp));
		
		List<Emp> emps = empManager.getAllEmp();
		Emp empRetrieved = emps.get(0);
		
		assertEquals(IMIE_1, empRetrieved.getImie());
		assertEquals(NAZWISKO_1, empRetrieved.getNazwisko());
		assertEquals(STANOWISKO_1, empRetrieved.getStanowisko());
		assertEquals(PESEL_1, empRetrieved.getPesel());
		assertEquals(PENSJA_1, empRetrieved.getPensja());
		
	}
	
    @Test
    public void checkClearingEmp()
    {
    	rentManager.clearRent();
        empManager.clearEmp();
        assertEquals(empManager.getAllEmp().size(), 0);
    }
	
    @Test
    public void checkDeleting()
    {
    	rentManager.clearRent();
    	empManager.clearEmp();
        assertEquals(empManager.addEmp(new Emp("as", "df", "asdf", 1111,22)), 1);
        emp = empManager.getAllEmp().get(0);
        assertEquals(empManager.deleteEmp(emp) , 1);
    }
    
    @Test
    public void checkUpdatingEmp()
    {
    	rentManager.clearRent();
        empManager.clearEmp();

        empManager.addEmp(new Emp("a", "b", "852852852", 2222,11));
        emp = empManager.getAllEmp().get(0);

        emp.setImie("b");
        emp.setNazwisko("a");
        emp.setStanowisko("222333444");
        emp.setPesel(4312);
        emp.setPensja(2);

        assertEquals(empManager.updateEmp(emp), 1);

        assertEquals(empManager.getAllEmp().get(0).getImie(), "b");
        assertEquals(empManager.getAllEmp().get(0).getNazwisko(), "a");
        assertEquals(empManager.getAllEmp().get(0).getStanowisko(), "222333444");
        assertEquals(empManager.getAllEmp().get(0).getPesel(), 4312);
        assertEquals(empManager.getAllEmp().get(0).getPensja(), 2);
    }
    
    @Test
    public void checkGettingEmp()
    {
    	rentManager.clearRent();
        empManager.clearEmp();

        Emp empRetrieved = null;

        empManager.addEmp(new Emp("a", "b", "c", 1, 2));
        emp = empManager.getAllEmp().get(0);
        empRetrieved = empManager.getEmp(emp);
        
        assertEquals(emp.getId_pracownik(), empRetrieved.getId_pracownik());
        assertEquals(emp.getImie(), empRetrieved.getImie());
        assertEquals(emp.getNazwisko(), empRetrieved.getNazwisko());
        assertEquals(emp.getStanowisko(), empRetrieved.getStanowisko());
        assertEquals(emp.getPesel(), empRetrieved.getPesel());
        assertEquals(emp.getPensja(), empRetrieved.getPensja());
    
    }
    
    @Test
    public void checkGettingEmpByImie()
    {
    empManager.clearEmp();
    emp = new Emp("a", "b", "c", 8520,9);
    empManager.addEmp(emp);
    emps = empManager.getEmpByName(emp);
    assertEquals(emps.size(), 1);
    for(int i = 0; i < emps.size(); i++)
    {
    assertEquals(emps.get(i).getImie(), "a");
    }
    }
 
    @Test
    public void checkGettingEmpLastName()
    {
    empManager.clearEmp();
    emp = new Emp("a", "ab", "c", 8520,9);
    empManager.addEmp(emp);
    emps = empManager.getEmpByLastName(emp);
    assertEquals(emps.size(), 1);
    for(int i = 0; i < emps.size(); i++)
    {
    assertEquals(emps.get(i).getNazwisko(), "ab");
    }
    }
   
    @Test
    public void checkGettingEmpByStanowisko()
    {
    empManager.clearEmp();
    emp = new Emp("a", "b", "c", 8520,9);
    empManager.addEmp(emp);
    emps = empManager.getEmpByStanowisko(emp);
    assertEquals(emps.size(), 1);
    for(int i = 0; i < emps.size(); i++)
    {
    assertEquals(emps.get(i).getStanowisko(), "c");
    }
    }
   
}

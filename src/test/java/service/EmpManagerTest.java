package service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import domain.Emp;

public class EmpManagerTest {

	EmpManager empManager = new EmpManager();
	
	Emp emp;
	
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
		
		empManager.clearSamochod();
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
    public void checkClearingSamochod()
    {
        empManager.clearSamochod();
        assertEquals(empManager.getAllEmp().size(), 0);
    }
	
    @Test
    public void checkDeleting()
    {
        assertEquals(empManager.addEmp(new Emp("as", "df", "asdf", 1111,22)), 1);
        emp = empManager.getAllEmp().get(0);
        assertEquals(empManager.deleteEmp(emp) , 1);
    }
    
    @Test
    public void checkUpdatingSamochod()
    {
        empManager.clearSamochod();

        empManager.addEmp(new Emp("Johnny", "Bravo", "852852852", 2222,11));
        emp = empManager.getAllEmp().get(0);

        emp.setImie("Han");
        emp.setNazwisko("Solo");
        emp.setStanowisko("222333444");
        emp.setPesel(4312);
        emp.setPensja(2);

        assertEquals(empManager.updateEmp(emp), 1);

        assertEquals(empManager.getAllEmp().get(0).getImie(), "Han");
        assertEquals(empManager.getAllEmp().get(0).getNazwisko(), "Solo");
        assertEquals(empManager.getAllEmp().get(0).getStanowisko(), "222333444");
        assertEquals(empManager.getAllEmp().get(0).getPesel(), 4312);
        assertEquals(empManager.getAllEmp().get(0).getPensja(), 2);
    }
}

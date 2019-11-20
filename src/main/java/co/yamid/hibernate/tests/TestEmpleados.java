package co.yamid.hibernate.tests;

import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import co.yamid.hibernate.modelo.Empleado;

public class TestEmpleados {
	
	private static EntityManager manager;
	
	private static EntityManagerFactory emf;
	
	
	public static void main(String[] args) {
		/*Crear el gestor de persistencia*/
		emf = Persistence.createEntityManagerFactory("aplicacion");
		manager = emf.createEntityManager();
		
		Empleado e  = new Empleado(10L, "P¨¦rez", "Pepito", new GregorianCalendar(1989,1,1).getTime());
		Empleado e2  = new Empleado(20L, "P¨¦rez", "Pepito", new GregorianCalendar(1989,1,1).getTime());
		manager.getTransaction().begin();
		manager.persist(e);
		manager.persist(e2);
		manager.getTransaction().commit();
		
		imprimirTodo();
	}
	
	@SuppressWarnings({ "unchecked"})
	private static void imprimirTodo() {
		List<Empleado> emps = (List<Empleado>) manager.createQuery("FROM Empleado").getResultList();
		System.out.println("En esta bd hay "+ emps.size() +" empleados");
		for	(Empleado emp: emps) {
			System.out.println(emp.toString());
		}
	}

}

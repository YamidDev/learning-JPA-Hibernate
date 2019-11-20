package co.yamid.hibernate.tests;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import co.yamid.hibernate.modelo.Empleado;

public class TestEmpleados {
	
	private static EntityManager manager;
	
	private static EntityManagerFactory emf;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		/*Crear el gestor de persistencia*/
		emf = Persistence.createEntityManagerFactory("aplicacion");
		manager = emf.createEntityManager();
		
		List<Empleado> empleados =manager.createQuery("FROM Empleado").getResultList();
	}

}

package co.yamid.hibernate.tests;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import co.yamid.hibernate.modelo.Direccion;
import co.yamid.hibernate.modelo.Empleado;

public class TestEmpleados {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("aplicacion");
	
	
	public static void main(String[] args) {		
		EntityManager man  = emf.createEntityManager();
		Direccion d = new Direccion(15L, "Calle Falsa, 123", "Springfield", "Springfield", "EUU" );
		Empleado e  = new Empleado(10L, "Perez", "Pepito", LocalDate.of(1989, 6, 1));
		e.setDireccion(d);
		man.getTransaction().begin();
		man.persist(d);
		man.persist(e);
		man.getTransaction().commit();
		
		imprimirTodo();
		
		man = emf.createEntityManager();
		man.getTransaction().begin();
		e.setNombre("yamid");
		man.merge(e);
		man.getTransaction().commit();
		man.close();
		
		imprimirTodo();
	}

	private static void imprimirTodo() {
		EntityManager man  = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Empleado> emps = (List<Empleado>) man.createQuery("FROM Empleado").getResultList();
		System.out.println("En esta bd hay "+ emps.size() +" empleados");
		for	(Empleado emp: emps) {
			System.out.println(emp.toString());
		}
	}

}

package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

// GUI
public class Demo01 {
	// registro de un nuevo Usuario
	public static void main(String[] args) {
		// 1. obtener conexion -> llamar al persistence-unit
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("jpa_sesion01");
		// 2. crear un manejador de entidades
		EntityManager em = fabrica.createEntityManager();
		// proceso 
		Usuario u = new Usuario();
		u.setCod_usua(0);
		// insert into tb_xxx values (?,?,?,...
		// OjO !! si el proceso es registrar / act / elimi -> Transacción
		try {
			em.getTransaction().begin();
			em.persist(u);
			em.getTransaction().commit();
			System.out.println("Registro Ok!!!");
		} catch (Exception e) {
			System.out.println("Error:" + e.getCause().getMessage());
		}
		em.close();
	}
}

package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Producto;
import model.Usuario;

// GUI
public class Demo07 {
	// Objetivo: listado de todos productos
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager em = fabrica.createEntityManager();
		
		// select * from tb_usuarios --> List
		String jpql = "select p from Producto p";
		List<Producto> lstProductos = em.createQuery(jpql, 
				Producto.class).getResultList();
		
		// imprimir el listado
		for (Producto p : lstProductos) {
			System.out.println("Código........: " + p.getId_prod());
			System.out.println("Nombre Prod...: " + p.getDes_prod());
			System.out.println("Categoría.....: " + p.getObjCategoria().getDescripcion());
			System.out.println("Proveedor.....: " + p.getObjProveedor().getNombre_rs());
			System.out.println("--------------------------");
		}
		
		em.close();
	}
}

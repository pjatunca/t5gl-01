package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

// GUI
public class Demo08 {
	// listado de los Usuarios según el tipo de usuario (filtro)
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager em = fabrica.createEntityManager();
		
		// select * from tb_usuarios where usr_usua = ? and cla_usua = ?
		String jpql = "select u from Usuario u where u.usr_usua = :xusr and u.cla_usua = :xcla";
		List<Usuario> lstUsuarios = 
			em.createQuery(jpql, Usuario.class).
				setParameter("xusr", "admin@ciberfarma.pe").
				setParameter("xcla", "super").
				getResultList();
		// imprimir el listado
		for (Usuario u : lstUsuarios) {
			System.out.println("Código...: " + u.getCod_usua());
			System.out.println("Nombre...: " + u.getNom_usua() + " " + u.getApe_usua());
			System.out.println("Tipo.....: " + u.getIdtipo() + " " + u.getObjTipo().getDescripcion());
			System.out.println("--------------------------");
		}
		
		em.close();
	}
}

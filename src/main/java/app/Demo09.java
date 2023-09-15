package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import model.Usuario;

// GUI
public class Demo09 {
	// listado de los Usuarios según el tipo de usuario (filtro)
	public static void main(String[] args) {
		String usuario = JOptionPane.showInputDialog("Ingrese usuario: ");
		String clave = JOptionPane.showInputDialog("Ingrese clave: ");
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager em = fabrica.createEntityManager();
		
		// select * from tb_usuarios where usr_usua = ? and cla_usua = ?
		String jpql = "select u from Usuario u where u.usr_usua = :xusr and u.cla_usua = :xcla";
		try {
			Usuario u = 
				em.createQuery(jpql, Usuario.class).
					setParameter("xusr", usuario).
					setParameter("xcla", clave).
					getSingleResult();
			// Abrir la ventana
			FrmManteProd v = new FrmManteProd();
			v.setVisible(true);
			// dispose();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Usuario o clave incorrecto");
		}
		
		em.close();
	}
}

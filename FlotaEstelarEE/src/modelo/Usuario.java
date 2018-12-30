package modelo;

import java.util.ArrayList;
import dao.UsuarioDAO;

public class Usuario {

	private int id_usuario;
	private String nombre;
	private String usuario;
	private String pass;

	public Usuario() {
	}

	public Usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	public Usuario(String usuario, String pass) {
		this.usuario = usuario;
		this.pass = pass;
	}

	public Usuario(String nombre, String usuario, String pass) {
		this.nombre = nombre;
		this.usuario = usuario;
		this.pass = pass;
	}

	public Usuario(int id_usuario, String nombre, String usuario, String pass) {
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.usuario = usuario;
		this.pass = pass;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public void insertar() {
		try {
			UsuarioDAO.getInstance().insertar(this);
		} catch (Exception ex) {
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: Usuario \n" + "\t Metodo: insertar(Usuario e) \n" + "\t Error: " + ex);
		}
	}

	public ArrayList<Usuario> listar() {
		ArrayList<Usuario> listaUsuarios = new ArrayList<>();
		try {
			listaUsuarios = UsuarioDAO.getInstance().listar();
		} catch (Exception ex) {
			listaUsuarios = null;
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: Usuario \n" + "\t Metodo: listar() \n" + "\t Error: " + ex);
		}
		return listaUsuarios;
	}

	public Usuario listarPorPk(int id) {
		Usuario n = new Usuario();
		try {
			n.listarPorPk(id);
		} catch (Exception ex) {
			n = null;
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: Usuario \n" + "\t Metodo: listarPorPk(int id) \n" + "\t Error: " + ex);
		}
		return n;
	}

	public void eliminar(Usuario e) {
		try {
			e.eliminar(this);
		} catch (Exception ex) {
			e = null;
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: Usuario \n" + "\t Metodo: eliminar(Usuario e) \n" + "\t Error: " + ex);
		}
	}

	public void actualizar(Usuario e) {
		try {
			e.actualizar(this);
		} catch (Exception ex) {
			e = null;
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: Usuario \n" + "\t Metodo: actualizar(Usuario e) \n" + "\t Error: " + ex);
		}
	}

	public void cambiarContrasena(Usuario e) {
		try {
			int id = e.getId_usuario();
			e.cambiarContrasena(e);
		} catch (Exception ex) {
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: Usuario \n" + "\t Metodo: cambiarContrasena(Usuario e) \n" + "\t Error: " + ex);
		}
	}
	


}

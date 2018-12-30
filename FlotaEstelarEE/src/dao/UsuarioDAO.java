package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.DBConexion;
import modelo.Usuario;
public class UsuarioDAO {

	private Connection con = null;
	private static UsuarioDAO instance = null;

	private UsuarioDAO() throws SQLException {
		con = DBConexion.getConnection();
	}

	public static UsuarioDAO getInstance() throws SQLException {
		if (instance == null) {
			instance = new UsuarioDAO();
		}
		return instance;
	}

	public void insertar(Usuario e) throws SQLException {
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO usuario (nombre,usuario,pass) VALUES (?,?,?);");
			ps.setString(1, e.getNombre());
			ps.setString(2, e.getUsuario());
			ps.setString(3, e.getPass());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException ex) {
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: UsuarioDAO \n" + "\t Metodo: insertar(Usuario e) \n"
					+ "\t Error: " + ex);
		}
	}

	public ArrayList<Usuario> listar() {
		ArrayList<Usuario> resultado = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM usuario");
			ResultSet rs = ps.executeQuery();
			resultado = null;
			while (rs.next()) {
				if (resultado == null) {
					resultado = new ArrayList<>();
				}
				resultado.add(new Usuario(rs.getInt("id_usuario"), rs.getString("nombre"), rs.getString("usuario"),
						rs.getString("pass")));
			}
			rs.close();
			ps.close();
		} catch (SQLException ex) {
			resultado = null;
			System.out.println(
					"ERROR CONTROLADO: \n " + "\t Clase: UsuarioDAO \n" + "\t Metodo: listar() \n" + "\t Error: " + ex);
		}
		return resultado;
	}

	public Usuario listarPorPk(int id) {
		Usuario resultado = new Usuario();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM usuario WHERE id_usuario = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			resultado = null;
			if (rs.next()) {
				resultado = new Usuario(rs.getInt("id_usuario"), rs.getString("nombre"), rs.getString("usuario"),
						rs.getString("pass"));
			}
			rs.close();
			ps.close();
		} catch (SQLException ex) {
			resultado = null;
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: UsuarioDAO \n" + "\t Metodo: listarPorPk(int id) \n"
					+ "\t Error: " + ex);
		}
		return resultado;
	}

	public void eliminar(Usuario e) {
		try {
			eliminar(e.getId_usuario());
		} catch (Exception ex) {
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: UsuarioDAO \n" + "\t Metodo: eliminar(Usuario e) \n"
					+ "\t Error: " + ex);
		}
	}

	public void eliminar(int id) {
		try {
			if (id <= 0) {
				return;
			}
			PreparedStatement ps = con.prepareStatement("DELETE FROM usuario WHERE id_usuario = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException ex) {
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: UsuarioDAO \n" + "\t Metodo: eliminar(int id) \n"
					+ "\t Error: " + ex);
		}

	}

	public void cambiarContrasena(Usuario e) {
		try {
			if(e.getId_usuario() == 0) {
				return;
			}
			PreparedStatement ps = con.prepareStatement("UPDATE usuario SET password=? WHERE id_usuario=?;");
			ps.setString(1, e.getPass());
			ps.setInt(2, e.getId_usuario());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException ex) {
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: UsuarioDAO \n"
					+ "\t Metodo: cambiarContrasena(Usuario e) \n" + "\t Error: " + ex);
		}
	}
	
	public Usuario login() {
		Usuario resultado = new Usuario();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT usuario, pass FROM usuario;");
			ResultSet rs = ps.executeQuery();
			resultado = null;
			if (rs.next()) {
				resultado = new Usuario(rs.getString("usuario"), rs.getString("pass"));
			}
			rs.close();
			ps.close();
		} catch (SQLException ex) {
			resultado = null;
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: UsuarioDAO \n" + "\t Metodo: login() \n"
					+ "\t Error: " + ex);
		}
		return resultado;
	}

}

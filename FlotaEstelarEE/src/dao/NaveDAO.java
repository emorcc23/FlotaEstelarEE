package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import conexion.DBConexion;
import modelo.Nave;

/**
 * 
 * @author alvaro.santos
 *
 */

public class NaveDAO {

	private Connection con = null;
	private static NaveDAO instance = null;

	private NaveDAO() throws SQLException {
		con = DBConexion.getConnection();
	}

	public static NaveDAO getInstance() throws SQLException {
		if (instance == null) {
			instance = new NaveDAO();
		}
		return instance;
	}

	public void insertar(Nave e) {
		try {
			PreparedStatement ps = con
					.prepareStatement("INSERT INTO nave (capitan,nombre,matricula,tipo) VALUES (?,?,?,?);");
			ps.setString(1, e.getCapitan());
			ps.setString(2, e.getNombre());
			ps.setString(3, e.getMatricula());
			ps.setString(4, e.getTipo());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException ex) {
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: NaveDAO \n" + "\t Metodo: insertar(Nave e) \n"
					+ "\t Error: " + ex);
		}
	}

	public ArrayList<Nave> listar() throws SQLException {
		ArrayList<Nave> resultado = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM nave;");
			ResultSet rs = ps.executeQuery();
			resultado = null;
			while (rs.next()) {
				if (resultado == null) {
					resultado = new ArrayList<>();
				}
				resultado.add(new Nave(rs.getInt("id_nave"), rs.getString("capitan"), rs.getString("nombre"),
						rs.getString("matricula"), rs.getString("tipo")));
			}
			rs.close();
			ps.close();
		} catch (SQLException ex) {
			resultado = null;
			System.out.println(
					"ERROR CONTROLADO: \n " + "\t Clase: NaveDAO \n" + "\t Metodo: listar() \n" + "\t Error: " + ex);
		}
		return resultado;
	}

	public Nave listarPorPk(int id) {
		Nave resultado = new Nave();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM nave WHERE id_nave = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			resultado = null;
			if (rs.next()) {
				resultado = new Nave(rs.getInt("id_nave"), rs.getString("capitan"), rs.getString("nombre"),
						rs.getString("matricula"), rs.getString("tipo"));
			}
			rs.close();
			ps.close();
		} catch (SQLException ex) {
			resultado = null;
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: NaveDAO \n" + "\t Metodo: listarPorPk(id) \n"
					+ "\t Error: " + ex);
		}
		return resultado;
	}

	public void eliminar(Nave e) {
		try {
			eliminar(e.getId_nave());
		} catch (Exception ex) {
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: NaveDAO \n" + "\t Metodo: eliminar(Nave e) \n"
					+ "\t Error: " + ex);
		}
	}

	public void eliminar(int id) {
		try {
			if (id <= 0) {
				return;
			}
			PreparedStatement ps = con.prepareStatement("DELETE FROM nave WHERE id_nave = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException ex) {
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: NaveDAO \n" + "\t Metodo: eliminar(int id) \n"
					+ "\t Error: " + ex);
		}

	}

	public void actualizar(Nave e) {
		try {
			if (e.getId_nave() == 0) {
				return;
			}
			PreparedStatement ps = con.prepareStatement(
					"UPDATE nave SET id_nave=?,capitan=?,nombre=?,matricula=?,tipo=? WHERE id_nave=?;");
			ps.setInt(1, e.getId_nave());
			ps.setString(2, e.getCapitan());
			ps.setString(3, e.getNombre());
			ps.setString(4, e.getMatricula());
			ps.setString(5, e.getTipo());
			ps.setInt(6, e.getId_nave());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException ex) {
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: NaveDAO \n" + "\t Metodo: actualizar(Nave e) \n"
					+ "\t Error: " + ex);
		}
	}

	public ArrayList<Nave> extraerIdNaves() throws SQLException {
		ArrayList<Nave> resultado = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT id_nave FROM nave");
			ResultSet rs = ps.executeQuery();
			resultado = null;
			while (rs.next()) {
				if (resultado == null) {
					resultado = new ArrayList<>();
				}
				resultado.add(new Nave(rs.getInt("id_nave")));
			}
			rs.close();
			ps.close();
		} catch (SQLException ex) {
			resultado = null;
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: NaveDAO \n" + "\t Metodo: extraerIdNaves() \n"
					+ "\t Error: " + ex);
		}
		return resultado;
	}
	
	public Nave buscarPorPk(int id_nave) throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM nave WHERE id_nave = ?");
		ps.setInt(1, id_nave);
		ResultSet rs = ps.executeQuery();
		Nave result = null;
		if (rs.next()) {
			result = new Nave(rs.getInt("id_nave"), rs.getString("capitan"),rs.getString("nombre"),rs.getString("matricula"),rs.getString("tipo"));
		}
		rs.close();
		ps.close();
		return result;
	}

}







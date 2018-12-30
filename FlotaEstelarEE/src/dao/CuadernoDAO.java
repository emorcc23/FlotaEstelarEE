package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import conexion.DBConexion;
import modelo.Cuaderno;

/**
 * 
 * @author Álvaro Santos
 *
 */

public class CuadernoDAO {
	/*
	 * PROPERTIES & METHODS DBConnection
	 */
	private Connection con = null;
	private static CuadernoDAO instance = null;

	private CuadernoDAO() throws SQLException {
		con = DBConexion.getConnection();
	}

	public static CuadernoDAO getInstance() throws SQLException {
		if (instance == null) {
			instance = new CuadernoDAO();
		}
		return instance;
	}

	public void insertar(Cuaderno e) {
		try {
			PreparedStatement ps = con
					.prepareStatement("INSERT INTO cuaderno (fecha,descripcion,audio,id_nave) VALUES (?,?,?,?)");
			ps.setString(1, e.getFecha());
			ps.setString(2, e.getDescripcion());
			ps.setString(3, e.getAudio());
			ps.setInt(4, e.getId_nave());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException ex) {
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: CuadernoDAO \n"
					+ "\t Metodo: insertar(Cuaderno e) \n" + "\t Error: " + ex);
		}
	}

	public ArrayList<Cuaderno> listar() {
		ArrayList<Cuaderno> resultado = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM cuaderno");
			ResultSet rs = ps.executeQuery();
			resultado = null;
			while (rs.next()) {
				if (resultado == null) {
					resultado = new ArrayList<>();
				}
				resultado.add(new Cuaderno(rs.getInt("id_cuaderno"),rs.getString("fecha"), rs.getString("descripcion"),
						rs.getString("audio"), rs.getInt("id_nave")));
			}
			rs.close();
			ps.close();
		} catch (SQLException ex) {
			resultado = null;
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: CuadernoDAO \n" + "\t Metodo: listar() \n"
					+ "\t Error: " + ex);
		}
		return resultado;
	}

	public Cuaderno listarPorPk(int id) {
		Cuaderno resultado = new Cuaderno();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM cuaderno WHERE id_cuaderno = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			resultado = null;
			if (rs.next()) {
				resultado = new Cuaderno(rs.getInt("id_nave"),rs.getString("fecha"), rs.getString("descripcion"),
						rs.getString("audio"), rs.getInt("id_nave"));
			}
			rs.close();
			ps.close();
		} catch (SQLException ex) {
			resultado = null;
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: CuadernoDAO \n"
					+ "\t Metodo: listarPorPk(int id) \n" + "\t Error: " + ex);
		}
		return resultado;
	}

	public void eliminar(Cuaderno e) {
		try {
			eliminar(e.getId_cuaderno());
		} catch (Exception ex) {
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: CuadernoDAO \n"
					+ "\t Metodo: eliminar(Cuaderno e) \n" + "\t Error: " + ex);
		}
	}

	public void eliminar(int id) {
		try {
			if (id <= 0) {
				return;
			}
			PreparedStatement ps = con.prepareStatement("DELETE FROM cuaderno WHERE id_cuaderno = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException ex) {
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: CuadernoDAO \n" + "\t Metodo: eliminar(int id) \n"
					+ "\t Error: " + ex);
		}
	}

	public void actualizar(Cuaderno e) {
		try {
			if (e.getId_cuaderno() == 0) {
				return;
			}
			PreparedStatement ps = con.prepareStatement(
					"UPDATE cuaderno SET id_cuaderno=?,fecha=?,descripcion=?,audio=?,id_nave=? WHERE id_cuaderno=?;");
			ps.setInt(1, e.getId_cuaderno());
			ps.setString(2, e.getFecha());
			ps.setString(3, e.getDescripcion());
			ps.setString(4, e.getAudio());
			ps.setInt(5, e.getId_nave());
			ps.setInt(6, e.getId_cuaderno());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException ex) {
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: CuadernoDAO \n"
					+ "\t Metodo: actualizar(Cuaderno e) \n" + "\t Error: " + ex);
		}
	}

	public int extraerUltimoId() {
		int ultimoId = 0;
		try {
			PreparedStatement ps = con
					.prepareStatement("SELECT id_cuaderno FROM cuaderno ORDER BY id_cuaderno DESC LIMIT 1;");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				ultimoId = rs.getInt("id_cuaderno") + 1;
			}
		} catch (SQLException ex) {
			ultimoId = 0;
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: CuadernoDAO \n" + "\t Metodo: extraerUltimoId() \n"
					+ "\t Error: " + ex);
		}
		return ultimoId;
	}
	
	public Cuaderno buscarPorPk(int id_cuaderno) throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM cuaderno WHERE id_cuaderno=?");
		ps.setInt(1, id_cuaderno);
		ResultSet rs = ps.executeQuery();
		Cuaderno result = null;
		if(rs.next()) {
			result = new Cuaderno(rs.getInt("id_cuaderno"),rs.getString("fecha"),rs.getString("descripcion"),rs.getString("audio"),rs.getInt("id_nave"));
		}
		rs.close();
		ps.close();
		return result;
	}
	
}






















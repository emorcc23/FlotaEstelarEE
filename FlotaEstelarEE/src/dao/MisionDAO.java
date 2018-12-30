package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import conexion.DBConexion;
import modelo.Mision;

/**
 * 
 * @author Álvaro Santos
 *
 */

public class MisionDAO {
	private Connection con = null;
	private static MisionDAO instance = null;

	private MisionDAO() throws SQLException {
		con = DBConexion.getConnection();
	}

	public static MisionDAO getInstance() throws SQLException {
		if (instance == null) {
			instance = new MisionDAO();
		}
		return instance;
	}

	public void insertar(Mision e) throws SQLException {
		try {
			PreparedStatement ps = con
					.prepareStatement("INSERT INTO mision (nombre,descripcion,id_nave) VALUES (?,?,?);");
			ps.setString(1, e.getNombre());
			ps.setString(2, e.getDescripcion());
			ps.setInt(3, e.getId_nave());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException ex) {
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: MisionDAO \n" + "\t Metodo: insertar(Mision e) \n"
					+ "\t Error: " + ex);
		}

	}

	public ArrayList<Mision> listar() {
		ArrayList<Mision> resultado = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM mision");
			ResultSet rs = ps.executeQuery();
			resultado = null;
			while (rs.next()) {
				if (resultado == null) {
					resultado = new ArrayList<>();
				}
				resultado.add(new Mision(rs.getInt("id_mision"), rs.getString("nombre"), rs.getString("descripcion"),
						rs.getInt("id_nave")));
			}
			rs.close();
			ps.close();
		} catch (SQLException ex) {
			resultado = null;
			System.out.println(
					"ERROR CONTROLADO: \n " + "\t Clase: MisionDAO \n" + "\t Metodo: listar() \n" + "\t Error: " + ex);
		}
		return resultado;
	}

	public Mision listarPorPk(int id) {
		Mision resultado = new Mision();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM mision WHERE id_mision = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			resultado = null;
			if (rs.next()) {
				resultado = new Mision(rs.getInt("id_mision"), rs.getString("nombre"), rs.getString("descripcion"),
						rs.getInt("id_nave"));
			}
			rs.close();
			ps.close();
		} catch (SQLException ex) {
			resultado = null;
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: MisionDAO \n" + "\t Metodo: listarPorPk(int id) \n"
					+ "\t Error: " + ex);
		}
		return resultado;
	}

	public void eliminar(Mision e) {
		try {
			eliminar(e.getId_mision());
		} catch (Exception ex) {
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: MisionDAO \n" + "\t Metodo: eliminar(Mision e) \n"
					+ "\t Error: " + ex);
		}
	}

	public void eliminar(int id) {
		try {
			if (id <= 0) {
				return;
			}
			PreparedStatement ps = con.prepareStatement("DELETE FROM mision WHERE id_mision = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException ex) {
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: MisionDAO \n" + "\t Metodo: eliminar(int id) \n"
					+ "\t Error: " + ex);
		}

	}

	public void actualizar(Mision e) {
		try {
			if (e.getId_mision() == 0) {
				return;
			}
			PreparedStatement ps = con.prepareStatement(
					"UPDATE mision SET id_mision=?,nombre=?,descripcion=?,id_nave=? WHERE id_mision=?;");
			ps.setInt(1, e.getId_mision());
			ps.setString(2, e.getNombre());
			ps.setString(3, e.getDescripcion());
			ps.setInt(4, e.getId_nave());
			ps.setInt(5, e.getId_mision());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException ex) {
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: MisionDAO \n" + "\t Metodo: actualizar(Mision e) \n"
					+ "\t Error: " + ex);
		}
	}
	
	public Mision buscarPorPk(int id_mision) throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM mision WHERE id_mision = ?");
		ps.setInt(1, id_mision);
		ResultSet rs = ps.executeQuery();
		Mision result = null;
		if(rs.next()) {
			result = new Mision(rs.getInt("id_mision"), rs.getString("nombre"), rs.getString("descripcion"), rs.getInt("id_nave"));
		}
		rs.close();
		ps.close();
		return result;
	}
	
}


















package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.DBConexion;
import modelo.Tripulante;

/**
 * 
 * @author Álvaro Santos
 *
 */

public class TripulanteDAO {

	private Connection con = null;
	private static TripulanteDAO instance = null;

	private TripulanteDAO() throws SQLException {
		con = DBConexion.getConnection();
	}

	public static TripulanteDAO getInstance() throws SQLException {
		if (instance == null) {
			instance = new TripulanteDAO();
		}
		return instance;
	}

	public void insertar(Tripulante e) throws SQLException {
		try {
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO tripulante (id_tripulante,nombre,cargo,genero,experiencia,origen,raza,edad,id_nave) VALUES (?,?,?,?,?,?,?,?,?);");
			ps.setInt(1, e.getId_tripulante());
			ps.setString(2, e.getNombre());
			ps.setString(3, e.getCargo());
			ps.setString(4, e.getGenero());
			ps.setInt(5, e.getExperiencia());
			ps.setString(6, e.getOrigen());
			ps.setString(7, e.getRaza());
			ps.setInt(8, e.getEdad());
			ps.setInt(9, e.getId_nave());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException ex) {
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: TripulanteDAO \n"
					+ "\t Metodo: insertar(Tripulante e) \n" + "\t Error: " + ex);
		}
	}

	public ArrayList<Tripulante> listar() throws SQLException {
		ArrayList<Tripulante> resultado = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM tripulante");
			ResultSet rs = ps.executeQuery();
			resultado = null;
			while (rs.next()) {
				if (resultado == null) {
					resultado = new ArrayList<>();
				}
				resultado.add(new Tripulante(rs.getInt("id_tripulante"), rs.getString("nombre"), rs.getString("cargo"),
						rs.getString("genero"), rs.getInt("experiencia"), rs.getString("origen"), rs.getString("raza"),
						rs.getInt("edad"),rs.getInt("id_nave")));
			}
			rs.close();
			ps.close();
		} catch (SQLException ex) {
			resultado = null;
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: TripulanteDAO \n" + "\t Metodo: listar() \n"
					+ "\t Error: " + ex);
		}
		return resultado;
	}

	public Tripulante listarPorPk(int id) {
		Tripulante resultado = new Tripulante();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM tripulante WHERE id_tripulante = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			resultado = null;
			if (rs.next()) {
				resultado = new Tripulante(rs.getInt("id_tripulante"), rs.getString("nombre"), rs.getString("cargo"),
						rs.getString("genero"), rs.getInt("experiencia"), rs.getString("origen"), rs.getString("raza"),
						rs.getInt("edad"),rs.getInt("id_nave"));
			}
			rs.close();
			ps.close();
		} catch (SQLException ex) {
			resultado = null;
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: TripulanteDAO \n"
					+ "\t Metodo: listarPorPk(int id) \n" + "\t Error: " + ex);
		}
		return resultado;
	}

	public void eliminar(Tripulante e) {
		try {
			eliminar(e.getId_tripulante());
		} catch (Exception ex) {
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: TripulanteDAO \n"
					+ "\t Metodo: eliminar(Tripulante e) \n" + "\t Error: " + ex);
		}
	}

	public void eliminar(int id) throws SQLException {
		try {
			if (id <= 0) {
				return;
			}
			PreparedStatement ps = con.prepareStatement("DELETE FROM tripulante WHERE id_tripulante = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException ex) {
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: TripulanteDAO \n" + "\t Metodo: eliminar(int id) \n"
					+ "\t Error: " + ex);
		}
	}

	public void actualizar(Tripulante e) {
		try {
			if (e.getId_tripulante() == 0) {
				return;
			}
			PreparedStatement ps = con.prepareStatement(
					"UPDATE tripulante SET id_tripulante=?,nombre=?,cargo=?,genero=?,experiencia=?,origen=?,raza=?,edad=?,id_nave=? WHERE id_tripulante=?;");
			ps.setInt(1, e.getId_tripulante());
			ps.setString(2, e.getNombre());
			ps.setString(3, e.getCargo());
			ps.setString(4, e.getGenero());
			ps.setInt(5, e.getExperiencia());
			ps.setString(6, e.getOrigen());
			ps.setString(7, e.getRaza());
			ps.setInt(8, e.getEdad());
			ps.setInt(9, e.getId_nave());
			ps.setInt(10, e.getId_tripulante());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException ex) {
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: TripulanteDAO \n"
					+ "\t Metodo: actualizar(Tripulante e) \n" + "\t Error: " + ex);
		}
	}

	public int extraerUltimoId() throws SQLException {
		int ultimoId = 0;
		try {
			PreparedStatement ps = con
					.prepareStatement("SELECT id_tripulante  FROM tripulante ORDER BY id_tripulante DESC LIMIT 1;");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				ultimoId = rs.getInt("id_tripulante") + 1;
			}
		} catch (SQLException ex) {
			ultimoId = 0;
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: TripulanteDAO \n"
					+ "\t Metodo: extraerUltimoId() \n" + "\t Error: " + ex);
		}
		return ultimoId;
	}
	
	public Tripulante buscarPorPk(int id_tripulante) throws SQLException {
		PreparedStatement ps = con.prepareStatement("SELECT * FROM tripulante WHERE id_tripulante = ?");
		ps.setInt(1, id_tripulante);
		ResultSet rs = ps.executeQuery();
		Tripulante result = null;
		if (rs.next()) {
			result = new Tripulante(rs.getInt("id_tripulante"), rs.getString("nombre"), rs.getString("cargo"), rs.getString("genero"), rs.getInt("experiencia"), rs.getString("origen"), rs.getString("raza"), rs.getInt("edad"), rs.getInt("id_nave"));
		}
		rs.close();
		ps.close();
		return result;
	}
}















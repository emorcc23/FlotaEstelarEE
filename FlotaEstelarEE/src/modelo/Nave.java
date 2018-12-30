package modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import dao.NaveDAO;

/**
 * 
 * @author Álvaro Santos
 *
 */

public class Nave {

	private int id_nave;
	private String capitan;
	private String nombre;
	private String matricula;
	private String tipo;

	public Nave() {
	}

	public Nave(int id_nave) {
		this.id_nave = id_nave;
	}


	public Nave(String capitan, String nombre, String matricula, String tipo) {
		this.capitan = capitan;
		this.nombre = nombre;
		this.matricula = matricula;
		this.tipo = tipo;
	}

	public Nave(int id_nave, String capitan, String nombre, String matricula, String tipo) {
		this.id_nave = id_nave;
		this.capitan = capitan;
		this.nombre = nombre;
		this.matricula = matricula;
		this.tipo = tipo;
	}

	public int getId_nave() {
		return id_nave;
	}

	public void setId_nave(int id_nave) {
		this.id_nave = id_nave;
	}

	public String getCapitan() {
		return capitan;
	}

	public void setCapitan(String capitan) {
		this.capitan = capitan;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public void insertar() {
		try {
			NaveDAO.getInstance().insertar(this);
		} catch (Exception ex) {
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: Nave \n" + "\t Metodo: insertar(Nave e) \n" + "\t Error: " + ex);
		}
	}

	public ArrayList<Nave> listar() {
		ArrayList<Nave> listaNaves = new ArrayList<>();
		try {
			listaNaves = NaveDAO.getInstance().listar();
		} catch (Exception ex) {
			listaNaves = null;
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: Nave \n" + "\t Metodo: listar() \n" + "\t Error: " + ex);
		}
		return listaNaves;
	}

	public Nave buscarPorId(int id) throws SQLException {
		Nave nave = NaveDAO.getInstance().buscarPorPk(id);
		return nave;
	}

	public void eliminar(Nave e) {
		try {
			NaveDAO.getInstance().eliminar(e);
		} catch (Exception ex) {
			e = null;
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: Nave \n" + "\t Metodo: eliminar(Nave e) \n" + "\t Error: " + ex);
		}
	}

	public void actualizar(Nave e) {
		try {
			NaveDAO.getInstance().actualizar(e);
		} catch (Exception ex) {
			e = null;
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: Nave \n" + "\t Metodo: actualizar(Nave e) \n" + "\t Error: " + ex);
		}
	}

	public ArrayList<Nave> extraerUltimoId() {
		ArrayList<Nave> id_naves = null;
		Nave n = new Nave();
		try {
			id_naves = NaveDAO.getInstance().extraerIdNaves();
		} catch (Exception ex) {
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: Nave \n" + "\t Metodo: extraerUltimoId() \n" + "\t Error: " + ex);
		}
		return id_naves;
	}

	public ArrayList<Nave> extraerIdNaves() {
		ArrayList<Nave> listaNaves = new ArrayList<>();
		try {
			listaNaves = NaveDAO.getInstance().extraerIdNaves();
		} catch (Exception ex) {
			listaNaves = null;
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: Nave \n" + "\t Metodo: extraerIdNaves() \n" + "\t Error: " + ex);
		}
		return listaNaves;
	}

	public String mostrarTablaNaves() {

		String str = "";

		try {
			ArrayList<Nave> listaNaves = NaveDAO.getInstance().listar();

			if (listaNaves.isEmpty()) {
				str += "<div class='table table-hover'>" + "<p>No se encuentran resultados de naves</p>" + "</div>";
			} else {

				str += "<div class='table table-hover'>" + "<table class='table'>" + "<tr>" + "<th></th>" + "<th>Capitán</th>" + "<th>Nombre</th>" + "<th>Matrícula</th>" + "<th>Tipo</th>" + "<th></th>" + "</tr>";
				for (int i = 0; i < listaNaves.size(); i++) {
					str += "<tr>" + "<td></td>" + "<td>" + listaNaves.get(i).getCapitan() + "</td>" + "<td>" + listaNaves.get(i).getNombre() + "</td>" + "<td>" + listaNaves.get(i).getMatricula() + "</td>" + "<td>" + listaNaves.get(i).getTipo() + "</td>" + "</td>" + "<td></td>" + "</tr>";
				}
				str += "</table>" + "</div>";
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}

		return str;
	}

	public String mostrarTablaEliminarNaves() {

		String str = "";

		try {
			ArrayList<Nave> listaNaves = NaveDAO.getInstance().listar();

			if (listaNaves.isEmpty()) {
				str += "<div class='table table-hover'>" + "<p>No se encuentran resultados de naves</p>" + "</div>";
			} else {

				str += "<div class='table table-hover'>" + "<table class='table'>" + "<tr>" + "<th></th>" + "<th>Capitán</th>" + "<th>Nombre</th>" + "<th>Matrícula</th>" + "<th>Tipo</th>" + "<th></th>" + "</tr>";
				for (int i = 0; i < listaNaves.size(); i++) {
					str += "<tr>" + "<td></td>" + "<td>" + listaNaves.get(i).getCapitan() + "</td>" + "<td>" + listaNaves.get(i).getNombre() + "</td>" + "<td>" + listaNaves.get(i).getMatricula() + "</td>" + "<td>" + listaNaves.get(i).getTipo() + "</td>" + "<td>" + "<td><a href='/FlotaEstelarEE/ServNave?action=eliminar&id_nave=" + listaNaves.get(i).getId_nave() + "'><img id='icono-eliminar-cuaderno' alt='icono-eliminar' src='Front/Imagenes/papelera.png' class='boton-eliminar'></a></td>" + "<td></td>" + "</tr>";
				}
				str += "</table>" + "</div>";
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}

		return str;
	}

	public String mostrarTablaActualizarNavesPasoUno() {

		String str = "";

		try {
			ArrayList<Nave> listaNaves = NaveDAO.getInstance().listar();

			if (listaNaves.isEmpty()) {
				str += "<div class='table table-hover'>" + "<p>No se encuentran resultados de naves</p>" + "</div>";
			} else {

				str += "<div class='table table-hover'>"
				+ "<table class='table'>"
				+ "<tr>" 
				+ "<th></th>"
				+ "<th>Capitán</th>"
				+ "<th>Nombre</th>" 
				+ "<th>Matrícula</th>" 
				+ "<th>Tipo</th>" 
				+ "<th></th>" 
				+ "</tr>";
				for (int i = 0; i < listaNaves.size(); i++) {
					int id_nave = listaNaves.get(i).getId_nave();
					str += "<tr>" 
				+ "<td></td>" 
				+ "<td>" + listaNaves.get(i).getCapitan() + "</td>" 
				+ "<td>" + listaNaves.get(i).getNombre() + "</td>"
				+ "<td>" + listaNaves.get(i).getMatricula() + "</td>" 
				+ "<td>" + listaNaves.get(i).getTipo() + "</td>" 
				+ "<td><a href='ServNave?action=actualizar&id_nave="+id_nave+"'><img id='icono-actualizar-cuaderno' alt='icono-actualizar' src='Front/Imagenes/icono-actualizar.png' class='boton-actualizar'></a></td>" 
				+ "<td></td>" 
				+ "</tr>";
				}
				str += "</table>" + "</div>";
			}
		} catch (Exception ex) {
			System.out.println("Error aquí: "+ex);
		}

		return str;
	}

	public void eliminarNave(int id_nave) {
		try {
			NaveDAO.getInstance().eliminar(id_nave);
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}

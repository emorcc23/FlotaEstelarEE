package modelo;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.MisionDAO;

/**
 * 
 * @author Álvaro Santos
 *
 */

public class Mision {

	private int id_mision;
	private String nombre;
	private String descripcion;
	private int id_nave;

	public Mision() {
	}
	
	public Mision(int id_mision) {
		this.id_mision = id_mision;
	}

	public Mision(String nombre, String descripcion, int id_nave) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.id_nave = id_nave;
	}

	public Mision(int id_mision, String nombre, String descripcion, int id_nave) {
		this.id_mision = id_mision;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.id_nave = id_nave;
	}

	public int getId_mision() {
		return id_mision;
	}

	public void setId_mision(int id_mision) {
		this.id_mision = id_mision;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getId_nave() {
		return id_nave;
	}

	public void setId_nave(int id_nave) {
		this.id_nave = id_nave;
	}

	public void insertar() {
		try {
			MisionDAO.getInstance().insertar(this);
		} catch (Exception ex) {
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: Mision \n" + "\t Metodo: insertar(Mision e) \n" + "\t Error: " + ex);
		}
	}

	public ArrayList<Mision> listar() {
		ArrayList<Mision> listaMisiones = new ArrayList<>();
		try {
			listaMisiones = MisionDAO.getInstance().listar();
		} catch (Exception ex) {
			listaMisiones = null;
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: Mision \n" + "\t Metodo: listar() \n" + "\t Error: " + ex);
		}
		return listaMisiones;
	}
	
	public Mision buscarPorId(int id) throws SQLException {
		Mision mision = MisionDAO.getInstance().buscarPorPk(id);
		return mision;
	}

	public Mision listarPorPk(int id) {
		Mision n = new Mision();
		try {
			n = MisionDAO.getInstance().listarPorPk(id);
		} catch (Exception ex) {
			n = null;
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: Mision \n" + "\t Metodo: listarPorPk(int id) \n" + "\t Error: " + ex);
		}
		return n;
	}

	public void eliminar(Mision e) {
		try {
			MisionDAO.getInstance().eliminar(e);
		} catch (Exception ex) {
			e = null;
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: Mision \n" + "\t Metodo: eliminar(Mision e) \n" + "\t Error: " + ex);
		}
	}

	public void actualizar(Mision e) {
		try {
			MisionDAO.getInstance().actualizar(e);
		} catch (Exception ex) {
			e = null;
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: Mision \n" + "\t Metodo: actualizar(Mision e) \n" + "\t Error: " + ex);
		}
	}

	public String mostrarTablaMision() {
		String str = "";

		try {
			ArrayList<Mision> listaMisiones = MisionDAO.getInstance().listar();
			if (listaMisiones.isEmpty()) {

			} else {
				str += "<div class='table table-hover'>" 
					+ "<table class='table'>" 
					+ "<tr>" 
					+ "<th></th>" 
					+ "<th>Nombre</th>" 
					+ "<th>Descripción</th>" 
					+ "<th>Nave</th>" 
					+ "<th></th>" 
					+ "</tr>";
				for (int i = 0; i < listaMisiones.size(); i++) {
					str += "<tr>" 
						+ "<td></td>" 
							+ "<td>"+listaMisiones.get(i).getNombre()+"</td>" 
							+ "<td>" + listaMisiones.get(i).getDescripcion()+"</td>" 
							+ "<td>" + listaMisiones.get(i).getId_nave()+"</td>" 
							+ "<td></td>" 
							+ "</tr>";
				}
				str+="</table>"
						+ "</div>";
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}

		return str;
	}
	
	public String mostrarTablaEliminarMision() {
		String str = "";

		try {
			ArrayList<Mision> listaMisiones = MisionDAO.getInstance().listar();
			if (listaMisiones.isEmpty()) {
				str += "<div class='table table-hover'>"
						+ "<p>No se encuentran resultados de misiones</p>"
						+ "</div>";
			} else {
				str += "<div class='table table-hover'>" 
					+ "<table class='table'>" 
					+ "<tr>" 
					+ "<th></th>" 
					+ "<th>Nombre</th>" 
					+ "<th>Descripción</th>" 
					+ "<th>Nave</th>" 
					+ "<th></th>" 
					+ "</tr>";
				for (int i = 0; i < listaMisiones.size(); i++) {
					int id_mision = listaMisiones.get(i).getId_mision();
					str += "<tr>" 
						+ "<td></td>" 
							+ "<td>"+listaMisiones.get(i).getNombre()+"</td>" 
							+ "<td>" + listaMisiones.get(i).getDescripcion()+"</td>" 
							+ "<td>" + listaMisiones.get(i).getId_nave()+"</td>"
							+ "<td><a href='/FlotaEstelarEE/ServMision?action=eliminar&id_mision="+id_mision+"'><img id='icono-eliminar-mision' alt='icono-eliminar' src='Front/Imagenes/papelera.png' class='boton-eliminar'></a></td>" 
							+ "<td></td>" 
							+ "</tr>";
				}
				str+="</table>"
						+ "</div>";
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}

		return str;
	}
	
	public String mostrarTablaActualizarMision() {
		String str = "";

		try {
			ArrayList<Mision> listaMisiones = MisionDAO.getInstance().listar();
			if (listaMisiones.isEmpty()) {

			} else {
				str += "<div class='table table-hover'>" 
					+ "<table class='table'>" 
					+ "<tr>" 
					+ "<th></th>" 
					+ "<th>Nombre</th>" 
					+ "<th>Descripción</th>" 
					+ "<th>Misión</th>" 
					+ "<th></th>" 
					+ "</tr>";
				for (int i = 0; i < listaMisiones.size(); i++) {
					int id_mision = listaMisiones.get(i).getId_mision();
					str += "<tr>" 
						+ "<td></td>" 
							+ "<td>"+listaMisiones.get(i).getNombre()+"</td>" 
							+ "<td>" + listaMisiones.get(i).getDescripcion()+"</td>" 
							+ "<td>" + listaMisiones.get(i).getId_mision()+"</td>"
							+ "<td><a href='ServMision?action=actualizar&id_mision="+id_mision+"'><img id='icono-actualizar-mision' alt='icono-actualizar' src='Front/Imagenes/icono-actualizar.png' class='boton-actualizar'></a></td>" 
							+ "<td></td>" 
							+ "</tr>";
				}
				str+="</table>"
						+ "</div>";
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}

		return str;
	}
	
	public void eliminarMision(int id_mision) {
		try {
			MisionDAO.getInstance().eliminar(id_mision);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
	}

}

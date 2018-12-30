package modelo;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.CuadernoDAO;

/**
 * 
 * @author Álvaro Santos
 *
 */

public class Cuaderno {

	private int id_cuaderno;
	private String fecha;
	private String descripcion;
	private String audio;
	private int id_nave;

	public Cuaderno() {
	}

	public Cuaderno(int id_cuaderno) {
		this.id_cuaderno = id_cuaderno;
	}
	
	public Cuaderno(int id_cuaderno, String fecha, String descripcion, String audio, int id_nave) {
		this.id_cuaderno = id_cuaderno;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.audio = audio;
		this.id_nave = id_nave;
	}

	public Cuaderno(String fecha, String descripcion, String audio,int id_nave) {
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.audio = audio;
		this.id_nave = id_nave;
	}

	public int getId_cuaderno() {
		return id_cuaderno;
	}

	public void setId_cuaderno(int id_cuaderno) {
		this.id_cuaderno = id_cuaderno;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getAudio() {
		return audio;
	}

	public void setAudio(String audio) {
		this.audio = audio;
	}
	
	public int getId_nave() {
		return id_nave;
	}

	public void setId_nave(int id_nave) {
		this.id_nave = id_nave;
	}

	public void insertar() {
		try {
			CuadernoDAO.getInstance().insertar(this);
		} catch (Exception ex) {
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: Cuaderno \n" + "\t Metodo: insertar(Cuaderno e) \n"
					+ "\t Error: " + ex);
		}
	}

	public ArrayList<Cuaderno> listar() {
		ArrayList<Cuaderno> listaCuadernos = new ArrayList<>();
		try {
			listaCuadernos = CuadernoDAO.getInstance().listar();
		} catch (Exception ex) {
			listaCuadernos = null;
			System.out.println(
					"ERROR CONTROLADO: \n " + "\t Clase: Cuaderno \n" + "\t Metodo: listar() \n" + "\t Error: " + ex);
		}
		return listaCuadernos;
	}

	public Cuaderno listarPorPk(int id) {
		Cuaderno n = new Cuaderno();
		try {
			n = CuadernoDAO.getInstance().listarPorPk(id);
		} catch (Exception ex) {
			n = null;
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: Cuaderno \n" + "\t Metodo: listarPorPk(int id) \n"
					+ "\t Error: " + ex);
		}
		return n;
	}

	public Cuaderno buscarPorId(int id) throws SQLException {
		Cuaderno cuaderno = CuadernoDAO.getInstance().buscarPorPk(id);
		return cuaderno;
	}
	
	public void eliminar(Cuaderno e) {
		try {
			CuadernoDAO.getInstance().eliminar(e);
		} catch (Exception ex) {
			e = null;
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: Cuaderno \n" + "\t Metodo: eliminar(Cuaderno e) \n"
					+ "\t Error: " + ex);
		}
	}

	public void actualizar(Cuaderno e) {
		try {
			CuadernoDAO.getInstance().actualizar(e);
		} catch (Exception ex) {
			e = null;
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: Cuaderno \n"
					+ "\t Metodo: actualizar(Cuaderno e) \n" + "\t Error: " + ex);
		}
	}

	public int extraerUltimoId() {
		int ultimoId;
		Cuaderno n = new Cuaderno();
		try {
			ultimoId = n.extraerUltimoId();
		} catch (Exception ex) {
			ultimoId = 0;
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: Cuaderno \n" + "\t Metodo: extraerUltimoId() \n"
					+ "\t Error: " + ex);
		}
		return ultimoId;
	}
	
	public String mostrarTablaCuaderno() {
		String str = "";
		
		try {
			ArrayList<Cuaderno> listaCuadernos = CuadernoDAO.getInstance().listar();
			if(listaCuadernos.isEmpty()) {
				str+="<div class='table table-hover'>"
						+ "<p>No se encuentran resultados de Cuadernos de bitácora</p>"
						+ "</div>";
			} else {
				str+="<div class='table table-hover'>"
						+ "<table class='table'>"
						+ "<tr>"
						+ "<th></th>"
						+ "<th>Fecha</th>"
						+ "<th>Descripción</th>"
						+ "<th>Audio</th>"
						+ "<th>Nave</th>"
						+ "<th></th>"
						+ "</tr>";
				for(int i = 0; i < listaCuadernos.size(); i++) {
					str+="<tr>"
							+ "<td></td>"
							+ "<td>"+listaCuadernos.get(i).getFecha()+"</td>"
							+ "<td>"+listaCuadernos.get(i).getDescripcion()+"</td>"
							+ "<td>"+listaCuadernos.get(i).getAudio()+"</td>"
							+ "<td>"+listaCuadernos.get(i).getId_nave()+"</td>"
							+ "<td></td>"
							+ "</tr>";
				}
				str+="</table>"
						+ "</div>";
			}
		} catch(Exception ex) {
			System.out.println(ex);
		}
		
		return str;
	}
	
	public String mostrarTablaEliminarCuaderno() {
		String str = "";
		
		try {
			ArrayList<Cuaderno> listaCuadernos = CuadernoDAO.getInstance().listar();
			if(listaCuadernos.isEmpty()) {
				str+="<div class='table table-hover'>"
						+ "<p>No se encuentran resultados de Cuadernos de bitácora</p>"
						+ "</div>";
			} else {
				str+="<div class='table table-hover'>"
						+ "<table class='table'>"
						+ "<tr>"
						+ "<th></th>"
						+ "<th>Fecha</th>"
						+ "<th>Descripción</th>"
						+ "<th>Audio</th>"
						+ "<th>Nave</th>"
						+ "<th></th>"
						+ "</tr>";
				for(int i = 0; i < listaCuadernos.size(); i++) {
					str+="<tr>"
							+ "<td></td>"
							+ "<td>"+listaCuadernos.get(i).getFecha()+"</td>"
							+ "<td>"+listaCuadernos.get(i).getDescripcion()+"</td>"
							+ "<td>"+listaCuadernos.get(i).getAudio()+"</td>"
							+ "<td>"+listaCuadernos.get(i).getId_nave()+"</td>"
							+ "<td><a href='/FlotaEstelarEE/ServCuaderno?action=eliminar&id_cuaderno="+listaCuadernos.get(i).getId_cuaderno()+"'><img id='icono-eliminar-cuaderno' alt='icono-eliminar' src='Front/Imagenes/papelera.png' class='boton-eliminar'></a></td>"
							+ "<td></td>"
							+ "</tr>";
				}
				str+="</table>"
						+ "</div>";
			}
		} catch(Exception ex) {
			System.out.println(ex);
		}
		
		return str;
	}
	
	public String mostrarTablaActualizarCuaderno() {
		String str = "";
		
		try {
			ArrayList<Cuaderno> listaCuadernos = CuadernoDAO.getInstance().listar();
			if(listaCuadernos.isEmpty()) {
				str+="<div class='table table-hover'>"
						+ "<p>No se encuentran resultados de Cuadernos de bitácora</p>"
						+ "</div>";
			} else {
				str+="<div class='table table-hover'>"
						+ "<table class='table'>"
						+ "<tr>"
						+ "<th></th>"
						+ "<th>Fecha</th>"
						+ "<th>Descripción</th>"
						+ "<th>Audio</th>"
						+ "<th>Nave</th>"
						+ "<th></th>"
						+ "</tr>";
				for(int i = 0; i < listaCuadernos.size(); i++) {
					int id_cuaderno = listaCuadernos.get(i).getId_cuaderno();
					str+="<tr>"
							+ "<td></td>"
							+ "<td>"+listaCuadernos.get(i).getFecha()+"</td>"
							+ "<td>"+listaCuadernos.get(i).getDescripcion()+"</td>"
							+ "<td>"+listaCuadernos.get(i).getAudio()+"</td>"
							+ "<td>"+listaCuadernos.get(i).getId_nave()+"</td>"
							+ "<td><a href='ServCuaderno?action=actualizar&id_cuaderno="+id_cuaderno+"'><img id='icono-actualizar-cuaderno' alt='icono-actualizar' src='Front/Imagenes/icono-actualizar.png' class='boton-actualizar'></a></td>"
							+ "<td></td>"
							+ "</tr>";
				}
				str+="</table>"
						+ "</div>";
			}
		} catch(Exception ex) {
			System.out.println(ex);
		}
		
		return str;
	}
	
	public void eliminarCuaderno(int id_cuaderno) {
		try {
			CuadernoDAO.getInstance().eliminar(id_cuaderno);
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}

package modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import dao.TripulanteDAO;

/**
 * 
 * @author Álvaro Santos
 * 
 */

public class Tripulante {

	private int id_tripulante;
	private String nombre;
	private String cargo;
	private String genero;
	private int experiencia;
	private String origen;
	private String raza;
	private int edad;
	private int id_nave;
	
	public Tripulante() {}
	
	public Tripulante(int id_tripulante) {
		this.id_tripulante = id_tripulante;
	}
	
	public Tripulante(String nombre, String cargo, String genero, int experiencia, String origen, String raza, int edad, int id_nave) {
		this.nombre = nombre;
		this.cargo = cargo;
		this.genero = genero;
		this.experiencia = experiencia;
		this.origen = origen;
		this.raza = raza;
		this.edad = edad;
		this.id_nave = id_nave;
	}
	
	public Tripulante(int id_tripulante, String nombre, String cargo, String genero, int experiencia, String origen, String raza, int edad, int id_nave) {
		this.id_tripulante = id_tripulante;
		this.nombre = nombre;
		this.cargo = cargo;
		this.genero = genero;
		this.experiencia = experiencia;
		this.origen = origen;
		this.raza = raza;
		this.edad = edad;
		this.id_nave = id_nave;
	}

	public int getId_tripulante() {
		return id_tripulante;
	}

	public void setId_tripulante(int id_tripulante) {
		this.id_tripulante = id_tripulante;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getId_nave() {
		return id_nave;
	}

	public void setId_nave(int id_nave) {
		this.id_nave = id_nave;
	}
	
	public void insertar() {
		try {
			TripulanteDAO.getInstance().insertar(this);
		} catch (Exception ex) {
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: Tripulante \n" + "\t Metodo: insertar(Tripulante e) \n"
					+ "\t Error: " + ex);
		}
	}

	public ArrayList<Tripulante> listar() {
		ArrayList<Tripulante> listaTripulantes = new ArrayList<>();
		try {
			listaTripulantes = TripulanteDAO.getInstance().listar();
		} catch (Exception ex) {
			listaTripulantes = null;
			System.out.println(
					"ERROR CONTROLADO: \n " + "\t Clase: Tripulante \n" + "\t Metodo: listar() \n" + "\t Error: " + ex);
		}
		return listaTripulantes;
	}

	public Tripulante listarPorPk(int id) {
		
		
		Tripulante n = new Tripulante();
		try {
			n = TripulanteDAO.getInstance().listarPorPk(id);
		} catch (Exception ex) {
			n = null;
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: Tripulante \n" + "\t Metodo: listarPorPk(int id) \n"
					+ "\t Error: " + ex);
		}
		return n;
	}

	public void eliminar(Tripulante e) {
		try {
			TripulanteDAO.getInstance().eliminar(e);
		} catch (Exception ex) {
			e = null;
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: Tripulante \n" + "\t Metodo: eliminar(Tripulante e) \n"
					+ "\t Error: " + ex);
		}
	}

	public void actualizar(Tripulante e) {
		try {
			TripulanteDAO.getInstance().actualizar(e);
		} catch (Exception ex) {
			e = null;
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: Tripulante \n" + "\t Metodo: actualizar(Tripulante e) \n"
					+ "\t Error: " + ex);
		}
	}

	public int extraerUltimoId() {
		int ultimoId;
		Tripulante n = new Tripulante();
		try {
			ultimoId = TripulanteDAO.getInstance().extraerUltimoId();
		} catch (Exception ex) {
			ultimoId = 0;
			System.out.println("ERROR CONTROLADO: \n " + "\t Clase: Tripulante \n" + "\t Metodo: extraerUltimoId() \n"
					+ "\t Error: " + ex);
		}
		return ultimoId;
	}
	
	public String mostrarTablaTripulantes() {
		
		String str = "";
		
		try {
			ArrayList<Tripulante> listaTripulantes = TripulanteDAO.getInstance().listar();
			
			if(listaTripulantes.isEmpty()) {
				str+="<div class='table table-hover'>"
						+ "<p>No se encuentran resultados de naves</p>"
						+ "</div>";
			} else {
				str+="<div class='table table-hover'>"
						+ "<table class='table'>"
						+ "<tr>"
						+ "<th></th>"
						+ "<th>Nombre</th>"
						+ "<th>Cargo</th>"
						+ "<th>Género</th>"
						+ "<th>Experiencia</th>"
						+ "<th>Origen</th>"
						+ "<th>Raza</th>"
						+ "<th>Edad</th>"
						+ "<th>Nave</th>"
						+ "<th></th>"
						+ "</tr>";
				for(int i = 0; i < listaTripulantes.size(); i++) {
					str+="<tr>"
							+ "<td></td>"
							+ "<td>"+listaTripulantes.get(i).getNombre()+"</td>"
							+ "<td>"+listaTripulantes.get(i).getCargo()+"</td>"
							+ "<td>"+listaTripulantes.get(i).getGenero()+"</td>"
							+ "<td>"+listaTripulantes.get(i).getExperiencia()+"</td>"
							+ "<td>"+listaTripulantes.get(i).getOrigen()+"</td>"
							+ "<td>"+listaTripulantes.get(i).getRaza()+"</td>"
							+ "<td>"+listaTripulantes.get(i).getEdad()+"</td>"
							+ "<td>"+listaTripulantes.get(i).getId_nave()+"</td>"
							+ "<td></td>"
							+ "</tr>";
				}
				str+= "</table>"
						+ "</div>";
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		return str;
	}
	
	public String mostrarTablaEliminarTripulantes() {
		
		String str = "";
		
		try {
			ArrayList<Tripulante> listaTripulantes = TripulanteDAO.getInstance().listar();
			
			if(listaTripulantes.isEmpty()) {
				str+="<div class='table table-hover'>"
						+ "<p>No se encuentran resultados de naves</p>"
						+ "</div>";
			} else {
				str+="<div class='table table-hover'>"
						+ "<table class='table'>"
						+ "<tr>"
						+ "<th></th>"
						+ "<th>Nombre</th>"
						+ "<th>Cargo</th>"
						+ "<th>Género</th>"
						+ "<th>Experiencia</th>"
						+ "<th>Origen</th>"
						+ "<th>Raza</th>"
						+ "<th>Edad</th>"
						+ "<th>Nave</th>"
						+ "<th></th>"
						+ "</tr>";
				for(int i = 0; i < listaTripulantes.size(); i++) {
					str+="<tr>"
							+ "<td></td>"
							+ "<td>"+listaTripulantes.get(i).getNombre()+"</td>"
							+ "<td>"+listaTripulantes.get(i).getCargo()+"</td>"
							+ "<td>"+listaTripulantes.get(i).getGenero()+"</td>"
							+ "<td>"+listaTripulantes.get(i).getExperiencia()+"</td>"
							+ "<td>"+listaTripulantes.get(i).getOrigen()+"</td>"
							+ "<td>"+listaTripulantes.get(i).getRaza()+"</td>"
							+ "<td>"+listaTripulantes.get(i).getEdad()+"</td>"
							+ "<td>"+listaTripulantes.get(i).getId_nave()+"</td>"
							+ "<td></td>"
							+ "<td><a href='/FlotaEstelarEE/ServTripulante?action=eliminar&id_tripulante="+listaTripulantes.get(i).getId_tripulante()+"'><img id='icono-eliminar-tripulante' alt='icono-eliminar' src='Front/Imagenes/papelera.png' class='boton-eliminar'></a></td>"
							+ "</tr>";
				}
				str+= "</table>"
						+ "</div>";
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		return str;
	}
	
public String mostrarTablaActualizarTripulantesPasoUno() {
		
		String str = "";
		
		try {
			ArrayList<Tripulante> listaTripulantes = TripulanteDAO.getInstance().listar();
			
			if(listaTripulantes.isEmpty()) {
				str+="<div class='table table-hover'>"
						+ "<p>No se encuentran resultados de naves</p>"
						+ "</div>";
			} else {
				str+="<div class='table table-hover'>"
						+ "<table class='table'>"
						+ "<tr>"
						+ "<th></th>"
						+ "<th>Nombre</th>"
						+ "<th>Cargo</th>"
						+ "<th>Género</th>"
						+ "<th>Experiencia</th>"
						+ "<th>Origen</th>"
						+ "<th>Raza</th>"
						+ "<th>Edad</th>"
						+ "<th>Nave</th>"
						+ "<th></th>"
						+ "</tr>";
				for(int i = 0; i < listaTripulantes.size(); i++) {
					int id_tripulante = listaTripulantes.get(i).getId_tripulante();
					str+="<tr>"
							+ "<td></td>"
							+ "<td>"+listaTripulantes.get(i).getNombre()+"</td>"
							+ "<td>"+listaTripulantes.get(i).getCargo()+"</td>"
							+ "<td>"+listaTripulantes.get(i).getGenero()+"</td>"
							+ "<td>"+listaTripulantes.get(i).getExperiencia()+"</td>"
							+ "<td>"+listaTripulantes.get(i).getOrigen()+"</td>"
							+ "<td>"+listaTripulantes.get(i).getRaza()+"</td>"
							+ "<td>"+listaTripulantes.get(i).getEdad()+"</td>"
							+ "<td>"+listaTripulantes.get(i).getId_nave()+"</td>"
							+ "<td></td>"
							+ "<td><a href='ServTripulante?action=actualizar&id_tripulante="+id_tripulante+"'><img id='icono-actualizar-tripulante' alt='icono-actualizar' src='Front/Imagenes/icono-actualizar.png' class='boton-actualizar'></a></td>"
							+ "</tr>";
				}
				str+= "</table>"
						+ "</div>";
			}
		} catch (Exception ex) {
			System.out.println("Error aquí: "+ex);
		}
		return str;
	}

	public void eliminarTripulante(int id_tripulante) {
		try {
			TripulanteDAO.getInstance().eliminar(id_tripulante);
		} catch(Exception ex) {
			System.out.println(ex);
		}
	}
	
	public String mostrarTablaActualizarTripulantePasoDos(int id) {
		
		String str ="";
		try {
			
			str+="<form action='/FlotaEstelarEE/ServTripulante' method='POST'>"
					+ "<div class='form-group'>"
					+ "<input type='text' class='form-control' placeholder='ID del tripulante: "+id+"' name='id_tripulante' readonly='yes'>"
					+ "</div>"
					+ "<div class='form-group'>"
					+ "<input type='text' class='form-control' placeholder='Nombre del tripulante *' name='nombre'>"
					+ "</div>"
					+ "<div class='form-group'>"
					+ "<input type='text' class='form-control' placeholder='Cargo del tripulante *' name='cargo'>"
					+ "</div>"
					+ "<div class='form-control'>"
					+ "<input type='text' class='form-control' placeholder='Género del tripulante *' name='genero'>"
					+ "</div>"
					+ "<div class='form-control'>"
					+ "<input type='number' class='form-control' placeholder='Experiencia del tripulante *' name='experiencia'>"
					+ "</div>"
					+ "<div class='form-control'>"
					+ "<input type='text' class='form-control' placeholder='Origen del tripulante *' name='origen'>"
					+ "</div>"
					+ "<div class='form-control'>"
					+ "<input type='number' class='form-control' placeholder='Edad del tripulante *' name='raza'>"
					+ "</div>"
					+ "<div class='form-group'>"
					+ "<select name='id_nave'>";
			Nave nave = new Nave();
			ArrayList<Nave> listaIdNaves = nave.extraerIdNaves(); 
			for(int i = 0; i < listaIdNaves.size(); i++) {
				str+="<option value='"+listaIdNaves.get(i).getId_nave()+"'>"+listaIdNaves.get(i).getId_nave()+"</option>";
			}
			str+="</select>"
					+ "<div class='form-group'>"
					+ "<button type='submit' class='btn btn-secondary btnSubmit'>Registrar</button>"
					+ "</div>"
					+ "</form>";
		} catch(Exception ex) {
			System.out.println(ex);
		}
		
		return str;
	}
	
	public Tripulante buscarPorId(int id) throws SQLException {
		Tripulante tripulante = TripulanteDAO.getInstance().buscarPorPk(id);
		return tripulante;
	}

}





















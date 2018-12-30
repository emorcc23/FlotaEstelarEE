package servicio;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Tripulante;

/**
 * Servlet implementation class ServActTripulante
 */
@WebServlet("/ServActTripulante")
public class ServActTripulante extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServActTripulante() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		int id_tripulante = Integer.parseInt(request.getParameter("id_tripulante"));
		String nombre = request.getParameter("nombre");
		String cargo = request.getParameter("cargo");
		String genero = request.getParameter("genero");
		int experiencia = Integer.parseInt(request.getParameter("experiencia"));
		String origen = request.getParameter("origen");
		String raza = request.getParameter("raza");
		int edad = Integer.parseInt(request.getParameter("edad"));
		int id_nave = Integer.parseInt(request.getParameter("id_nave"));
		
		System.out.println("id_tripulante: "+id_tripulante);
		System.out.println("Nombre: "+nombre);
		System.out.println("Cargo: "+cargo);
		System.out.println("Genero: "+genero);
		System.out.println("Experiencia: "+experiencia);
		System.out.println("Origen: "+origen);
		System.out.println("Raza: "+raza);
		System.out.println("Edad: "+edad);
		System.out.println("Id_nave: "+id_nave);
		
		try {

			
			
			
			Tripulante tripulante = new Tripulante(id_tripulante,nombre,cargo,genero,experiencia,origen,raza,edad,id_nave);
			tripulante.actualizar(tripulante);
			response.sendRedirect("index.jsp");
			
			
		} catch (Exception ex) {
			System.out.println("Error en: "+ex);
		}

	}

}

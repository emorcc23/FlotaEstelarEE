package servicio;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Tripulante;

/**
 * Servlet implementation class ServTripulante2
 */
@WebServlet("/ServTripulante2")
public class ServTripulante2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServTripulante2() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String nombre = request.getParameter("nombre");
		String cargo = request.getParameter("cargo");
		String genero = request.getParameter("genero");
		int experiencia = Integer.parseInt(request.getParameter("experiencia"));
		String origen = request.getParameter("origen");
		String raza = request.getParameter("raza");
		int edad = Integer.parseInt(request.getParameter("edad"));
		int id_nave = Integer.parseInt(request.getParameter("id_nave"));
		
		Tripulante tripulante = new Tripulante(nombre,cargo,genero,experiencia,origen,raza,edad,id_nave);
	
		
		tripulante.insertar();
		
		response.sendRedirect("index.jsp");
		
	}

}

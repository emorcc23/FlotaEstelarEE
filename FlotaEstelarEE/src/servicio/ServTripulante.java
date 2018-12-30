package servicio;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Tripulante;

/**
 * Servlet implementation class ServTripulante
 */
@WebServlet("/ServTripulante")
public class ServTripulante extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServTripulante() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String action = request.getParameter("action");
		int id = Integer.parseInt(request.getParameter("id_tripulante"));
		
		switch(action) {
		case "eliminar":
			try {
				Tripulante tripulante = new Tripulante();
				tripulante.eliminarTripulante(id);
				response.sendRedirect("index.jsp");
			} catch (Exception ex) {
				System.out.println("Error: "+ex);
			}
			break;
		case "actualizar":
			try {
				System.out.println("Entro en actualizar");
				int id_tripulante = Integer.parseInt(request.getParameter("id_tripulante"));
				System.out.println("Id del tripulante en actualizar: "+id_tripulante);
				Tripulante tripulante = new Tripulante(id_tripulante);
				
				tripulante = tripulante.buscarPorId(Integer.parseInt(request.getParameter("id_tripulante")));
				request.setAttribute("tripulante", tripulante);
				
				RequestDispatcher d = request.getRequestDispatcher("/Includes/ActualizarPasoDosTripulante.jsp");
				d.forward(request, response);
			} catch (Exception ex) {
				System.out.println("Error conrolado: "+ex);
			}			
			break;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		response.sendRedirect("/Includes/ActualizarPasoDosTripulante.jsp");
	}

}

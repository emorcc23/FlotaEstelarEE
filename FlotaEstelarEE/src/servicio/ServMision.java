package servicio;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Mision;

/**
 * Servlet implementation class ServMision
 */
@WebServlet("/ServMision")
public class ServMision extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServMision() {
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
		int id = Integer.parseInt(request.getParameter("id_mision"));
		
		switch(action) {
		case "eliminar":
			try {
				Mision mision = new Mision();
				mision.eliminarMision(id);
				response.sendRedirect("index.jsp");
			} catch (Exception ex) {
				System.out.println("Error: "+ex);
			}
			break;
		case "actualizar":
			try {
				System.out.println("Entro en actualizaaar");
				int id_mision = Integer.parseInt(request.getParameter("id_mision"));
				System.out.println("Id de l amision en actualizar "+id_mision);
				Mision mision = new Mision(id_mision);
				
				mision = mision.buscarPorId(Integer.parseInt(request.getParameter("id_mision")));
				request.setAttribute("mision", mision);
				
				//Redireccionamiento con datos
				RequestDispatcher d = request.getRequestDispatcher("/Includes/ActualizarPasoDosMision.jsp");
				d.forward(request, response);
				
			} catch (Exception ex) {
				System.out.println("Error controlado: " + "\t Clase: ServMision Método: doGet actualizar" + "\t Error: " + ex);
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
		
		response.sendRedirect("/Includes/ActualizarPasoDosMision.jsp");
	}

}
























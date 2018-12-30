package servicio;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NaveDAO;
import modelo.Nave;

/**
 * Servlet implementation class ServNave
 */
@WebServlet("/ServNave")
public class ServNave extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServNave() {
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
		int id = Integer.parseInt(request.getParameter("id_nave"));
		
		switch(action) {
			case "eliminar":
				try {
					Nave nave = new Nave();
					nave.eliminarNave(id);
					response.sendRedirect("index.jsp");
				} catch (Exception ex) {
					System.out.println("Error: "+ex);
				}
				
				
				break;
			case "actualizar":
				try {
					System.out.println("Entro en actualizar");
					int id_nave = Integer.parseInt(request.getParameter("id_nave"));
					System.out.println("Id de la nave en actualizar: " + id_nave);
					Nave nave = new Nave(id_nave);

					nave = nave.buscarPorId(Integer.parseInt(request.getParameter("id_nave")));
					request.setAttribute("nave", nave);

					// Redireccionamiento con datos
					RequestDispatcher d = request.getRequestDispatcher("/Includes/ActualizarPasoDosNave.jsp");
					d.forward(request, response);

				} catch (Exception ex) {
					System.out.println("Error controlado: " + "\t Clase: ServNave Método: doGet actualizar" + "\t Error: " + ex);
				}
				

			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.sendRedirect("/Includes/ActualizarPasoDosNave.jsp");
	}

}






















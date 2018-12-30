package servicio;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Cuaderno;

/**
 * Servlet implementation class ServCuaderno
 */
@WebServlet("/ServCuaderno")
public class ServCuaderno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServCuaderno() {
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
		int id = Integer.parseInt(request.getParameter("id_cuaderno"));
		System.out.println("ID_cuaderno en EL SERVLET: "+id);
		
		switch(action) {
		case "eliminar":
			try {
				Cuaderno cuaderno = new Cuaderno();
				cuaderno.eliminarCuaderno(id);
				response.sendRedirect("index.jsp");
			} catch (Exception ex) {
				System.out.println("Error: "+ex);
			}
			break;
		case "actualizar":
			try {
				System.out.println("Entro en actualizar");
				int id_cuaderno = Integer.parseInt(request.getParameter("id_cuaderno"));
				System.out.println("Id del cuadeno en actualizar: "+id_cuaderno);
				Cuaderno cuaderno = new Cuaderno(id_cuaderno);
				
				cuaderno = cuaderno.buscarPorId(Integer.parseInt(request.getParameter("id_cuaderno")));
				request.setAttribute("cuaderno", cuaderno);
				
				//Redireccionamiento con datos
				RequestDispatcher d = request.getRequestDispatcher("/Includes/ActualizarPasoDosCuaderno.jsp");
				d.forward(request, response);
			} catch (Exception ex) {
				System.out.println("Error controlado: " + "\t Clase: ServNave Método: doGet actualizar" + "\t Error: " + ex);
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
		response.sendRedirect("/Includes/ActualizarPasoDosCuaderno.jsp");
	}

}

























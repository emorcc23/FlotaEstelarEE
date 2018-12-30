package servicio;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Nave;

/**
 * Servlet implementation class ServNave2
 */
@WebServlet("/ServNave2")
public class ServNave2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServNave2() {
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
		
		String capitan = request.getParameter("capitan");
		String nombre = request.getParameter("nombre");
		String matricula = request.getParameter("matricula");
		String tipo = request.getParameter("tipo");
		
		Nave nave = new Nave(capitan,nombre,matricula,tipo);
	
		
		nave.insertar();
		
		response.sendRedirect("index.jsp");
		
	}

}

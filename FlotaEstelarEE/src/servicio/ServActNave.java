package servicio;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Nave;

/**
 * Servlet implementation class ServActNave
 */
@WebServlet("/ServActNave")
public class ServActNave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServActNave() {
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
		
		int id_nave = Integer.parseInt(request.getParameter("id_nave"));
		String capitan = request.getParameter("capitan");
		String nombre = request.getParameter("nombre");
		String matricula = request.getParameter("matricula");
		String tipo = request.getParameter("tipo");
		
		Nave nave = new Nave(id_nave, capitan,nombre,matricula,tipo);
		
		nave.actualizar(nave);
		
		response.sendRedirect("index.jsp");	
		
	}

}

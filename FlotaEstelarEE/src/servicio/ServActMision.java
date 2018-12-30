package servicio;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Mision;

/**
 * Servlet implementation class ServActMision
 */
@WebServlet("/ServActMision")
public class ServActMision extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServActMision() {
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
		
		int id_mision = Integer.parseInt(request.getParameter("id_mision"));
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		int id_nave = Integer.parseInt(request.getParameter("id_nave"));
		
		Mision mision = new Mision(id_mision,nombre,descripcion,id_nave);
		mision.actualizar(mision);
		response.sendRedirect("index.jsp");
		
	}

}














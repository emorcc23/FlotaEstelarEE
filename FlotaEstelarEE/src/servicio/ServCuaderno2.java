package servicio;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Cuaderno;

/**
 * Servlet implementation class ServCuaderno2
 */
@WebServlet("/ServCuaderno2")
public class ServCuaderno2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServCuaderno2() {
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
		
		String fecha = request.getParameter("fecha");
		String descripcion = request.getParameter("descripcion");
		String audio = request.getParameter("audio");
		int id_nave = Integer.parseInt(request.getParameter("id_nave"));
		
		Cuaderno cuaderno = new Cuaderno(fecha,descripcion,audio,id_nave);
		
		cuaderno.insertar();
		response.sendRedirect("index.jsp");
		
	}

}

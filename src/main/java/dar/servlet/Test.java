package dar.servlet;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Get parameters
		String longitude = req.getParameter("longitude");
		String laltitude = req.getParameter("laltitude");
	
		String url ="http://data.iledefrance.fr/api/records/1.0/search?geofilter.distance="+laltitude+","+longitude+",distance";
		HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
		con.setRequestMethod("GET");
		con.getOutputStream().write("LOGIN".getBytes("UTF-8"));
		con.getInputStream();
		
		
	}
}
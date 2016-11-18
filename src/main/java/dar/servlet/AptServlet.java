package dar.servlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.hibernate.SessionFactory;
import org.json.JSONArray;
import org.json.JSONObject;

import dar.core.Appartements;
import dar.core.Photos;
import dar.core.Users;
import dar.dao.AppartementDao;
import dar.dao.PhotoDao;
import dar.services.AppartServices;
import dar.tools.R;
import dar.utils.HandleHibernate;
import dar.utils.dbProfilTools;

@WebServlet("/apt")
@MultipartConfig
public class AptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String SAVE_DIR = "uploadFiles";

	public AptServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");

		SessionFactory sf = HandleHibernate.getSF();
		AppartementDao appdao = new AppartementDao(sf);
		List<Appartements> appartements = appdao.getAll(Appartements.class);

		JSONArray arr = new JSONArray();
		for (Appartements a : appartements)
			arr.put(a.toJSON());
		response.getWriter().append(new JSONObject().put("apps", arr).toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String PAGE_NOT_LOGGED = "/Login";
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		JSONObject json = new JSONObject();

		PrintWriter out = response.getWriter();
		System.out.println("************");
		HttpSession session = request.getSession();

		if (session.getAttribute("user") == null) {

			System.out.println("redirection vers la page d'authentification ...");
			try {
				json.put("c", 1);
				json.put("d", "user null");

			} catch (Exception e1) {
				e1.printStackTrace();
			}
			out.print(json.toString());
			System.out.println("Invalid shit ! ");
			response.sendRedirect(PAGE_NOT_LOGGED);

			return;
		}

		String login_user = (String) session.getAttribute("user");
		Users tmpUser = dbProfilTools.getUser(login_user);
		try {

			String adresse = request.getParameter(R.Apt.ADRESSE);
			// String description=request.getParameter("desc");
			// int arron=Integer.parseInt(request.getParameter("arron")) ;
			// String photo = request.getParameter(R.Apt.PHOTO);

			// save getPhoto
			Part filePart = request.getPart(R.Apt.PHOTO);
			String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
			String chemin = "";
			if (!"".equals(fileName)) {
				InputStream fileContent = filePart.getInputStream();
				chemin = savePhoto(fileContent, fileName);
			}

			int superficie = new Integer(request.getParameter(R.Apt.SUPERFICIE));
			String type = request.getParameter(R.Apt.TYPE);
			String meuble = request.getParameter(R.Apt.MEUBLE);
			int code_postal = Integer.valueOf(request.getParameter(R.Apt.CODEPOSTAL));
			Boolean m = Boolean.parseBoolean(meuble);
			String chaine_loyer = request.getParameter(R.Apt.LOYER);
			double loyer = Double.parseDouble(chaine_loyer);

			AppartServices.addAppart(tmpUser, adresse, loyer, superficie, type, m, code_postal, chemin);

			// addAppart(Users user,String adresse,double loyer, int superficie,
			// String type,boolean meuble,int cd)

		} catch (Exception e) {
			try {
				json.put("c", 1);
				json.put("d", "Mauvais param");

			} catch (Exception e1) {
				e.printStackTrace();
			}
			out.print(json.toString());
			return;

		}

		try {
			
			response.sendRedirect("index.jsp");
			
			json.put("c", 0);
			json.put("d", "ça marche");

		} catch (Exception e) {
			e.printStackTrace();
		}

		out.print(json.toString());
		return;
	}

	private String savePhoto(InputStream is, String filename) {
		Random r = new Random();
		int uniqueID = r.nextInt(1000000);
		String pathFile = "p_" + +uniqueID + filename;
		File file = new File(pathFile);
		System.out.println(file.getAbsolutePath());
		FileOutputStream os;
		try {
			os = new FileOutputStream(file);
			byte[] buf = new byte[1024];
			int len;

			while ((len = is.read(buf)) > 0) {
				os.write(buf, 0, len);
			}

			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file.getAbsolutePath();

	}



}

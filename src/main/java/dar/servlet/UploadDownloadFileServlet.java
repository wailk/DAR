package dar.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/UploadDownloadFileServlet")
public class UploadDownloadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletFileUpload uploader = null;
	private static final String SAVE_DIR = "uploadFiles";

	@Override
	public void init() throws ServletException {
		DiskFileItemFactory fileFactory = new DiskFileItemFactory();
		File filesDir = (File) getServletContext().getAttribute("FILES_DIR_FILE");
		fileFactory.setRepository(filesDir);
		this.uploader = new ServletFileUpload(fileFactory);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (!ServletFileUpload.isMultipartContent(request)) {
			throw new ServletException("Content type is not multipart/form-data");
		}

		try {
			List<FileItem> fileItemsList = uploader.parseRequest(request);
			Iterator<FileItem> fileItemsIterator = fileItemsList.iterator();
			while (fileItemsIterator.hasNext()) {
				FileItem fileItem = fileItemsIterator.next();
				System.out.println("FieldName=" + fileItem.getFieldName());
				System.out.println("FileName=" + fileItem.getName());
				System.out.println("ContentType=" + fileItem.getContentType());
				System.out.println("Size in bytes=" + fileItem.getSize());

				// ClassLoader classLoader = getClass().getClassLoader();
				// String pathFile =
				// classLoader.getResource(SAVE_DIR).toString() +
				// fileItem.getName();

				String pathFile = request.getServletContext().getAttribute("FILES_DIR") + File.separator
						+ fileItem.getName();
				System.out.println(pathFile);

				File file = new File(pathFile);
				System.out.println("Absolute Path at server=" + file.getAbsolutePath());
				fileItem.write(file);

			}
		} catch (FileUploadException e) {
			System.out.println("Exception in uploading file.");
		} catch (Exception e) {
			System.out.println("Exception in uploading file.");
		}
	}

}

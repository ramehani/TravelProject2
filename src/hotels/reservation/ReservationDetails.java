package hotels.reservation;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.reservation.ReservationDetailsContol;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * Servlet implementation class ReservationDetails
 */
public class ReservationDetails extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Configuration cfg;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationDetails() {
        super();
    }
    public void init() {
    	cfg = new Configuration();
    	cfg.setServletContextForTemplateLoading(
    	getServletContext(), "WEB-INF/templates");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			// Build the data-model
			Map<String, Object> root = new HashMap<String, Object>();
			ReservationDetailsContol rescreate = new ReservationDetailsContol();
//			retString=new String(rescreate.PrepareResults(request));
//			root.put("criteria",rescreate.setParameterObjects(request));
			root = rescreate.detailHandle(request);
			// Get the templat object
			Template t = cfg.getTemplate("book.ftl");
			 
			// Prepare the HTTP response:
			// - Use the charset of template for the output
			// - Use text/html MIME-type
			response.setContentType("text/html; charset=" + t.getEncoding());
			Writer out = response.getWriter();
			 
			// Merge the data-model and the template
			try {
			t.process(root, out);
			} catch (TemplateException e) {
			throw new ServletException(
			"Error while processing FreeMarker template", e);
			}
			
			/*pout = response.getWriter();
			pout.print("test the page");
			ReservationSearchCreate rescreate = new ReservationSearchCreate();
			retString=new String(rescreate.PrepareResults(request));
			pout.println(retString);*/
		}catch (Exception e) {
		}
		
	}


}

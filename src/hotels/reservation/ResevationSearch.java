package hotels.reservation;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResevationSearch
 */
public class ResevationSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Configuration cfg;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResevationSearch() {
        super();
    }
    public void init() {
    	// Initialize the FreeMarker configuration;
    	// - Create a configuration instance
    	cfg = new Configuration();
    	// - Templates are stoted in the WEB-INF/templates directory of the Web app.
    	cfg.setServletContextForTemplateLoading(
    	getServletContext(), "WEB-INF/templates");
    	// In a real-world application various other settings should be explicitly
    	// set here, but for the sake of brevity we leave it out now. See the
    	// "webapp2" example for them.
    	
    	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			// Build the data-model
			Map<String, Object> root = new HashMap<String, Object>();
			root.put("message", "Hello World!");
			ReservationSearchCreate rescreate = new ReservationSearchCreate();
			
			root.put("criteria",rescreate.setParameterObjects(request));
			// Get the templat object
			Template t = cfg.getTemplate("results.ftl");
			 
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

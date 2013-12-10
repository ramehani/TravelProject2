package hotels.reservation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResevationSearchResults
 */
public class ResevationSearchResults extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResevationSearchResults() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("application/json");
    	PrintWriter pout = response.getWriter();
    	String retString = "";
    	
		try {
			
			ReservationSearchCreate rescreate = new ReservationSearchCreate();
			retString=new String(rescreate.PrepareResults(request));
			pout.println(retString);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}

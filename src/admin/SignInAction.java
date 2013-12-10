package admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import etspl.common.jdbc.PoolManager;

/*import rezg.jdbc.base.util.DBManagerIF;
import rezg.jdbc.base.util.DBUtilManagerFactory;
import rezg.jdbc.base.util.DBUtilManagerFactoryIF;
import rezg.server.impl.BookingDetail;
import rezg.server.impl.SignInDetail;
import rezg.web.Properties.RezGatewaySystemProperties;
import rezg.web.base.datalayer.DBLogin;
import rezg.web.base.reservation.ResSearchCriteriaForm;
import rezg.web.base.reservation.ViewBookingForm;
import rezg.web.util.QueryConfig;
import rezg.web.util.QueryConfigIF;*/

public class SignInAction extends DispatchAction{
	
	
//	public BookingDetail bookingdetail = null;
//	public SignInDetail signindet = null;
	String BookingNo = null;
	Connection conn = null;
	PoolManager pool=null; 
//	String BackOfficePool = RezGatewaySystemProperties.BACKOFFICE_POOL;
	 
	 public ActionForward SignIn(ActionMapping mapping, ActionForm form,
	            HttpServletRequest request, HttpServletResponse response)
	            throws Exception {
	 		 		 
		    HttpSession session = request.getSession();
		    if(session==null){
		    	RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/SignIn.jsp");
			  	  if (dispatcher != null){
			  	   dispatcher.forward(request, response);
			  	  }		    
		    }
		 
	        String target = null;
	        SignInForm signInForm = (SignInForm)form;
	        pool = etspl.common.jdbc.PoolManager.getInstance(); 
//	        conn = pool.getConnection(BackOfficePool);
	        try{
	        	/*
	        	//getCustomerInfonew(signInForm.getBookingNo());
	        	
	           DBLogin dblogin = new DBLogin();
	           bookingdetail = dblogin.getBookingDetails(request,conn,signInForm.getBookingNo());	     	           	           
	           signindet =  dblogin.getCustomerInfo(conn, signInForm.getBookingNo());	           	           
	           signInForm.setFirstName(signindet.getFirstName());
	           signInForm.setLastName(signindet.getLastName());	          
	            	            
	            BookingNo = signInForm.getBookingNo();
	            
	            session.setAttribute("BookingInfo", bookingdetail);*/
	            
	            target = "success";
	           
	        }
	        catch(Exception ex)
	        {
	        	 target = "error";
	        }
	        finally{				
				if(conn!=null){try{conn.close();conn=null;}catch(Exception e){conn =null;}}	
			}
	          
	            
	          //  session.setAttribute("BookingNo",BookingNo);
	            //request.setAttribute("message", searchCritForm.getPassword());
	        /*}
	        else {
	            target = "failure";
	        }*/
	 
	        return mapping.findForward(target);
	    }
	 
	 public ActionForward SignOut(ActionMapping mapping, ActionForm form,
	            HttpServletRequest request, HttpServletResponse response)
	            throws Exception {
		 String target = null;
		 try{
		 //HttpSession session = request.getSession();
		 HttpSession session = request.getSession();
	        if(session==null){
		    	
		    	RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/SignIn.jsp");

		  	  if (dispatcher != null){

		  	  dispatcher.forward(request, response);

		  	  }		    
		    }	
		 
		 
		 if(session != null)
		 {
		 session.invalidate();
		 }
		 target = "signout";
		 }
		 catch(Exception ex)
		 {
			 target = "error";
		 }
		 return mapping.findForward(target);
	 }
	 
	 public void getCustomerInfonew(String resNo) throws Exception
		{/*
		 List<Object[]> results = null;

		 DBUtilManagerFactoryIF factory = new DBUtilManagerFactory();
		 DBManagerIF dBManager =  factory.CreateDBUtilManager();	
			  
			try{
				QueryConfigIF queryConfig = new QueryConfig("Reservation","TEST_UPDATE");
				String query = queryConfig.getSqlQuery();
				//int val = dBManager.insert(query);
				Object[] restrictions = new Object[2];
				restrictions[0] = "Star 8";
				restrictions[1] = "ST6";
				int val = dBManager.update(query,restrictions);
				
				System.out.println("query>>"+query);
				System.out.println("val>>"+val);
				}catch(Exception e){
			      e.printStackTrace();
				}
				
			
			
		*/}


	 
}

package admin;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

//import rezg.web.base.datalayer.DBAccessMail;
//import rezg.web.base.datalayer.DBLogin;

public class SignInForm extends ActionForm {
	

	private String bookingNo;
    private String email;
    
    boolean notValid = false;
    int msg;
	
    
    private String firstName;
	private String lastName;
    
    public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	
	public ActionErrors validate(ActionMapping mapping,
            HttpServletRequest request) {
		ActionErrors actionErrors = new ActionErrors();
		/*
 
        
        DBLogin dblogin = new DBLogin();
        
        try {
        	msg = dblogin.validateData(bookingNo, email);
        	
        	
        if(bookingNo == null || bookingNo.trim().equals("")) {
            actionErrors.add("bookingNo", new ActionMessage("error.bookingno"));            
            notValid = true;
        }
        
        if(email == null || email.trim().equals("")) {
            actionErrors.add("email", new ActionMessage("error.email"));
            notValid =true;
        }
        
        if(!notValid)
        {    
        	 System.out.println("gggg>>"+msg);
        	 if(msg ==1)
        	 actionErrors.add("bookingNo", new ActionMessage("error.login.refNotValid"));
        	 if(msg ==2)
        	 actionErrors.add("email", new ActionMessage("error.login.emailNotValid"));
        	 if(msg ==3)
        	 actionErrors.add("bookingNo", new ActionMessage("error.login.refNotValidformail"));
        	 if(msg ==4)
             actionErrors.add("bookingNo", new ActionMessage("error.login.cancelledBooking"));
            	 
        	 
        }
        
        
        }catch(Exception e) {
            e.printStackTrace();
        }
       
    */ return actionErrors ;
		}


	public String getBookingNo() {
		return bookingNo;
	}


	public void setBookingNo(String bookingNo) {
		this.bookingNo = bookingNo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.bookingNo = null ;
		this.email = null ;
	}
}

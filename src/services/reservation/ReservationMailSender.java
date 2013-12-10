package services.reservation;

import hotels.mailformat.CgenerateCustomerMail;
import hotels.mailformat.cgeneratePortalMail;
import hotels.mailformat.CgenerateHotelMail;
import hotels.pojo.reservation.ConfirmInfoHolder;

import java.util.ResourceBundle;

import services.SendMail;
import utils.InterlizationManager;
import utils.LoadSystemProperties;

public class ReservationMailSender {

	LoadSystemProperties syspro =null;
	InterlizationManager reourcebundle = null;
	ResourceBundle resbundle =null;
	ConfirmInfoHolder info=null;
	String[] arrWholeSellerDetails = new String[10];
	SendMail snd =null;
	public ReservationMailSender(ConfirmInfoHolder info)
	{
		try {
			resbundle = reourcebundle.getBundle(info.getCountry(), info.getLanguage());
			syspro = LoadSystemProperties.getInstance();
			this.info = info;
			snd = SendMail.getInstance("smtp.gmail.com");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void errorMailSend(String type,String errordesc)
	{
		if(type=="PORTAL")
		{
			try {
				cgeneratePortalMail cs = new cgeneratePortalMail();
				String errs = new String( cs.generatePortalMailErrorDesc(info, errordesc, resbundle));
				snd.setFrom("ramehani@gmail.com");
				snd.setTo("ramehani@yahoo.com");
				snd.setSubject("Unsaved Booking Alert Mail Print errror");
				snd.setMsg(errs);
				snd.sendRez("ramehani@gmail.com", "aluthaha");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void sendCustomerMail() {
		CgenerateCustomerMail cs = new CgenerateCustomerMail();
		try {
			String emailmsg = new String( cs.generateCustomerNetCopy(resbundle, info, "EMAIL", arrWholeSellerDetails, "RES"));
			snd.setFrom("ramehani@gmail.com");
			snd.setTo(info.getCemail());
			snd.setSubject(resbundle.getString("MailSub")+" "+info.getHotelName());
			snd.setMsg(emailmsg);
			snd.sendRez("ramehani@gmail.com", "aluthaha");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void sendHotelPartnerMail() {
		CgenerateHotelMail hotmail = new CgenerateHotelMail();
		try {
			String emailmsg = new String(hotmail.generateHotelMailReservationFinal(resbundle, info, "TRS", arrWholeSellerDetails, "ss"));
			snd.setFrom("ramehani@gmail.com");
			snd.setTo(info.getHotelemail());
			snd.setSubject(""+info.getHotelName()+" | "+info.getCtitile()+" "+info.getFname()+" "+info.getLastname()+" | "+info.getShowCheckdate()+" | "+info.getBooking_no()+" | accom_copy");
			snd.setMsg(emailmsg);
			snd.sendRez("ramehani@gmail.com", "aluthaha");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void sendPortalMail() {
		// TODO Auto-generated method stub
		
	}

	public void sendMailConfirmation() {
		sendPortalMail();
		sendHotelPartnerMail();
		sendCustomerMail();
	}
	
	
}

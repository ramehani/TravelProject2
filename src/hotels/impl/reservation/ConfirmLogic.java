package hotels.impl.reservation;

import hotels.pojo.reservation.ConfirmInfoHolder;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import services.reservation.ReservationMailSender;
import utils.LoadSystemProperties;
import etspl.common.jdbc.PoolManager;

public class ConfirmLogic {


	public HashMap<String, Object> getConfirmation(ConfirmInfoHolder info,
			String schemaname, LoadSystemProperties sysprop) {
		ReservationMailSender mailsend = new ReservationMailSender(info);
		HashMap<String, Object> retmap= new HashMap<String, Object>();
		retmap.put("error", "noerror");
		
		PoolManager pool = PoolManager.getInstance();
		Connection con= null;
		Statement stmt = null;
		ResultSet rs = null;
		System.out.println("test to u2");
		try {
			try{
				con = pool.getConnection("basicpool");
				con.setAutoCommit(false);
			}catch(Exception e){
				
			}
			System.out.println("test to u3");
			String bookingno="";
			try {
				bookingno = setBookingData(info,schemaname,con);
				info.setBooking_no(bookingno);
				mailsend = new ReservationMailSender(info);
				mailsend.sendMailConfirmation();
			} catch (Exception e) {
				con.rollback();
				mailsend.errorMailSend("PORTAL", "ERROR IS - "+e.toString());
				retmap.put("error", "booking_e");
				retmap.put("errormsg", "Your page has been expired");
			} 
			System.out.println("bookingno >>"+bookingno);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{con.setAutoCommit(true);}catch(Exception e){}
			try{con.close();con = null;}catch(Exception e){con = null;}
		}
		System.out.println("info.getRoomname() >>>."+info.getRoomname());
		retmap.put("confirminfo", info);
		return retmap;
	}

	private String setBookingData(ConfirmInfoHolder info,String SchemaName,Connection _con) throws Exception
	{
		String Booking_NO = null;
		CallableStatement callableStmt=null;
		try{
			callableStmt =  _con.prepareCall("{call "+SchemaName+".PR_TRN_RES_MAIN(?,?,?,?,?,?,?,?,?,?,?,?,?,?"
					+ ",?,?,?,?,?,?,?,?,?,?"
//					,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?"
					+ ")};"+
					"");
			callableStmt.setString(1, info.getHotelCode());
			callableStmt.setString(2, info.getRoomcode());
			callableStmt.setString(3, info.getBedcode());
			callableStmt.setString(4, info.getRateplancode());
			callableStmt.setString(5, info.getFromdate());
			callableStmt.setString(6, info.getTodate());
			callableStmt.setString(7, "0");//rate
			callableStmt.setString(8, info.getNoofrooms());
			callableStmt.setString(9, info.getTotalpayment());
			callableStmt.setString(10, info.getBalance());
			callableStmt.setString(11, info.getPaynow());
			callableStmt.setString(12, "session");
			callableStmt.registerOutParameter(13,java.sql.Types.CHAR);
			callableStmt.setInt(14, info.getRecordno());
			callableStmt.setString(15, info.getFname());
			callableStmt.setString(16, info.getLastname());
			callableStmt.setString(17, info.getCemail());
			callableStmt.setString(18, info.getCphoneno());
			callableStmt.setString(19, info.getCaddress());
			callableStmt.setString(20, info.getCcity());
			callableStmt.setString(21, info.getCcountry());
			callableStmt.setString(22, info.getCcname());
			callableStmt.setString(23, info.getCcno());
			callableStmt.setString(24, info.getCcexpdt());
			callableStmt.execute();
			Booking_NO=callableStmt.getString(13);
		}catch(Exception e){
			throw e;
		}finally{
		   try{callableStmt.close();callableStmt=null;}catch(Exception e){callableStmt=null;}	
		}
		return Booking_NO;
		
	}
	
	
}

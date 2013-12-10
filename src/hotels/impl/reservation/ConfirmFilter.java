package hotels.impl.reservation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import services.reservation.ReservationMailSender;
import etspl.common.jdbc.PoolManager;
import hotels.pojo.reservation.ConfirmInfoHolder;

public class ConfirmFilter {

	public boolean checkInventory(ConfirmInfoHolder info) {
		
		PoolManager pool = PoolManager.getInstance();
		Connection con= null;
		Statement stmt = null;
		ResultSet rs = null;
		boolean noinventory = true;
		try{
			con = pool.getConnection("basicpool");
			stmt = con.createStatement();
			ReservationMailSender mailsend = new ReservationMailSender(info);
			String stequery = " SELECT count(*) from travelbooking.trn_daily_inv where hotel_code='"+info.getHotelCode()+"' AND room_type_code ='"+info.getRoomcode()+"' "
					+ "		    AND bed_type_code='"+info.getBedcode()+"' and daily_date>= '"+info.getFromdate()+"' and daily_date< '"+info.getTodate()+"'"
							+ " AND VACNT_INV >="+info.getNoofrooms()+""
							+ " group by daily_date having count(*)="+info.getNoOfnights()+"";
			System.out.println("stequery <<<"+stequery);
			rs = stmt.executeQuery(stequery);
			if(rs.next())
			{
				if(rs.getInt(1) == 1)
				{
					noinventory = false;
				}else{
					mailsend.errorMailSend("PORTAL", "Inventory Exausted");
				}
			}else{
				mailsend.errorMailSend("PORTAL", "Inventory Exausted");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{rs.close();}catch (Exception e) {rs=null;}
			try{stmt.close();}catch (Exception e) {stmt=null;}
			try{con.close();}catch (Exception e) {con=null;}
		}
		return noinventory;
	}

}

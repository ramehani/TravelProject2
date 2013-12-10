package hotels.impl.reservation;

import hotels.pojo.reservation.CriteriaObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import etspl.common.jdbc.PoolManager;

public class SearchLogic {

	public ArrayList<ReservationResult> getResults(CriteriaObject obj)
	{
		PoolManager poolmanager = PoolManager.getInstance();
		ArrayList<ReservationResult> arlist= new ArrayList<ReservationResult>();
		Connection con = null;
		Statement stmt= null; 
		ResultSet rs= null;
		
		try {
			con = poolmanager.getConnection("basicpool");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try{
			stmt = con.createStatement();
			
			String resquery = ""+
				" select D.Hotel_code,B.hotel_name,B.Address,D.ROOM_TYPE_CODE,D.BED_TYPE_CODE,D.RATE_PLAN_CODE,(D.RATE * rooms) as rate, D.rooms ,"+
				" travelbooking.fn_get_room_type(D.ROOM_TYPE_CODE) room_type, "+
				" travelbooking.fn_get_bed_type(D.BED_TYPE_CODE) bed_type, "+
				" travelbooking.fn_get_rate_plan_type(D.RATE_PLAN_CODE) rate_plan "+
				" from (  "+
						" select * from ( "+ 
				
						" SELECT mix.hotel_code,room_type_code,bed_type_code,rate_plan_code,VACNT_INV,rate,CEILING("+obj.getNoofadults()+"/STANDARD_ADULTS) rooms "+
				" FROM "+
				 " ( "+
						" select rates.hotel_code,rates.room_type_code,rates.bed_type_code,rates.rate_plan_code, "+
				" min(inv.VACNT_INV) VACNT_INV,sum(rates.rate) rate, "+
				" travelbooking.fn_get_standard_adults(rates.hotel_code,rates.room_type_code,rates.bed_type_code) STANDARD_ADULTS "+
				" from  "+
				 " (  "+
						  " SELECT HOTEL_CODE,ROOM_TYPE_CODE,BED_TYPE_CODE,DAILY_DATE,VACNT_INV "+ 
				" FROM travelbooking.trn_daily_inv  WHERE DAILY_DATE >= '"+obj.getFrom_date()+"' AND DAILY_DATE < '"+obj.getTo_date()+"' AND VACNT_INV > 0 "+  
				" )INV, (  "+
						" SELECT HOTEL_CODE,ROOM_TYPE_CODE,BED_TYPE_CODE,RATE_PLAN_CODE,DAILY_DATE,RATE "+
				" FROM travelbooking.trn_daily_RATES  WHERE DAILY_DATE >= '"+obj.getFrom_date()+"' "+
					" AND DAILY_DATE < '"+obj.getTo_date()+"' AND RATE > 0  )RATES WHERE INV.HOTEL_CODE = RATES.HOTEL_CODE "+  
				" AND INV.ROOM_TYPE_CODE = RATES.ROOM_TYPE_CODE  AND INV.BED_TYPE_CODE = RATES.BED_TYPE_CODE   "+
				" AND INV.DAILY_DATE = RATES.DAILY_DATE "+
				" group by rates.hotel_code,rates.room_type_code,rates.bed_type_code,rates.rate_plan_code having count(*) = "+obj.getNoofnights()+" "+
				" ) mix "+
				" ) A "+
				" where VACNT_INV >=rooms "+ 
				" order by hotel_code,room_type_code,bed_type_code,rate_plan_code "+
				" ) D, (SELECT HOTEL_CODE,HOTEL_NAME,ADDRESS "+
						"     FROM travelbooking.LKUP_HOTELS) B "+
				 " where D.hotel_code = b.hotel_code"+  
				"" +
				"";
			System.out.println(resquery);
			rs = stmt.executeQuery(resquery);
			while(rs.next())
			{
				ReservationResult resobj = new ReservationResult();
				resobj.setHotelCode(rs.getString(1));
				resobj.setHotelName(rs.getString(2));
				resobj.setAddress(rs.getString(3));
				resobj.setRoomtypecode(rs.getString(4));
				resobj.setBedtypecode(rs.getString(5));
				resobj.setRateplancode(rs.getString(6));
				resobj.setRate(Float.parseFloat(rs.getString(7)));
				resobj.setRooms(Integer.parseInt(rs.getString(8)));
				resobj.setRoomtypename(rs.getString(9));
				resobj.setBedtypename(rs.getString(10));
				resobj.setRateplaname(rs.getString(11));
				arlist.add(resobj);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{rs.close();}catch (Exception e) {rs=null;}
			try{stmt.close();}catch (Exception e) {stmt=null;}
			try{con.close();}catch (Exception e) {con=null;}
		}
		
		
		return arlist;
	}
	
}

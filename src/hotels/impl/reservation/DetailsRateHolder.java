package hotels.impl.reservation;

import hotels.pojo.reservation.DetailsInformationSetter;
import hotels.pojo.reservation.RatesBean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import etspl.common.jdbc.PoolManager;

public class DetailsRateHolder {
	
	public RatesBean rateholder(DetailsInformationSetter dtinfo)
	{
		PoolManager poolmanager = PoolManager.getInstance();
		Connection con = null;
		Statement stmt= null; 
		ResultSet rs= null;
		RatesBean ratesholder = new RatesBean();
		String[] fromdate = dtinfo.getFromdate().split("-");
		String[] todate = dtinfo.getTodate().split("-");
		try {
			con = poolmanager.getConnection("basicpool");
		} catch (Exception e) {
			e.printStackTrace();
		}
		String depotype = "P";
		float depovalue = 100f;
		try {	
			stmt = con.createStatement();
			String sqltext = "SELECT DEPOSIT_TYPE,DEPOSIT FROM travelbooking.lkup_hotel_deposit "
					+ "		  WHERE HOTEL_CODE = '"+dtinfo.getHotelCode()+"' and '"+fromdate[2]+"-"+fromdate[1]+"-"+fromdate[0]+"' between from_date and to_date ";
			
			rs = stmt.executeQuery(sqltext);
			
			if(rs.next())
			{
				depotype = rs.getString(1);
				depovalue = Float.parseFloat(rs.getString(2));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{rs.close();}catch (Exception e) {rs=null;}
			try{stmt.close();}catch (Exception e) {stmt=null;}
		}
		
		float rateval=0.0f;
	
		try {	
			stmt = con.createStatement();
			String sqltext = "SELECT sum(rate) FROM travelbooking.trn_daily_rates "
					+ "		  WHERE HOTEL_CODE = '"+dtinfo.getHotelCode()+"' and daily_date >= '"+fromdate[2]+"-"+fromdate[1]+"-"+fromdate[0]+"' "
					+ "       and  daily_date<'"+todate[2]+"-"+todate[1]+"-"+todate[0]+"' "
							+ "and rate>0 "
					+ "       group by daily_date having count(*) >="+dtinfo.getNoOfnights()+"";
			rs = stmt.executeQuery(sqltext);
			
			if(rs.next())
			{
				rateval = rs.getFloat(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{rs.close();}catch (Exception e) {rs=null;}
			try{stmt.close();}catch (Exception e) {stmt=null;}
			try{con.close();}catch (Exception e) {con=null;}
		}
		
		rateval = rateval* Integer.parseInt(dtinfo.getNoofrooms());
		float depositprice = 0.0f;
		
		if(depotype.equals("V"))
			depositprice = depovalue;
		else
			depositprice = (rateval*depovalue)/100;
				
		float balamount = rateval - depositprice;
		ratesholder.setDepositvalue(depositprice);
		ratesholder.setBalanceamount(balamount);
		ratesholder.setTotoalprice(rateval);
		
		
		return ratesholder;
				
	}

}

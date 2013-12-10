package hotels.reservation;

import hotels.impl.reservation.ReservationResult;
import hotels.impl.reservation.SearchLogic;
import hotels.pojo.reservation.CriteriaObject;

import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;

public class ReservationSearchCreate {

	
	public char[] PrepareResults(HttpServletRequest req)
	{
		char[] retarr=null;
		StringBuffer strBuff=null;
		
		try{
			strBuff = new StringBuffer();
			SearchLogic sclogic = new SearchLogic();
			CriteriaObject cobject = setParameterObjects(req);
			
			String Resultsender = "{ ";
			
			ArrayList<ReservationResult> arlist = sclogic.getResults(cobject);
			boolean haveresult = false;

			if(arlist.size()>0)
				haveresult= true;
			if(haveresult)
			{	
				Resultsender += "\"hotel\":[ ";
				int counter = 0;
				while(haveresult)
				{
					float minratez = 999999f;
					String HotelCode = arlist.get(counter).getHotelCode();
					String tempohotelCode = arlist.get(counter).getHotelCode();
					Resultsender += "{\"hotelcode\":\""+HotelCode+"\""
							+ ",\"name\":\""+arlist.get(counter).getHotelName()+"\""
							+ ",\"address\":\""+arlist.get(counter).getAddress()+"\""
									+ "";
					Resultsender += ",\"roomtypes\" : [";
					while(haveresult)
					{
						ReservationResult resreulst = arlist.get(counter);
						String roomtypecode = resreulst.getRoomtypecode();
						String bedtypecode = resreulst.getBedtypecode();
						String rateplancode = resreulst.getRateplancode();
						
						while(haveresult)
						{
							counter++;
							if(arlist.size() <= counter){
								haveresult =false;
								break;
							}
							
							if(!HotelCode.equals(arlist.get(counter).getHotelCode()) || !roomtypecode.equals(arlist.get(counter).getRoomtypecode()) || 
									!bedtypecode.equals(arlist.get(counter).getBedtypecode()) || !rateplancode.equals(arlist.get(counter).getRateplancode()))
							{
								tempohotelCode = arlist.get(counter).getHotelCode();
								break;
								
							}
							
						}
						if(minratez > resreulst.getRate())
						{
							minratez = resreulst.getRate();
						}
						Resultsender += "{";
						Resultsender += "\"roomcode\" :\""+roomtypecode+"\"";
						Resultsender += ",\"roomtypename\" :\""+resreulst.getRoomtypename()+"\"";
						Resultsender += ",\"bedtypecode\" :\""+resreulst.getBedtypecode()+"\"";
						Resultsender += ",\"bedtypename\" :\""+resreulst.getBedtypename()+"\"";
						Resultsender += ",\"rateplancode\" :\""+resreulst.getRateplancode()+"\"";
						Resultsender += ",\"rateplanname\" :\""+resreulst.getRateplaname()+"\"";
						Resultsender += ",\"distotrate\" :\""+resreulst.getRate()+"\"";
						Resultsender += ",\"promotion\" :\" \"";
						Resultsender += ",\"rooms\" :\" "+resreulst.getRooms()+"\"";
						Resultsender += "},";
				
						if(!haveresult)
							break;
						if(!HotelCode.equals(tempohotelCode))
						{
							break;
						}
						
					}
					Resultsender = Resultsender.substring(0,Resultsender.length()-1);
					Resultsender += "]";
					Resultsender += ",\"hotelminrates\":"+minratez+"";
					Resultsender += "},";
				}
				
				/*for (Iterator<ReservationResult> iterator = arlist.iterator(); iterator.hasNext();) {
					ReservationResult object = iterator.next();
					Resultsender += "";
	//				strBuff.append(object.toString());
					
					
				}*/
				Resultsender = Resultsender.substring(0,Resultsender.length()-1);
				Resultsender += "] ";
			}
			Resultsender += "} ";
			strBuff.append(Resultsender);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		int i=strBuff.length();
		retarr=new char[i];
		strBuff.getChars(0,i,retarr,0);
		strBuff=null;
		return retarr;
	}
	
	public CriteriaObject setParameterObjects(HttpServletRequest req)
	{
		CriteriaObject cobject = new CriteriaObject();
		
		String from_date = req.getParameter("fromdate");
		String to_date = req.getParameter("todate");
		
		cobject.setFrom_date(from_date);
		cobject.setTo_date(to_date);
		cobject.setNoofadults(req.getParameter("NoAd"));
		
		Calendar fromdate = Calendar.getInstance();
		fromdate.set(Integer.parseInt(from_date.split("-")[0]), Integer.parseInt(from_date.split("-")[1]), Integer.parseInt(from_date.split("-")[2]));
		
		Calendar todate = Calendar.getInstance();
		todate.set(Integer.parseInt(to_date.split("-")[0]), Integer.parseInt(to_date.split("-")[1]), Integer.parseInt(to_date.split("-")[2]));
		
		long milliseconds1 = fromdate.getTimeInMillis();
	    long milliseconds2 = todate.getTimeInMillis();
	    long diff = milliseconds2 - milliseconds1;
		
	    long diffDays = diff / (24 * 60 * 60 * 1000);
	    cobject.setNoofnights(""+diffDays);
		return cobject;
	}
}

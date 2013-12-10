package hotels.pojo.reservation;

public class CriteriaObject {

	String from_date, to_date,noofadults,noofnights=null;

	public String getNoofnights() {
		return noofnights;
	}

	public void setNoofnights(String noofnights) {
		this.noofnights = noofnights;
	}

	public String getNoofadults() {
		return noofadults;
	}

	public void setNoofadults(String noofadults) {
		this.noofadults = noofadults;
	}

	public String getFrom_date() {
		return from_date;
	}

	public void setFrom_date(String from_date) {
		this.from_date = from_date;
	}

	public String getTo_date() {
		return to_date;
	}

	public void setTo_date(String to_date) {
		this.to_date = to_date;
	}
	
	
	
}

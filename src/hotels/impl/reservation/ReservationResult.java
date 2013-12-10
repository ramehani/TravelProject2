package hotels.impl.reservation;

public class ReservationResult {

	String hotelCode=null;
	String hotelName,address,roomtypename,roomtypecode,bedtypename,bedtypecode,rateplaname,rateplancode,noofrooms;
	public String getNoofrooms() {
		return noofrooms;
	}
	public void setNoofrooms(String noofrooms) {
		this.noofrooms = noofrooms;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHotelCode() {
		return hotelCode;
	}
	public void setHotelCode(String hotelCode) {
		this.hotelCode = hotelCode;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getRoomtypename() {
		return roomtypename;
	}
	public void setRoomtypename(String roomtypename) {
		this.roomtypename = roomtypename;
	}
	public String getRoomtypecode() {
		return roomtypecode;
	}
	public void setRoomtypecode(String roomtypecode) {
		this.roomtypecode = roomtypecode;
	}
	public String getBedtypename() {
		return bedtypename;
	}
	public void setBedtypename(String bedtypename) {
		this.bedtypename = bedtypename;
	}
	public String getBedtypecode() {
		return bedtypecode;
	}
	public void setBedtypecode(String bedtypecode) {
		this.bedtypecode = bedtypecode;
	}
	public String getRateplaname() {
		return rateplaname;
	}
	public void setRateplaname(String rateplaname) {
		this.rateplaname = rateplaname;
	}
	public String getRateplancode() {
		return rateplancode;
	}
	public void setRateplancode(String rateplancode) {
		this.rateplancode = rateplancode;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public int getRooms() {
		return rooms;
	}
	public void setRooms(int rooms) {
		this.rooms = rooms;
	}
	float rate;
	int rooms;
	
	
	
	
}

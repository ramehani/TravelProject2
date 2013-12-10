package hotels.pojo.reservation;

import java.util.Calendar;

public class ConfirmInfoHolder {
	
	String showCheckdate,showCheckoutdate,fromdate,todate,noOfAdults,noOfnights,noofrooms,affcode;
	
	Calendar cin,cout;
	
	public Calendar getCin() {
		return cin;
	}
	public void setCin(Calendar cin) {
		this.cin = cin;
	}
	public Calendar getCout() {
		return cout;
	}
	public void setCout(Calendar cout) {
		this.cout = cout;
	}
	public String getAffcode() {
		return affcode;
	}
	public void setAffcode(String affcode) {
		this.affcode = affcode;
	}
	public String getNoofrooms() {
		return noofrooms;
	}
	public void setNoofrooms(String noofrooms) {
		this.noofrooms = noofrooms;
	}
	public String getNoOfnights() {
		return noOfnights;
	}
	public void setNoOfnights(String noOfnights) {
		this.noOfnights = noOfnights;
	}
	String hotelName,hotelAddress,hotelcity,hotelemail,hotelCode,hotelmaincontactname,hoteltype,
	       roomcode,roomname,bedcode,bedName,rateplancode,rateplanname,roomrate,wholesalerid;
	public String getWholesalerid() {
		return wholesalerid;
	}
	public void setWholesalerid(String wholesalerid) {
		this.wholesalerid = wholesalerid;
	}
	String hotelphone="123";
	
	public String getRoomrate() {
		return roomrate;
	}
	public void setRoomrate(String roomrate) {
		this.roomrate = roomrate;
	}
	public String getHoteltype() {
		return hoteltype;
	}
	public void setHoteltype(String hoteltype) {
		this.hoteltype = hoteltype;
	}
	public String getHotelmaincontactname() {
		return hotelmaincontactname;
	}
	public void setHotelmaincontactname(String hotelmaincontactname) {
		this.hotelmaincontactname = hotelmaincontactname;
	}
	public String getHotelAddress() {
		return hotelAddress;
	}
	public String getHotelcity() {
		return hotelcity;
	}
	public void setHotelcity(String hotelcity) {
		this.hotelcity = hotelcity;
	}
	public String getHotelemail() {
		return hotelemail;
	}
	public void setHotelemail(String hotelemail) {
		this.hotelemail = hotelemail;
	}
	public String getHotelphone() {
		return hotelphone;
	}
	public void setHotelphone(String hotelphone) {
		this.hotelphone = hotelphone;
	}
	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}
	public String getShowCheckdate() {
		return showCheckdate;
	}
	public void setShowCheckdate(String showCheckdate) {
		this.showCheckdate = showCheckdate;
	}
	public String getShowCheckoutdate() {
		return showCheckoutdate;
	}
	public void setShowCheckoutdate(String showCheckoutdate) {
		this.showCheckoutdate = showCheckoutdate;
	}
	public String getFromdate() {
		return fromdate;
	}
	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}
	public String getTodate() {
		return todate;
	}
	public void setTodate(String todate) {
		this.todate = todate;
	}
	public String getNoOfAdults() {
		return noOfAdults;
	}
	public void setNoOfAdults(String noOfAdults) {
		this.noOfAdults = noOfAdults;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getHotelCode() {
		return hotelCode;
	}
	public void setHotelCode(String hotelCode) {
		this.hotelCode = hotelCode;
	}
	public String getRoomcode() {
		return roomcode;
	}
	public void setRoomcode(String roomcode) {
		this.roomcode = roomcode;
	}
	public String getRoomname() {
		return roomname;
	}
	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}
	public String getBedcode() {
		return bedcode;
	}
	public void setBedcode(String bedcode) {
		this.bedcode = bedcode;
	}
	public String getBedName() {
		return bedName;
	}
	public void setBedName(String bedName) {
		this.bedName = bedName;
	}
	public String getRateplancode() {
		return rateplancode;
	}
	public void setRateplancode(String rateplancode) {
		this.rateplancode = rateplancode;
	}
	public String getRateplanname() {
		return rateplanname;
	}
	public void setRateplanname(String rateplanname) {
		this.rateplanname = rateplanname;
	}
	String booktype,totalpayment,paynow,balance,discounttype,depositcharge,balancedays,adltRtByBtyp;
	
	public String getAdltRtByBtyp() {
		return adltRtByBtyp;
	}
	public void setAdltRtByBtyp(String adltRtByBtyp) {
		this.adltRtByBtyp = adltRtByBtyp;
	}
	public String getBalancedays() {
		return balancedays;
	}
	public void setBalancedays(String balancedays) {
		this.balancedays = balancedays;
	}
	public String getDepositcharge() {
		return depositcharge;
	}
	public void setDepositcharge(String depositcharge) {
		this.depositcharge = depositcharge;
	}
	public String getBooktype() {
		return booktype;
	}
	public void setBooktype(String booktype) {
		this.booktype = booktype;
	}
	public String getTotalpayment() {
		return totalpayment;
	}
	public void setTotalpayment(String totalpayment) {
		this.totalpayment = totalpayment;
	}
	public String getPaynow() {
		return paynow;
	}
	public void setPaynow(String paynow) {
		this.paynow = paynow;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getDiscounttype() {
		return discounttype;
	}
	public void setDiscounttype(String discounttype) {
		this.discounttype = discounttype;
	}
	String ctitile,fname,lastname,cemail,ccno,ccexpdt,cphoneno,ccname,cctype,caddress,ccity,ccountry,czip;
	
	public String getCtitile() {
		return ctitile;
	}
	public void setCtitile(String ctitile) {
		this.ctitile = ctitile;
	}
	public String getCcountry() {
		return ccountry;
	}
	public void setCcountry(String ccountry) {
		this.ccountry = ccountry;
	}
	public String getCaddress() {
		return caddress;
	}
	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}
	public String getCcity() {
		return ccity;
	}
	public void setCcity(String ccity) {
		this.ccity = ccity;
	}
	public String getCzip() {
		return czip;
	}
	public void setCzip(String czip) {
		this.czip = czip;
	}
	public String getCctype() {
		return cctype;
	}
	public void setCctype(String cctype) {
		this.cctype = cctype;
	}
	public String getCcname() {
		return ccname;
	}
	public void setCcname(String ccname) {
		this.ccname = ccname;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	public String getCphoneno() {
		return cphoneno;
	}
	public void setCphoneno(String cphoneno) {
		this.cphoneno = cphoneno;
	}
	public String getCcno() {
		return ccno;
	}
	public void setCcno(String ccno) {
		this.ccno = ccno;
	}
	public String getCcexpdt() {
		return ccexpdt;
	}
	public void setCcexpdt(String ccexpdt) {
		this.ccexpdt = ccexpdt;
	}
	
	String specialrequest,timeofarrival,purposeofstay,howuhear;
	public String getSpecialrequest() {
		return specialrequest;
	}
	public void setSpecialrequest(String specialrequest) {
		this.specialrequest = specialrequest;
	}
	public String getTimeofarrival() {
		return timeofarrival;
	}
	public void setTimeofarrival(String timeofarrival) {
		this.timeofarrival = timeofarrival;
	}
	public String getPurposeofstay() {
		return purposeofstay;
	}
	public void setPurposeofstay(String purposeofstay) {
		this.purposeofstay = purposeofstay;
	}
	public String getHowuhear() {
		return howuhear;
	}
	public void setHowuhear(String howuhear) {
		this.howuhear = howuhear;
	}
	
	int recordno;
	public int getRecordno() {
		return recordno;
	}
	public void setRecordno(int recordno) {
		this.recordno = recordno;
	}
	
	String language,country;
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	/**
	 * Confirm Information store here
	 */
	String booking_no,Cancellation_msg,important_info,checkin,checkout;
	public String getBooking_no() {
		return booking_no;
	}
	public void setBooking_no(String booking_no) {
		this.booking_no = booking_no;
	}
	public String getCancellation_msg() {
		return Cancellation_msg;
	}
	public void setCancellation_msg(String cancellation_msg) {
		Cancellation_msg = cancellation_msg;
	}
	public String getImportant_info() {
		return important_info;
	}
	public void setImportant_info(String important_info) {
		this.important_info = important_info;
	}
	public String getCheckin() {
		return checkin;
	}
	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}
	public String getCheckout() {
		return checkout;
	}
	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}
	
}



public class CustomerData {
	private	String fname;
	private	String lname;
	private	String phone;
	private	String email;
	private	String card_num;
	private	String cvv;
	private String date;
	private String location;
	private	String time;
	private	String tot_seats;
	private String show_name;
	private	String tot_price;
	private	String booking_id;

		public String getFName()
		{
			return fname;
		}
		public void setFName(String fname)
		{
			this.fname=fname;
		}
		public String getLName()
		{
			return lname;
		}
		public void setLName(String lname)
		{
			this.lname=lname;
		}
		public String getPhone()
		{
			return phone;
		}
		public void setPhone(String phone)
		{
			this.phone=phone;
		}
		public String getEmail()
		{
			return email;
		}
		public void setEmail(String email)
		{
			this.email=email;
		}
		public String getShowName()
		{
			return show_name;
		}
		public void setShowName(String show_name)
		{
			this.show_name=show_name;
		}
		
		public void setCard_Num(String card_num)
		{
			this.card_num=card_num;
		}
		public String getCard_Num()
		{
			return card_num;
		}
		public void setCvv(String cvv)
		{
			this.cvv=cvv;
		}
		public String getCvv()
		{
			return cvv;
		}
		public String getShowDate()
		{
			return date;
		}
		public void setShowDate(String date)
		{
			this.date=date;
		}
		public String getLocation()
		{
			return location;
		}
		public void setLocation(String location)
		{
			this.location=location;
		}
		public String getTime()
		{
			return time;
		}
		public void setTime(String time)
		{
			this.time=time;
		}
		public String getTotSeat()
		{
			return tot_seats;
		}
		public void setTotSeat(String tot_seats)
		{
			this.tot_seats=tot_seats;
		}
		public String getTotPrice()
		{
			return tot_price;
		}
		public void setTotPrice(String tot_price)
		{
			this.tot_price=tot_price;
		}
		public String getBooking()
		{
			return booking_id;
		}
		public void setBooking(String booking_id)
		{
			this.booking_id=booking_id;
		}
}

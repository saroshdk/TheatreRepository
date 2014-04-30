import java.util.Scanner;

import javax.xml.transform.TransformerException;


public class MainPage {
		public MainPage(){
			
		}
		public static void main(String[] args) throws TransformerException
		{
			Search s=new Search();
			Scanner r=new Scanner(System.in);
			//no arguements provided
			if(args.length==0)
			{
				System.out.println("no arguements");
			}
			//java MainPage load
			else if(args[0].equals("load")){
				LoadFile l=new LoadFile();
			l.load();
			}
			//java MainPage booking
			else if(args[0].equals("booking")){
				Booking b=new Booking();
				b.BookSeats();
			}
			//java MainPage search last_name
			else if(args[0].equals("search") && args[1].equals("last_name"))
			{
				System.out.println("Enter the last name of the customer: ");
				String lname=r.next();
				s.searchLname(lname);
			}
			//java MainPage search email
			else if(args[0].equals("search") && args[1].equals("email"))
			{
				System.out.println("Enter the email of the customer: ");
				String email=r.next();
				s.searchEmail(email);
			}
			//java MainPage search booking_id
			else if(args[0].equals("search") && args[1].equals("booking_id"))
			{
				System.out.println("Enter the Booking Id: ");
				String b_id=r.next();
				s.searchBooking(b_id);	
			}
			//java MainPage search phone
			else if(args[0].equals("search") && args[1].equals("phone"))
			{
				System.out.println("Enter the phone number of the customer: ");
				String phoneNum=r.next();
				s.searchPhone(phoneNum);
			}
			//java MainPage cancel
			else if(args[0].equals("cancel")){
				CancelBooking c=new CancelBooking();
				System.out.println("Enter the Booking Id: ");
				String b_id=r.next();
				c.cancel(b_id);
			}
			//java MainPage report show
			else if(args[0].equals("report") && args[1].equals("show")){
				Report t=new Report();
				System.out.println("Enter the Show name: ");
				String sname=r.next();
				t.report_show(sname);
			}
			//java MainPage report date
			else if(args[0].equals("report") && args[1].equals("date")){
				Report t=new Report();
				System.out.println("Enter the Date: ");
				String date=r.next();
				t.report_date(date);
			}
			//java MainPage report date range //to print the number of bookings made during a time period
			else if(args[0].equals("report") && args[1].equals("range")){
				Report t=new Report();
				System.out.println("Enter the Start date: ");
				String stdate=r.next();
				System.out.println("Enter the End date: ");
				String endate=r.next();
				t.report_daterange(stdate,endate);
			}
			r.close();
		}
		
}

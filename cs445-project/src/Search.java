import java.util.ArrayList;


public class Search {
public Search(){
		
	}
ReadCustData c=new ReadCustData();
ArrayList<CustomerData> custReportList=new ArrayList<CustomerData>();

//searches the customer data using the last name provided
public void searchLname(String lname)
{
	int flag=0;
	
	custReportList=c.readFile();
	for(CustomerData dat:custReportList)
	{
		 if(lname.toUpperCase().equals(dat.getLName().toUpperCase()))
         {
      	   System.out.println("Customer Details are:\n" + "First name: " + dat.getFName() + "\n" + 
         "Last name: " + dat.getLName() + "\n" + "Email id is: " + dat.getEmail() + "\n" + "Phone: " + dat.getPhone() + "\n" + 
      "Show name: "+dat.getShowName()+ "\n"+ "Show date is: " + dat.getShowDate() + "\n" + "Time of show is: " + dat.getTime() + "\n " + 
         "Seats booked: " + dat.getTotSeat() + "\n" +  "Total Amount paid: " + dat.getTotPrice() +"\n" + "Booking ID is: "+ dat.getBooking());
             flag=1;
         }
		
	}
	if(flag==0)
    {
 	   System.out.println("No customer with this name");
    }     
}

//search for the provided phone number in the customer file		
		public void searchPhone(String phoneNum)
		{
			int flag=0;
			custReportList=c.readFile();
			for(CustomerData dat:custReportList)
			{
				 if(phoneNum.equals(dat.getPhone()))
		         {
					 System.out.println("Customer Details are:\n" + "First name: " + dat.getFName() + "\n" + 
					         "Last name: " + dat.getLName() + "\n" + "Email id is: " + dat.getEmail() + "\n" + "Phone: " + dat.getPhone() + "\n" + 
					      "Show name: "+dat.getShowName()+ "\n"+ "Show date is: " + dat.getShowDate() + "\n" + "Time of show is: " + dat.getTime() + "\n " + 
					         "Seats booked: " + dat.getTotSeat() + "\n" +  "Total Amount paid: " + dat.getTotPrice() +"\n" + "Booking ID is: "+ dat.getBooking());
					             flag=1;
		         }
				
			}
			if(flag==0)
		    {
		 	   System.out.println("No customer with this phone number");
		    }
		}
		
//search for customer record using the email provided
		public void searchEmail(String e_mail)
		{
			int flag=0;
			custReportList=c.readFile();
			for(CustomerData dat:custReportList)
			{
				 if(e_mail.equals(dat.getEmail()))
		         {
					 System.out.println("Customer Details are:\n" + "First name: " + dat.getFName() + "\n" + 
					         "Last name: " + dat.getLName() + "\n" + "Email id is: " + dat.getEmail() + "\n" + "Phone: " + dat.getPhone() + "\n" + 
					      "Show name: "+dat.getShowName()+ "\n"+ "Show date is: " + dat.getShowDate() + "\n" + "Time of show is: " + dat.getTime() + "\n " + 
					         "Seats booked: " + dat.getTotSeat() + "\n" +  "Total Amount paid: " + dat.getTotPrice() +"\n" + "Booking ID is: "+ dat.getBooking());
					             flag=1;
		         }
				
			}
			if(flag==0)
            {
         	   System.out.println("Not a valid email");
            }
		}
		
		//search for the given booking id in the customer file
			public void searchBooking(String book_id)
			{
				int flag=0;
				
				custReportList=c.readFile();
				for(CustomerData dat:custReportList)
				{
					 if(book_id.equals(dat.getBooking()))
			         {
						 System.out.println("Customer Details are:\n" + "First name: " + dat.getFName() + "\n" + 
						         "Last name: " + dat.getLName() + "\n" + "Email id is: " + dat.getEmail() + "\n" + "Phone: " + dat.getPhone() + "\n" + 
						      "Show name: "+dat.getShowName()+ "\n"+ "Show date is: " + dat.getShowDate() + "\n" + "Time of show is: " + dat.getTime() + "\n " + 
						         "Seats booked: " + dat.getTotSeat() + "\n" +  "Total Amount paid: " + dat.getTotPrice() +"\n" + "Booking ID is: "+ dat.getBooking());
						             flag=1;
			         }
					
				}
				if(flag==0)
	            {
	         	   System.out.println("Not a valid booking id");
	            }
			}
}
				
				

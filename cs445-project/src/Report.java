
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;



public class Report {
public Report(){
	
}

public String report_show(String sname)
{
	int count=0;
	int flag=0;
	double revenue=0.0;
	ReadCustData c=new ReadCustData();
	ArrayList<CustomerData> custReportList=new ArrayList<CustomerData>();
	//CustomerData dat;
	String Result="";
	custReportList=c.readFile();
	
	for(CustomerData dat:custReportList)
	{
		String amt=dat.getTotPrice();
		if(sname.toUpperCase().equals(dat.getShowName().toUpperCase()))
		{
			count++;
			revenue=revenue+Double.parseDouble(amt);
			flag=1;
		}
		
	}
	if(flag==1)
	{
	Result="Total bookings for this Show: "+sname+" is "+count+" Total revenue made is "+revenue;
System.out.println(Result);
}
	else if(flag==0){
		Result="No Information available for this show";
		System.out.println(Result);
	}
	return Result;
	
}



public String report_date(String date){
	ReadCustData c=new ReadCustData();
	ArrayList<CustomerData> custReportList=new ArrayList<CustomerData>();
	int count=0;
	double price=0.0;
	int flag=0,chk=0;
	Date checkdate=null;
	String Result="";
	//int tot_seats=0;
	custReportList=c.readFile();
	SimpleDateFormat sdfrmt=new SimpleDateFormat("dd-MMM-yyyy");
	
	try {
		checkdate = sdfrmt.parse(date);
		flag=1;
		
	} catch (ParseException e1) {
		flag=0;
	}
	
	
	if(flag==1)
	{
	for(CustomerData dat:custReportList)
	{
		//String seats=dat.getTotSeat();
		String amt=dat.getTotPrice();
		String xdate=dat.getShowDate();
		Date pdate=null;
		try {
			pdate = new SimpleDateFormat("dd-MMM-yyyy").parse(xdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(checkdate.equals(pdate))
		{
			count++;
			price=price+Double.parseDouble(amt);
			//tot_seats=tot_seats+Integer.parseInt(seats);
			chk=1;
		}
		
	}
	}
	if(flag==1 && chk==1)
	{
		Result="Total bookings for this date: "+date+" is "+count+" Total revenue made is " + price;
		System.out.println(Result);
}
	else if(flag==0){
		Result="Invalid dates";
		System.out.println(Result);
	}
	else if(chk==0)
	{
		Result="No bookings made for this date";
		System.out.println(Result);
	}
	return Result;
}

public String report_daterange(String Startdate,String Endate)
{
	ReadCustData c=new ReadCustData();
	ArrayList<CustomerData> custReportList=new ArrayList<CustomerData>();
	double price=0.0;
	custReportList=c.readFile();
	int count=0;
	int flag=0;
	String Result="";
	int check1=0,check2=0;
	SimpleDateFormat fmt=new SimpleDateFormat("dd-MMM-yyyy");
	Date date1=null;
		try
		{
		date1=fmt.parse(Startdate);
		check1=1;
		}
		catch(ParseException e1) {					
				flag=0;
				}
	
	Date date2=null;
		try{
			date2=fmt.parse(Endate);
			check2=1;
		}
		catch(ParseException e1) {					
			flag=0;
		}
	
	if(check1==1 && check2==1)
	{
		for(CustomerData dat:custReportList)
		{
			String amt=dat.getTotPrice();
			String d=dat.getShowDate();
			Date d1=null;
			try {
				d1=fmt.parse(d);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			  if(d1.compareTo(date2)<=0 && d1.compareTo(date1)>=0)
			  {
				count++;
				price=price+Double.parseDouble(amt);
				flag=1;
			  }
			}
			
		}
	else if(check1==0 || check2==0)
	{
		Result="Invalid dates";
		System.out.println(Result);
	}
	
	if(flag==1)
		{
		Result="Total bookings between the start date:"+Startdate+" and end date:" + Endate + " is " +count+ " Total revenue made is " + price;
		System.out.println(Result);
		}
	else if(check1==1 && check2==1 && flag==0){
			Result="No data available";
			System.out.println(Result);
		}
	 return Result;
	}
 
	
}


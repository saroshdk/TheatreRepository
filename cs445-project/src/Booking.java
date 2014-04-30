import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class Booking {
public Booking(){
		
	}
CustomerData cusdata=new CustomerData();
ArrayList<CustomerData> cList=new ArrayList<CustomerData>();
LoadFile l=new LoadFile();
ArrayList<ShowInfo> showList=l.parseFile();  
int Tot_price=0;
int check=0;
int flag=0;
	public void BookSeats() throws TransformerException{
		Scanner user_input=new Scanner(System.in);
		//Take user input
		System.out.println("Enter Customers details:\n");
		System.out.print("Enter first name:");
		String f_name=user_input.next();
		System.out.print("Enter last name:");
		String l_name=user_input.next();
		System.out.print("Enter email:");
		String e_mail=user_input.next();
		String validexpr="^[\\w\\.-]+@([\\w\\-]+\\.)+[a-z]{2,4}$";
		Pattern pat=Pattern.compile(validexpr);
		Matcher m=pat.matcher(e_mail);
		boolean matchEmail=m.matches();
		if(!matchEmail)
		{
			System.out.println("Not a valid email");
		}
		System.out.print("Enter phone:");
		String phone_n=user_input.next();
		System.out.println("Enter Payment Info:\n Enter card number");
		String cnum=user_input.next();
		System.out.print("Enter cvv number:");
		String cvv=user_input.next();
		System.out.print("Please enter show name:");
		String sname=user_input.next();
		System.out.println("Please enter date:");
		String date=user_input.next();
		boolean found;
		SimpleDateFormat sdfrmt=new SimpleDateFormat("dd-MMM-yyyy");
		Date cdate=null;
		try {
			cdate = sdfrmt.parse(date);
			found=true;
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			System.out.println("Not a valid date");
			found=false;
			//e1.printStackTrace();
		}
		//if date and email entered are valid
		if(found==true && matchEmail==true){	
		System.out.println("Please enter show time:");
		String time=user_input.next();
			
		for(ShowInfo data1 : showList)
		{
			String dat1=data1.getDate();
			 Date dat2=null;
			try {
				dat2 = new SimpleDateFormat("dd-MMM-yyyy").parse(dat1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(sname.toUpperCase().equals(data1.getName().toUpperCase()) && cdate.equals(dat2) && time.equals(data1.getTime())){
			System.out.println( "Available seats:\n Seat: " + data1.getSeat() + " price: " + data1.getPrice() +"\n");
			check=1;
			}			
		}
		if(check==1)
		{		
		String location="";
		System.out.println("Enter the number of seats you want to book:\n");
		int k=user_input.nextInt();
		//int flag=0;
		for(int p=0;p<k;p++)
		{			
			System.out.println("Choose a seat to book\n");		            
		  	   String s=user_input.next();
		try {
			  DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	          DocumentBuilder builder = factory.newDocumentBuilder();
	          Document dom = builder.parse("C:/Users/khan/Desktop/New folder/show.xml");
	          Element docEle = dom.getDocumentElement();
	              NodeList nl = docEle.getElementsByTagName("show");
	               if(nl != null && nl.getLength() > 0) {
	                       for(int i = 0 ; i < nl.getLength();i++) {
	                               Element element = (Element)nl.item(i);
	                               
	                               String name=getValue("name", element);
	                               String tdate=getValue("date", element);
	                               location=getValue("location", element);
	                               String t=getValue("time", element);
	                               String seat=getValue("seatnum", element);
	                               String price=getValue("price", element);
	                            //convert string date from show.xml file to Date format  
	                           Date pdate = new SimpleDateFormat("dd-MMM-yyyy").parse(tdate);
		                       if(sname.toUpperCase().equals(name.toUpperCase()) && cdate.equals(pdate) && time.equals(t) && s.equals(seat) )
                               {
		                    	   Tot_price+=Integer.parseInt(price);
                         		  System.out.println("Seat: " + seat + " booked and total price is: " + Tot_price);   
                         		docEle.removeChild((Node)element);
                         		flag=1;
                               }
                             }
	                      /* if(flag==0)
	                       {
	                    	   System.out.println("Invalid data");
	                       }*/
	               }
	               TransformerFactory transformerFactory = TransformerFactory.newInstance();
	       		Transformer transformer = transformerFactory.newTransformer();
	       		DOMSource source = new DOMSource(dom);
	       		StreamResult result = new StreamResult(new File("C:/Users/khan/Desktop/New folder/show.xml"));
	       		transformer.transform(source, result);
		                      } catch (Exception ex) {
		               			ex.printStackTrace();
		               			}
				}
		//if the show name,date,time and seat information entered by user is valid then do the booking and print the booking id and notification               		
		if(flag==1)
		{
			Random r=new Random();
			int id=Math.abs(r.nextInt());
			System.out.println("Booking ID is:" + id);
			String book_id=""+id;
		System.out.println("Email notification sent to customer " + f_name + " " + l_name + " at this email address " + e_mail);
		String tot_seats=Integer.toString(k);
		String tot_p=""+Tot_price;
		insertCustomerInfo(f_name,l_name,e_mail,phone_n,cnum,cvv,sname,date,time,tot_seats,tot_p,book_id,location);
		}
		}
		}
		 if(flag==0)
         {
      	   System.out.println("Invalid data");
         }
		
				
	}
	
		                
//insert the customer data into customer.xml file	
public void insertCustomerInfo(String f_name,String l_name,String e_mail,String phone_n,String cnum,String cvv,String sname,String date,String time,String tot_seats,String tot_p,String book_id,String location) throws TransformerException
{
	 DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {
			//Using factory get an instance of document builder
		    DocumentBuilder db = dbf.newDocumentBuilder();
                 //parse using builder to get DOM representation of the XML file
                 Document dom = db.parse("C:/Users/khan/Desktop/New folder/customer.xml");
                 Element docEle = (Element) dom.getDocumentElement();
                 NodeList nl;
                 nl = docEle.getElementsByTagName("customerdetails");
                                 
                         //Insert the record
                         Element newRec = dom.createElement("customerdetails");
                         docEle.appendChild(newRec);
                         setTextValue1(dom,newRec,"fname",f_name);
                         setTextValue1(dom,newRec,"lname",l_name);
                         setTextValue1(dom,newRec,"showname",sname);
                         setTextValue1(dom,newRec,"email",e_mail);
                          setTextValue1(dom,newRec,"phone",phone_n);
                         setTextValue1(dom,newRec,"cnum",cnum);
                         setTextValue1(dom,newRec,"cvv",cvv);
                         setTextValue1(dom,newRec,"sdate",date);
                         setTextValue1(dom,newRec,"stime",time);
                         setTextValue1(dom,newRec,"seats_book",tot_seats);
                         setTextValue1(dom,newRec,"tot_pri",tot_p);
                         setTextValue1(dom,newRec,"id",book_id);
                         setTextValue1(dom,newRec,"show_location",location);
                         
                         //add the customer data to the ArrayList cList
                         cusdata.setFName(f_name);
                         cusdata.setLName(l_name);
                         cusdata.setEmail(e_mail);
                         cusdata.setPhone(phone_n);
                         cusdata.setLocation(location);
                         cusdata.setCard_Num(cnum);
                         cusdata.setCvv(cvv);
                         cusdata.setShowDate(date);
                         cusdata.setTime(time);
                         cusdata.setTotSeat(tot_seats);
                         cusdata.setTotPrice(tot_p);
                         cusdata.setBooking(book_id);
                         cusdata.setShowName(sname);
                         cList.add(cusdata);
                                                                                           
             TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(dom);
		StreamResult result = new StreamResult(new File("C:/Users/khan/Desktop/New folder/customer.xml"));
		transformer.transform(source, result);
          
		}catch(  ParserConfigurationException | SAXException | IOException pce) {
		}
}

 private static String getValue(String tag, Element element) {
		NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
		Node node = (Node) nodes.item(0);
		return node.getNodeValue();
		}
 
public void setTextValue1(Document doct, Element ele, String tagName, String value) {
String textVal = null;
NodeList n2 = ele.getElementsByTagName(tagName);
if(n2 != null && n2.getLength() > 0) {
Element e2 = (Element)n2.item(0);
textVal = e2.getFirstChild().getNodeValue();
e2.getFirstChild().setNodeValue(value);
}
else
{
    Element age = doct.createElement(tagName);
age.appendChild(doct.createTextNode(value));
ele.appendChild(age);
}
}
}




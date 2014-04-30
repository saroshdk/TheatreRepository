
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class ReadCustData {
	
	public ReadCustData(){
	
	}
	CustomerData data2;
	ArrayList<CustomerData> custList=new ArrayList<CustomerData>();
	//to store the customer information in an ArrayList
public ArrayList<CustomerData> readFile(){
	try {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
          DocumentBuilder builder = factory.newDocumentBuilder();
          Document dom = builder.parse("C:/Users/khan/Desktop/New folder/customer.xml");
          Element docEle = dom.getDocumentElement();
              NodeList nl = docEle.getElementsByTagName("customerdetails");
               if(nl != null && nl.getLength() > 0) {
                       for(int i = 0 ; i < nl.getLength();i++) {

                               Element element = (Element)nl.item(i);
                               
                            String f_name=getValue("fname", element);
                               String l_name=getValue("lname", element);
                               String email=getValue("email", element);
                               String phone=getValue("phone", element);
                               String card=getValue("cnum", element);
                               String cvv=getValue("cvv", element);
                               String shname=getValue("showname", element);
                               String date=getValue("sdate", element);
                               String time=getValue("stime", element);
                               
                               String seats=getValue("seats_book", element);                               
                               String price=getValue("tot_pri", element);
                               String b_id=getValue("id", element);
                               String loc=getValue("show_location", element);
                              
                               data2=new CustomerData();
                               data2.setFName(f_name);
                               data2.setLName(l_name);
                               data2.setEmail(email);
                               data2.setPhone(phone);
                               data2.setCard_Num(card);
                               data2.setCvv(cvv);
                               data2.setShowDate(date);
                               data2.setShowName(shname);
                               data2.setTime(time);
                               data2.setTotSeat(seats);
                               data2.setTotPrice(price);
                               data2.setLocation(loc);
                               data2.setBooking(b_id);                               
                               custList.add(data2);                               
                       }
   			}
   			} catch (Exception ex) {
   			ex.printStackTrace();
   			}                                          
                      return custList;
	
}
                       private static String getValue(String tag, Element element) {
                    		NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
                    		Node node = (Node) nodes.item(0);
                    		return node.getNodeValue();
                    		}
}

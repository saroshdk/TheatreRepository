import java.io.File;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class CancelBooking {

	public CancelBooking(){
		
	}
	//cancel booking using the booking id
	public void cancel(String booking_id)
	{
		int flag=0;
		String Result="";
			try {
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		          DocumentBuilder builder = factory.newDocumentBuilder();
		          Document dom = builder.parse("C:/Users/khan/Desktop/New folder/customer.xml");
		          Element docEle = dom.getDocumentElement();
		              NodeList nl = docEle.getElementsByTagName("customerdetails");
		               if(nl != null && nl.getLength() > 0) {
		                       for(int i = 0 ; i < nl.getLength();i++) {

		                               Element element = (Element)nl.item(i);
		                              String b_id=getValue("id",element); 
		                              String fname=getValue("fname", element);
		                               String lname=getValue("lname", element);
		                               String email=getValue("email", element);
		                               String tot_price=getValue("tot_pri", element);
		                             if(b_id.equals(booking_id))
		                             {
		                            	 docEle.removeChild((Node)element);
		                            	 Result="Customer: " + fname +" "+lname+" notified through email "+email+" and total amount refunded "+tot_price;
		                            	 System.out.println(Result);
                                          flag=1;
		                            		}
		                         }
		               }
		               TransformerFactory transformerFactory = TransformerFactory.newInstance();
		       		Transformer transformer = transformerFactory.newTransformer();
		       		DOMSource source = new DOMSource(dom);
		       		StreamResult result = new StreamResult(new File("C:/Users/khan/Desktop/New folder/customer.xml"));
		       		transformer.transform(source, result);
				} catch (Exception ex) {
				ex.printStackTrace();
				}
			//to check whether the booking id provided is invalid
			if(flag==0)
			{
		        System.out.println("Invalid Booking ID");
		     }	
	}
	
	private static String getValue(String tag, Element element) {
		NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
		Node node = (Node) nodes.item(0);
		return node.getNodeValue();
		}

}


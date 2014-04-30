
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class LoadFile {
	public LoadFile(){
		
	}
	ShowInfo data1;
	ArrayList<ShowInfo> showList=new ArrayList<ShowInfo>();
	
	
	//Load and print the xml file
	 public void load(){
		 parseFile();
        
	for (ShowInfo data1 : showList) {
		System.out.println("Show Name: " + data1.getName()+ "\n" + "Date: " + data1.getDate() + "\n"+"Location: " + data1.getLocation() +  "\n" + 
                "Time: " + data1.getTime() + "\n" +
                "Seat: " + data1.getSeat() + "\n" + 
                "Price: "+data1.getPrice());   
	}
	 }
	 
	 //parse xml file using DOM parser
	public ArrayList<ShowInfo> parseFile(){
		
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
	                               String date=getValue("date", element);
	                               String location=getValue("location", element);
	                               String time=getValue("time", element);
	                               String seat=getValue("seatnum", element);
	                               String price=getValue("price", element);
	                               	                               
	                             data1=new ShowInfo();
	                             data1.setName(name);
	                             data1.setDate(date);
	                             data1.setLocation(location);
	                             data1.setTime(time);
	                             data1.setSeat(seat);
	                             data1.setPrice(price);
	                             showList.add(data1);
	                            
			}
			}
			} catch (Exception ex) {
			ex.printStackTrace();
			}
		
		return showList;
			}
	

			private static String getValue(String tag, Element element) {
			NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
			Node node = (Node) nodes.item(0);
			return node.getNodeValue();
			}

}

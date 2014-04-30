
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class CustomerDataTest {
CustomerData c=new CustomerData();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testgetFName() {
		c.setFName("sarosh");
		assertEquals(c.getFName(),"sarosh");
		
	}
	@Test
	public void testgetLName() {
		c.setLName("khatoon");
		assertEquals(c.getLName(),"khatoon");
		
	}
	@Test
	public void testgetPhone() {
		c.setPhone("7737503359");
		assertEquals(c.getPhone(),"7737503359");
		
	}
	@Test
	public void testgetEmail() {
		c.setEmail("sdk@gmail.com");
		assertEquals(c.getEmail(),"sdk@gmail.com");
		
	}
	@Test
	public void testgetCard_Num() {
		c.setCard_Num("123456789");
		assertEquals(c.getCard_Num(),"123456789");
		
	}
	@Test
	public void testgetCvv() {
		c.setCvv("786");
		assertEquals(c.getCvv(),"786");
		
	}
	@Test
	public void testgetShowName() {
		c.setShowName("Rio");
		assertEquals(c.getShowName(),"Rio");
		
	}
	@Test
	public void testgetShowDate() {
		c.setShowDate("10-Jul-2014");
		assertEquals(c.getShowDate(),"10-Jul-2014");
		
	}
	@Test
	public void testgetTime() {
		c.setTime("6pm");
		assertEquals(c.getTime(),"6pm");
		
	}
	@Test
	public void testgetLocation() {
		c.setLocation("Chicago");
		assertEquals(c.getLocation(),"Chicago");
		
	}
	@Test
	public void testgetBooking() {
		c.setBooking("3478202");
		assertEquals(c.getBooking(),"3478202");
		
	}
	@Test
	public void testgetTotSeat() {
		c.setTotSeat("2");
		assertEquals(c.getTotSeat(),"2");
		
	}
	@Test
	public void testgetTotprice() {
		c.setTotPrice("20");
		assertEquals(c.getTotPrice(),"20");
		
	}
	
	

}
